package d250613.web_structure.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import d250613.member_project.util.DateUtil;
import d250613.web_structure.service._5MemberService;
import d250613.member_project.model.Member;

// 원래 목적, 화면 제공, + 기능 : 결과, 코드가 길어짐. 
// 기능 테스트, 
// 기능 분리, 

public class _4SignupFrame extends JFrame{

//추가[[[========================================================================
    // // 파일 불러오는 경로를 전역으로 설정
    // private static final String FILE_NAME = "member.txt"; // 저장시킬 파일명(csv형식)
    // // 파일에서 불러온 멤버의 모든 정보를 담아둘 임시 공간 리스트
    // private ArrayList<Member> members = new ArrayList<>();

    // Swing 관련 변수
    // 테이블 구성 -> DefaultTableModel 에 데이터입력함. -> JTable 이모델을 받아 화면에 테이블로 출력

    private DefaultTableModel tableModel; // Swing에서 테이블 데이터를 저장/관리하는 기본모델클래스
    private JTable memberTable; // Swing에서 표 형태(GUI) 테이블 컴포넌트.

    //검색관련 컴포넌트
    private JTextField searchField; //검색어 입력할 수 있는 입력창
    private JButton searchBtn; // 검색버튼
    private JButton resetBtn; // 초기화버튼
//]]]========================================================================


//추가[[[========================================================================
    // 리팩토리 중,
    // 필요한 요소 1) tableModel 2)searchField
    private _5MemberService service = new _5MemberService();

//]]]========================================================================


    public _4SignupFrame() { //Frame 창
        setTitle("_4회원가입 Frame");   
        setSize(900,400);    
        setLocationRelativeTo(null); // 화면 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

//추가[[[=======================================================================
    // 테이블 작업부터 진행하기.
    // 1) 테이블 헤더 만들기... 이름/ 이메일/ 패스워드/ 가입일
    String[] cols = {"이름", "이메일", "패스워드", "가입일"};
    tableModel = new DefaultTableModel(cols,0) { // (헤더제목,0)== 빈테이블 생성
        public boolean isCellEditable(int row, int column) {
            return false; // 각 테이블 셀 클릭시 값이 변경이 되는모드 (false -> 변경안되게함)

        }
    };

        // 추가
        service.setTableModel(tableModel);
        
    memberTable = new JTable(tableModel); // 표 형태의 데이터(tableModel)를 => 화면출력용 테이블(memberTable)에 데이터연결.
    // 스크롤이 가능하게
    JScrollPane scrollPane = new JScrollPane(memberTable); // 스크롤기능이 있는 패널(scrollPane)에 => 테이블 연경

    // 버튼추가(-> 패널에) JPanel : 기본배치 => FlowLayout
    JPanel btnPanel = new JPanel();
    JButton addBtn = new JButton("회원가입 버튼");
    JButton updateBtn = new JButton("수정 버튼");
    JButton deleteBtn = new JButton("삭제 버튼");
    JButton reloadBtn = new JButton("새로고침 버튼");
    JButton dummyBtn = new JButton("더미데이터추가");

    btnPanel.add(addBtn);
    btnPanel.add(updateBtn);
    btnPanel.add(deleteBtn);
    btnPanel.add(reloadBtn);
    btnPanel.add(dummyBtn);

    //검색패널 생성
    JPanel searchPanel = new JPanel();
    searchField = new JTextField(20);

        // 추가.
        service.setSearchField(searchField);

    searchBtn = new JButton("검색");
    resetBtn = new JButton("검색초기화");

    // 패널에 버튼 추가
    searchPanel.add(new JLabel("이름 또는 이메일로 검색 "));
        // 이벤트리스너를 사용하지않을거라서 그냥 일회용으로 만듬. (변수작업 X)
    searchPanel.add(searchField);
    searchPanel.add(searchBtn);
    searchPanel.add(resetBtn);

    // 레이아웃 배치 ( 스크롤패널, 버튼패널, 검색패널)
    setLayout(new BorderLayout());
    add(searchPanel,BorderLayout.NORTH);
    add(scrollPane,BorderLayout.CENTER);
    add(btnPanel,BorderLayout.SOUTH);


//]]]========================================================================
    
//추가[[[=======================================================================
// 각 버튼에 기능들 이벤트핸들러 작업.

    // 파일에서 데이터 불러오고 , 테이블 표시, 메서드 호출
        service.loadMembersFromFile();

        // 새로고침 기능 호출.
        service.refreshTable();

        // 각각의 버튼에 , 기능들을 붙이는 작업 이벤트 핸들러 작업.
        // 회원 가입
        addBtn.addActionListener(e -> showAddDialog());
        // 수정.
        updateBtn.addActionListener(e -> showUpdateDialog());
        // 삭제
        deleteBtn.addActionListener(e -> deleteSelectedMemberDialog());
        // 새로고침
        reloadBtn.addActionListener(e -> {
            service.loadMembersFromFile();
            service.refreshTable();
        });
        // 검색
        searchBtn.addActionListener(e -> service.searchMembers());
        // 검색 초기화
        resetBtn.addActionListener(e -> {
            searchField.setText("");
            service.refreshTable();
        });
        // 검색어에서, 엔터를 입력해도, 실행이 되게끔.
        searchField.addActionListener(e -> service.searchMembers());

        // 더미데이터 기능 추가 이벤트리스너 추가
        dummyBtn.addActionListener(e -> service.dummyMake());

        // 안내문구 표시
        // JLabel label = new JLabel("회원가입 화면을 보고있습니다.");
        // add(label);
        
    
    }
// 1) .loadMembersFromFile() : csv파일에서 회원목록 불러오기
    // private void loadMembersFromFile() { //임시 멤버의정보들을 담아두는 리스트
    //     members.clear(); // 모두비우기
    //     File file = new File(FILE_NAME);
    //     if(!file.exists()) { // 파일이 존재하지 않는다면~
    //         try { //새로운 파일 생성
    //             file.createNewFile();
    //                 System.out.println("새로운 파일을 생성했습니다. >>> " +FILE_NAME);
                
