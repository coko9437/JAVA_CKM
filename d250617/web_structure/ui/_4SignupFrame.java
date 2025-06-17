package d250617.web_structure.ui;

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

import d250617.web_structure.util.DateUtil;
import d250617.web_structure.service._5MemberService;
import d250617.web_structure.dto._10Member;

// 원래 목적, 화면 제공, + 기능 : 결과, 코드가 길어짐. 
// 기능 테스트, 
// 기능 분리, 

public class _4SignupFrame extends JFrame{


    // Swing 관련 변수
    // 테이블 구성 -> DefaultTableModel 에 데이터입력함. 
        // -> JTable 이모델을 받아 화면에 테이블로 출력

    private DefaultTableModel tableModel; // 테이블 데이터를 저장/관리하는 기본모델클래스
    private JTable memberTable; // 표 형태(GUI) 테이블 컴포넌트.(화면출력)

    //검색관련 컴포넌트
    private JTextField searchField; //검색어 입력할 수 있는 입력창
    private JButton searchBtn; // 검색버튼
    private JButton resetBtn; // 초기화버튼

    // 필요한 요소 1) tableModel 2)searchField
    private _5MemberService service = new _5MemberService(); //중요!!!!!!!!!!!!


    public _4SignupFrame() { //Frame 창
        setTitle("_4회원가입 Frame");   
        setSize(900,400);    
        setLocationRelativeTo(null); // 화면 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    // 테이블 작업부터
    // 1) 테이블 헤더 만들기... 이름/ 이메일/ 패스워드/ 가입일
    // 변경 전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // String[] cols = {"이름", "이메일", "패스워드", "가입일"};
    // 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        String[] cols = {"아이디", "이름", "이메일", "패스워드", "가입일"};
        tableModel = new DefaultTableModel(cols,0) { // (헤더제목,0)== 빈테이블 생성
            public boolean isCellEditable(int row, int column) {
            return false; // 각 테이블 셀 클릭시 값이 변경이 되는모드 (false -> 변경안되게함)
            }
    };

        // 추가
        service.setTableModel(tableModel);
        service.setSignupFrame(this);

        // 표 형태의 데이터(tableModel)를 => 화면출력용 테이블(memberTable)에 데이터연결.
        memberTable = new JTable(tableModel);
        // 스크롤기능이 있는 패널(scrollPane)에 => 테이블 연경
        JScrollPane scrollPane = new JScrollPane(memberTable); 

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


// 각 버튼에 기능들 이벤트핸들러 작업.
    // 0617 
    // 변경 전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 파일에서 데이터 불러오고 , 테이블 표시, 메서드 호출
        // service.loadMembersFromFile();
    // 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        service.loadMembersFromDB();
        // 새로고침 기능 호출.
        service.refreshTable();

        // 회원 가입
        addBtn.addActionListener(e -> showAddDialog());
        // 수정.
        updateBtn.addActionListener(e -> showUpdateDialog());
        // 삭제
        deleteBtn.addActionListener(e -> deleteSelectedMemberDialog());
        // 새로고침
        reloadBtn.addActionListener(e -> { // service.loadMembersFromFile();
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

    // 각 기능들 정의,
    public void showDialog(String msg) {
        JOptionPane.showMessageDialog(this, msg); // this : 이 키워드는 "현재 인스턴스", 즉 이 showDialog 메서드가 포함되어 있는 해당 JFrame이나 JDialog 인스턴스를 의미
    }   // ㄴ 해당 윈도우 위에 메시지 대화 상자를 하나 띄우는 것!

// 6) 회원가입 입력폼 <- 다이얼로그 창으로 작업(자바)
    private void showAddDialog() {
        // 이름, 이메일, 패스워드, 입력 창(한줄 공간)
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(18);
        JPasswordField passwordField = new JPasswordField(10);

        // 그리드 레이아웃으로 2열짜리 배치작업
        
        JPanel panel = new JPanel(new GridLayout(0,2)); //행(row)를 0으로 표기 -> 행의 갯수를 자동으로 생성하겠다는 의미.
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
                // 임의의 변수에 담아 Member 클래스 형식의 인스턴스를 만들고,

                // 리스트 members 추가하고, 파일에 쓰기 작업!
                    //입력받은 이름~패스워드를 공백제거하고 각 변수에 담음.
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String regDate = DateUtil.getCurrentDateTime();
                    // 값 입출력시 유효성체크
                    if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "빈 항목을 입력하세요요. ");
                        return;
                    }
                    
                    // 입력 끝. 인스턴스 생성하기
// 변경전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                    // _10Member member = new _10Member(result, name, email, password, regDate);
                    // members.add(member);
                           
                    // service.addMember(member);
                    // JOptionPane.showMessageDialog(this, "회원 가입 되었습니다.");
                    //     // saveMembersToFile();
                    // service.saveMembersToFile();
                    
// 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                    // (1) 회원가입 화면에서 넘겨받은 데이터정보(GUI) 
                            // 즉, 변수 name~ password -> member에 담기
                        // 매개변수인 ID는 큰의미가없음 -> 디비에 넣을때 자동으로 생성되서.
                    _10Member member = new _10Member(1, name, email, password, regDate);
                    // (2) insert메서드 : 입력받은 회원정보인 member를 전달
                    service.addMemberDB(member);
                        JOptionPane.showMessageDialog(this, "회원 가입 되었습니다.");

// 변경 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                    // 회원가입후 디비에서 변경된 데이터 다시 불러오기.
                    service.loadMembersFromDB();

                    service.refreshTable(); // 변경사항 새로고침 (다지우고 전체회원 다시채우기)
            }
        }


// 7) 회원수정창
    private void showUpdateDialog() {

// 변경 전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // 테이블상에서 선택된 행의 번호를 가져와서 수정작업. row(0)~
        int row = memberTable.getSelectedRow();
// 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // 테이블상에서 선택된 행(row)이 아닌 실제 ID값 만 가져오려면
        Object value = memberTable.getValueAt(row, 0);
            System.out.println("클릭시 가져온 값 확인 테스트 : " + value);
        // ㄴ 실제 멤버 ID를 Int로 변환해야함.
        // 전역으로 사용할 변환된 ID를 따로 선언.
        int member_id;
        if (value instanceof Integer) {
            member_id = ((Integer)value).intValue(); //정수로 뽑아냄
                System.out.println("선택된 ID 정수화 : " +member_id);
        }
        member_id = ((Integer) value).intValue();
            System.out.println("선택된 ID 정수화 2: " + member_id);
        if (row == -1) { // 유효성체크 (클릭안하면 -1이므로로)
            JOptionPane.showMessageDialog(this, "수정 할 회원을 클릭하세요. ");
            return;
        }
        
        // 전체회원 목록리스트에 해당회원 정보를 가져오기.
            // Member oldMember = members.get(row); 

// 변경 전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // 단순 리스트에 등록된 순서로 데이터를 가져오고있음.
        // _10Member oldMember = service.getMembers().get(row);
// 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // 실제 데이터에서, 해당 ID 번호로 회원의 정보를 가져오기.
        // 한명의 회원정보를 가져오는 DAO 메서드가 필요함.
        _10Member oldMember = service.getMemberOne(member_id);
        
            // 실제 멤버의 ID를 int타입으로 변환.

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

        // 회원 수정 확인 버튼 누를 경우, 확인 알림창 띄우기.
        // 확인 버튼 클릭 -> JOptionPane.showConfirmDialog() -> 특정 값을 반환.
        // 수락시 -> 결과 : OK 옵션 지정한 상수값, 이름으로 지정.
        int result = JOptionPane.showConfirmDialog(this,  // 이 알림창을 어디에 나타나게? this ? (현재 윈도우 창)
            panel, // 보여줄 컨텐츠 (JPanel)
             "회원정보 수정", // 알림창의 제목 
            JOptionPane.OK_CANCEL_OPTION, // : 확인/취소 버튼
            JOptionPane.PLAIN_MESSAGE); // 아이콘이 없는 일반메시지 형식의 알림창임.

            // 확인 알림창에서 수락 -> 데이터 파일을 저장하는시스템
            if (result == JOptionPane.OK_OPTION) {

                // 화면에서 입력창에 입력했던 데이터 들을 다 가지고와서
                // 임의의 변수에 담아 Member 클래스 형식의 인스턴스를 만들고,
                // 리스트 members 추가하고, 파일에 쓰기 작업!
                    // 입력받은 이름~패스워드를 공백제거하고 각 변수에 담음.
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String regDate = DateUtil.getCurrentDateTime();
                    // 값 입출력시 유효성체크
                    if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "검색결과가 없습니다. ");
                        return;
                    }
                    
                    //수정했으므로 oldMember에 담음.
// 변경 전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ                    
                    // oldMember.setName(name);
                    // oldMember.setEmail(email);
                    // oldMember.setPassword(password);
                    // oldMember.setRegDate(regDate);
                    // service.saveMembersToFile();
                    // service.refreshTable(); // 변경사항 새로고침 (다지우고 전체회원 다시채우기)
// 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
                    // (1)화면에서 변경할 데이터를 멤버에담기.
                    oldMember.setName(name);
                    oldMember.setEmail(email);
                    oldMember.setPassword(password);

                    // 회원수정 디버깅1
                        // 디비에 수정 된 내용 반영하기전에 데이터 확인
                        System.out.println("수정하기전 데이터 확인 : " +oldMember);

                    // oldMember.setRegDate(regDate);
                    // (2)수정하는 메서드에 변경할 멤버 객체 전달하기. + 수정할 인덱스도 같이 넘기기
                    service.updateMember(oldMember);

                    // 회원 수정후에 변경사항 반영
                        // 회원 변경 후, 디비에서 변경된 데이터를 다시 불러오기.
                    service.loadMembersFromDB();

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

    // Removed duplicate showDialog(String) method to resolve compilation error.


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

