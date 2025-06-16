package d250613.web_structure.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import d250613.member_project.model.Member;
import d250613.member_project.util.DateUtil;
import d250613.web_structure.ui._4SignupFrame;


public class _5MemberService {
    // 파일 불러오는 경로를 전역으로 설정
    private static final String FILE_NAME = "member.txt"; // 저장시킬 파일명(csv형식)
    // 파일에서 불러온 멤버의 모든 정보를 담아둘 임시 공간 리스트
    private ArrayList<Member> members = new ArrayList<>();
    
    // 없는 부분 받아서 임시로 사용하기.
    private DefaultTableModel tableModel;
    
    private JTextField searchField;

    public void setSignupFrame(_4SignupFrame signupFrame) {
        this.signupFrame = signupFrame;
    }

    private _4SignupFrame signupFrame;

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public ArrayList<Member> getMembers(){
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
        saveMembersToFile();
    }



// 1) .loadMembersFromFile() : csv파일에서 회원목록 불러오기
    public void loadMembersFromFile() { //임시 멤버의정보들을 담아두는 리스트
        members.clear(); // 모두비우기
        File file = new File(FILE_NAME);
        if(!file.exists()) { // 파일이 존재하지 않는다면~
            try { //새로운 파일 생성
                file.createNewFile();
                    System.out.println("새로운 파일을 생성했습니다. >>> " +FILE_NAME);
                
            } catch (Exception e) {
                // e.printStackTrace(); //로그기록 추적
                    //JOptionPane.showMessageDialog(this, "파일생성 오류"+ e.getMessage());// 웹으로 치면 alert("경고창");
                // 기존 클래스에서는, JFrame 상속을 받아서, 기능을 사용할 수있지만, 지금은 분리가 되어서,
                // 따로 구현이 하거나, 잠시 주석.
                // JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());
                // System.out.println("다른 방법으로 알림등 알려줄 예정");
                System.out.println(e.getMessage());
                return; // 현재 메소드 나가기
            }
        }
        // 파일이 있는경우
        // 파일에서 한줄씩 읽어서... members 리스트에 저장.
        // "member.txt" ==> {상용, lsy@naver.com, 1234, 2025-06-13 00:00:00}
            // Member 클래스의 인스턴스를 생성하는 재료로 사용됨.
        // 파일을 읽기작업, 반드시 try~catch작업 해야함.
        // 버퍼에 담아서 작업성능 향상
        
    //변경전 try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
        // 변경 후 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Member member = Member.fromCSV(line);
                if (member != null) {
                    members.add(member);
                }
            }
        } catch (

        Exception e) {
            // 오류 발생시 간단히 알림 창띄우기.
                // JOptionPane.showMessageDialog(this, "파일 읽기 오류 : " + e.getMessage());
            
            // JOptionPane.showMessageDialog(this, "파일 생성 오류 : " + e.getMessage());
            // System.out.println("다른 방법으로 알림등 알려줄 예정");
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }


// 2) .saveMembersToFile() : 목록을 csf파일에 저장
    public void saveMembersToFile() {
        // 파일에 저장시 버퍼를 이용 + try_resource
        // 전
        // try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
        // 후
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8"))) {
            for (Member member : members) {
                bw.write(member.toCsv());
                bw.newLine();
            }
        } catch (Exception e) {
                // JOptionPane.showMessageDialog(this, "파일저장 오류"+ e.getMessage());
            // System.out.println("다른 방법으로 알림등 알려줄 예정");
            System.out.println(e.getMessage());
        }
    }



// 3) JTable에 회원데이터 반영 (새로고침) ----전체 데이터를 조회
    public void refreshTable() {
        tableModel.setRowCount(0); //setRowCount : 기존데이터를 모두 제거(모든 행 삭제)
        for(Member member : members) {
            // tableModel에 데이터쓰기 : 기본 데이터테이블에 데이터를 쓰고, ->출력용 테이블 연결하기
            // System.out.println("데이터 출력시 깨지는 부분확인 이름: " + member.getName());
            tableModel.addRow(new Object[]{ //tableModel에 데이터를 넣어줌
                member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }

    }



// 4) 검색 결과를 테이블에 반영   ----검색된 결과 멤버들만 조회 (기존 전체데이터를 삭제 한 후)
    public void showSearchResults(ArrayList<Member> results) {
        tableModel.setRowCount(0); //setRowCount : 기존데이터를 모두 제거(모든 행 삭제)
        for(Member member : results) {
            // tableModel에 데이터쓰기 : 기본 데이터테이블에 데이터를 쓰고, ->출력용 테이블 연결하기
            tableModel.addRow(new Object[]{ //tableModel에 데이터를 넣어줌
                member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }
    }


// 5) 검색기능 (이름 또는 이메일 검색어가 포함된 회원만표시), 검색결과만 표기
    public void searchMembers() {
        String query = searchField.getText().trim().toLowerCase(); //검색어입력창에서. 검색어 가져오기. 양쪽공백제거. 영어인경우 모두 소문자로 변경
        if(query.isEmpty()){
            refreshTable(); // 기본 전체조회 실행
            return; // 검색기능 메서드 나가기.
        }
        // 임시로 담아둘 멤버리스트 하나 정의.
        ArrayList<Member> resultList = new ArrayList<>();
            // resultList : 아래 반복문에서 검색어 일치하는 멤버들 만 담을공간임.
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(query) ||
                    member.getEmail().toLowerCase().contains(query)) {
                resultList.add(member);
            }
        }
        // 검색된결과를 화면에 출력하는메서드에 그 결과를 넘겨주기
        showSearchResults(resultList);

        // 검색된 결과가 없다면 알림창으로 알려주기.
        if (resultList.isEmpty()) {
                // JOptionPane.showMessageDialog(this, "검색결과가 없습니다. ");
            // System.out.println("다른 방법으로 알림등 알려줄 예정");
            signupFrame.showDialog("검색 결과가 없습니다.");
        }
    }


// 9) 더미데이터 추가하는 기능  <-- 굳이 화면에 보여줄 필요 X
    public void dummyMake() {
        // 반복문으로 더미 데이터 10개 정도 넣기.
        for (int i = 0; i < 10; i++) {
            Member dummyMember = new Member(
                    "더미회원" + (i + 1),
                    "password" + (i + 1),
                    "dummy" + (i + 1) + "@example.com",
                    DateUtil.getCurrentDateTime());
            members.add(dummyMember);
        }

        saveMembersToFile();
        // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
        refreshTable();
        // 10명의 더미 회원 추가 확인 다이얼로그창 띄우기.
            // JOptionPane.showMessageDialog(this, "10명의 더미 회원 추가!!");
        // System.out.println("다른 방법으로 알림등 알려줄 예정");
        signupFrame.showDialog(" 더미회원 10명 추가");
        }


}