    //         } catch (Exception e) {
    //             // e.printStackTrace(); //로그기록 추적
    //             JOptionPane.showMessageDialog(this, "파일생성 오류"+ e.getMessage());// 웹으로 치면 alert("경고창");
    //                 return; // 현재 메소드 나가기
    //         }
    //     }
    //     // 파일이 있는경우
    //     // 파일에서 한줄씩 읽어서... members 리스트에 저장.
    //     // "member.txt" ==> {상용, lsy@naver.com, 1234, 2025-06-13 00:00:00}
    //         // Member 클래스의 인스턴스를 생성하는 재료로 사용됨.
    //     // 파일을 읽기작업, 반드시 try~catch작업 해야함.
    //     // 버퍼에 담아서 작업성능 향상
        
    // //변경전 try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
    //     // 변경 후 
    //     try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "UTF-8"))) {
    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             Member member = Member.fromCSV(line);
    //             if (member != null) {
    //                 members.add(member);
    //             }
    //         }
    //     } catch (

    //     Exception e) {
    //         // 오류 발생시 간단히 알림 창띄우기.
    //         JOptionPane.showMessageDialog(this, "파일 읽기 오류 : " + e.getMessage());
    //         // TODO: handle exception
    //     }
    // }
    

// 2) .saveMembersToFile() : 목록을 csf파일에 저장
    // private void saveMembersToFile() {
    //     // 파일에 저장시 버퍼를 이용 + try_resource
    //     // 전
    //     // try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
    //     // 후
    //     try (BufferedWriter bw = new BufferedWriter(
    //             new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8"))) {
    //         for (Member member : members) {
    //             bw.write(member.toCsv());
    //             bw.newLine();
    //         }
    //     } catch (Exception e) {
    //         JOptionPane.showMessageDialog(this, "파일저장 오류"+ e.getMessage());
    //     }
    // }


// // 3) JTable에 회원데이터 반영 (새로고침) ----전체 데이터를 조회
//     private void refreshTable() {
//         tableModel.setRowCount(0); //setRowCount : 기존데이터를 모두 제거(모든 행 삭제)
//         for(Member member : members) {
//             // tableModel에 데이터쓰기 : 기본 데이터테이블에 데이터를 쓰고, ->출력용 테이블 연결하기
//             // System.out.println("데이터 출력시 깨지는 부분확인 이름: " + member.getName());
//             tableModel.addRow(new Object[]{ //tableModel에 데이터를 넣어줌
//                 member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
//             });
//         }

//     }


// // 4) 검색 결과를 테이블에 반영   ----검색된 결과 멤버들만 조회 (기존 전체데이터를 삭제 한 후)
//     private void showSearchResults(ArrayList<Member> results) {
//         tableModel.setRowCount(0); //setRowCount : 기존데이터를 모두 제거(모든 행 삭제)
//         for(Member member : members) {
//             // tableModel에 데이터쓰기 : 기본 데이터테이블에 데이터를 쓰고, ->출력용 테이블 연결하기
//             tableModel.addRow(new Object[]{ //tableModel에 데이터를 넣어줌
//                 member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
//             });
//         }
//     }


// // 5) 검색기능 (이름 또는 이메일 검색어가 포함된 회원만표시), 검색결과만 표기
//     private void searchMembers() {
//         String query = searchField.getText().trim().toLowerCase(); //검색어입력창에서. 검색어 가져오기. 양쪽공백제거. 영어인경우 모두 소문자로 변경
//         if(query.isEmpty()){
//             refreshTable(); // 기본 전체조회 실행
//             return; // 검색기능 메서드 나가기.
//         }
//         // 임시로 담아둘 멤버리스트 하나 정의.
//         ArrayList<Member> resultList = new ArrayList<>();
//             // resultList : 아래 반복문에서 검색어 일치하는 멤버들 만 담을공간임.
//         for(Member member : members) { //members : 파일에서 읽어서 임시로 담아둔 전체멤버리스트
//             if(member.getName().toLowerCase().contains(query) ||
//                 member.getEmail().toLowerCase().contains(query)) {
//                     resultList.add(member);
//                 }
//         }
//         // 검색된결과를 화면에 출력하는메서드에 그 결과를 넘겨주기
//         showSearchResults(resultList);

//         // 검색된 결과가 없다면 알림창으로 알려주기.
//         if (resultList.isEmpty()) {
//             JOptionPane.showMessageDialog(this, "검색결과가 없습니다. ");
//         }
//     }


// // 6) 회원가입 입력폼 <- 다이얼로그 창으로 작업(자바)
    private void showAddDialog() {
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(18);
        JPasswordField passwordField = new JPasswordField(10);

        // 그리드 레이아웃으로 2열짜리 배치작업
        
        JPanel panel = new JPanel(new GridLayout(0,2)); //행(row)를 0으로 표기시 -> 행의 갯수를 자동으로 생성하겠다는 의미.
        panel.add(new JLabel("이름 : "));
        panel.add(nameField);

        panel.add(new JLabel("이메일 : "));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 : "));
        panel.add(passwordField);

            // 회원가입 버튼을 누를경우 확인알림창 띄우기.
        int result = JOptionPane.showConfirmDialog(this,  // this ? 현재 윈도우 창
            panel, // 보여줄 컨텐츠 (JPanel)
             "회원가입", // 알림창의 제목 
            JOptionPane.OK_CANCEL_OPTION, // JOptionPane.OK_CANCEL_OPTION : 확인/취소 버튼
            JOptionPane.PLAIN_MESSAGE); // 아이콘이 없는 일반메시지 형식의 알림창임.

            // 확인버튼 클릭 -> JOptionPane.showConfirmDialog() 가 특정 값을 반환.
            // 수락 결과 -> OK옵션이 지정한 상수값을 반환, 시스템이 외우지않고 


            // 확인 알림창에서 수락 -> 데이터 파일을 저장하는시스템
            if (result == JOptionPane.OK_OPTION) {
                // 화면에서 입력창에 입력했던 데이터 들을 다 가지고와서
                // 임의의 변수에 담고, Member 클래스 형식의 인스턴스를 만들고,
                // 리스트 members 추가하고, 파일에 쓰기 작업.
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String regDate = DateUtil.getCurrentDateTime();
                    // 값 입출력시 유효성체크
                    if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "검색결과가 없습니다. ");
                        return;
                    }
                    
