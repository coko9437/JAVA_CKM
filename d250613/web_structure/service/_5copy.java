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

import d250613.member_project.model.Member_copy;
import d250613.member_project.util.DateUtil;

public class _5copy {
    
    private static final String FILE_NAME = "member.txt"; 

    private ArrayList<Member_copy> members = new ArrayList<>();
    

    private DefaultTableModel tableModel;
    private JTextField searchField;

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public ArrayList<Member_copy> getMember_copys(){
        return members;
    }

    public void addMember_copy(Member_copy member) {
        members.add(member);
        saveMember_copysToFile();
    }



// 1) .loadMember_copysFromFile() : csv파일에서 회원목록 불러오기
    public void loadMember_copysFromFile() { //임시 멤버의정보들을 담아두는 리스트
        members.clear(); // 모두비우기
        File file = new File(FILE_NAME);
        if(!file.exists()) { // 파일이 존재하지 않는다면~
            try { //새로운 파일 생성
                file.createNewFile();
                    System.out.println("새로운 파일을 생성했습니다. >>> " +FILE_NAME);
                
            } catch (Exception e) {
                
                System.out.println("다른 방법으로 알림등 알려줄 예정");
                return; // 현재 메소드 나가기
            }
        }
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Member_copy member = Member_copy.fromCSV(line);
                if (member != null) {
                    members.add(member);
                }
            }
        } catch (

        Exception e) {
        
            System.out.println("다른 방법으로 알림등 알려줄 예정");
        
        }
    }


// 2) .saveMember_copysToFile() : 목록을 csf파일에 저장
    public void saveMember_copysToFile() {
        
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8"))) {
            for (Member_copy member : members) {
                bw.write(member.toCsv());
                bw.newLine();
            }
        } catch (Exception e) {
                
            System.out.println("다른 방법으로 알림등 알려줄 예정");
        }
    }



// 3) JTable에 회원데이터 반영 (새로고침) ----전체 데이터를 조회
    public void refreshTable() {
        tableModel.setRowCount(0); 
        for(Member_copy member : members) {
            
            tableModel.addRow(new Object[]{ 
                member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }

    }



// 4) 검색 결과를 테이블에 반영   ----검색된 결과 멤버들만 조회 (기존 전체데이터를 삭제 한 후)
    public void showSearchResults(ArrayList<Member_copy> results) {
        tableModel.setRowCount(0); //setRowCount : 기존데이터를 모두 제거(모든 행 삭제)
        for(Member_copy member : results) {

            tableModel.addRow(new Object[]{ //tableModel에 데이터를 넣어줌
                member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }
    }


// 5) 검색기능 (이름 또는 이메일 검색어가 포함된 회원만표시), 검색결과만 표기
    public void searchMember_copys() {
        String query = searchField.getText().trim().toLowerCase(); //검색어입력창에서. 검색어 가져오기. 양쪽공백제거. 영어인경우 모두 소문자로 변경
        if(query.isEmpty()){
            refreshTable(); 
            return;
        }

        ArrayList<Member_copy> resultList = new ArrayList<>();

        for (Member_copy member : members) {
            if (member.getName().toLowerCase().contains(query) ||
                    member.getEmail().toLowerCase().contains(query)) {
                resultList.add(member);
            }
        }
        
        showSearchResults(resultList);

        if (resultList.isEmpty()) {

            System.out.println("다른 방법으로 알림등 알려줄 예정");
        }
    }


// 9) 더미데이터 추가하는 기능  <-- 굳이 화면에 보여줄 필요 X
    public void dummyMake() {
      
        for (int i = 0; i < 10; i++) {
            Member_copy dummyMember_copy = new Member_copy(
                    "더미회원" + (i + 1),
                    "password" + (i + 1),
                    "dummy" + (i + 1) + "@example.com",
                    DateUtil.getCurrentDateTime());
            members.add(dummyMember_copy);
        }

        saveMember_copysToFile();
        
        refreshTable();
        
        System.out.println("다른 방법으로 알림등 알려줄 예정");
        }


}