                    // 입력 끝. 인스턴스 생성하기
                    Member member = new Member(name, password, email, regDate);
                        // members.add(member);
                    service.addMember(member);
                        // saveMembersToFile();
                    service.saveMembersToFile();
                    service.refreshTable(); // 변경사항 새로고침 (다지우고 전체회원 다시채우기)
            }
        }


// 7) 회원수정창
    private void showUpdateDialog() {

        int row = memberTable.getSelectedRow();
        if (row == -1) { // 유효성체크
            JOptionPane.showMessageDialog(this, "수정 할 회원을 클릭하세요. ");
            return;
        }
        // 전체회원 목록리스트에 해당회원 정보를 가져오기.
            // Member oldMember = members.get(row); 
        Member oldMember = service.getMembers().get(row);
        // 이름, 이메일, 패스워드 입력창(한줄공간)
        // 가입시에, 새롭게 내용을 입력을했다면,
        // 기존 회원의 정보를 먼저 불러오고, 필요한 부분만 수정할 예정.
    
        JTextField nameField = new JTextField(oldMember.getName(),10);
        JTextField emailField = new JTextField(oldMember.getEmail(),18);
        JPasswordField passwordField = new JPasswordField(oldMember.getPassword(),10);

        // 그리드 레이아웃으로 2열짜리 배치작업
        
        JPanel panel = new JPanel(new GridLayout(0,2)); //행(row)를 0으로 표기시 -> 행의 갯수를 자동으로 생성하겠다는 의미.
        panel.add(new JLabel("이름 : "));
        panel.add(nameField);

        panel.add(new JLabel("이메일 : "));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 : "));
        panel.add(passwordField);

        // 회원가입 버튼을 누를경우 확인알림창 띄우기.
        int result = JOptionPane.showConfirmDialog(this,  // this ? 현재 윈도우 창
            panel, // 보여줄 컨텐츠 (JPanel)
             "회원정보수정", // 알림창의 제목 
            JOptionPane.OK_CANCEL_OPTION, // JOptionPane.OK_CANCEL_OPTION : 확인/취소 버튼
            JOptionPane.PLAIN_MESSAGE); // 아이콘이 없는 일반메시지 형식의 알림창임.

            // 확인버튼 클릭 -> JOptionPane.showConfirmDialog() 가 특정 값을 반환.
            // 수락 결과 -> OK옵션이 지정한 상수값을 반환, 시스템이 외우지않고 


            // 확인 알림창에서 수락 -> 데이터 파일을 저장하는시스템
            if (result == JOptionPane.OK_OPTION) {
                // 화면에서 입력창에 입력했던 데이터 들을 다 가지고와서
                // 임의의 변수에 담고, Member 클래스 형식의 인스턴스를 만들고,
                // 리스트 members 추가하고, 파일에 쓰기 작업.
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String regDate = DateUtil.getCurrentDateTime();
                    // 값 입출력시 유효성체크
                    if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "검색결과가 없습니다. ");
                        return;
                    }
                    
                    // 입력 끝. 인스턴스 생성하기
                    // Member member = new Member(name, password, email, regDate);
                    // members.add(member);
                    oldMember.setName(name);
                    oldMember.setEmail(email);
                    oldMember.setPassword(password);
                    oldMember.setRegDate(regDate);
                    service.saveMembersToFile();
                    service.refreshTable(); // 변경사항 새로고침 (다지우고 전체회원 다시채우기)
            }

    }


// 8) 회원삭제기능
    private void deleteSelectedMemberDialog() {
        // 테이블 상에서, 선택된 행의 번호를 가져와서, 수정 작업,
        int row = memberTable.getSelectedRow();
        // 유효성 체크.
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제 할 회원을 선택하세요.");
            return;
        }

        // 회원 수정 확인 버튼 누를 경우, 확인 알림창 띄우기.
        // 확인 버튼 클릭 -> JOptionPane.showConfirmDialog() -> 특정 값을 반환.
        // 수락 -> 결과 OK 옵션 지정한 상수값 , 외우지, 이름으로 지정.
        // 수락 -> JOptionPane.OK_OPTION
        int result = JOptionPane.showConfirmDialog(
                this, // 이 알림창을 어디에 나타나게 할거냐? this : 현재 윈도우 창
                "정말 삭제하시겠습니까?", // 사용자에게 보여줄 콘텐츠 ( JPanel )
                "회원 삭제", // 알림 창에서의 제목
                JOptionPane.YES_NO_OPTION // 확인, 취소 버튼을 구성하는 옵션
        );

        // 확인 알림창에서 수락시, 데이터를 파일 저장 시스템.
        if (result == JOptionPane.YES_OPTION) {
            // 리스트에 해당 멤버 삭제,
            // members.remove(row);
            service.getMembers().remove(row);
            service.saveMembersToFile();
            // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            service.refreshTable();
        }
    }


// // 9) 더미데이터 추가하는 기능  <-- 굳이 화면에 보여줄 필요 X
//     private void dummyMake() {
//         // 반복문으로 더미 데이터 10개 정도 넣기.
//         for (int i = 0; i < 10; i++) {
//             Member dummyMember = new Member(
//                     "더미회원" + (i + 1),
//                     "password" + (i + 1),
//                     "dummy" + (i + 1) + "@example.com",
//                     DateUtil.getCurrentDateTime());
//             members.add(dummyMember);
//         }

//         saveMembersToFile();
//         // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
//         refreshTable();
//         // 10명의 더미 회원 추가 확인 다이얼로그창 띄우기.
//         JOptionPane.showMessageDialog(this, "10명의 더미 회원 추가!!");
//         }



}

