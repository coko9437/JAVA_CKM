package d250613.web_structure.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import d250613.member_project.model.Member;
import d250613.member_project.util.DateUtil;
import d250613.web_structure.service._5copy;


public class _4copy extends JFrame {

    
    // 테이블 구성 -> DefaultTableModel 에 데이터 입력 -> JTable 이 모델을 받아 화면에 테이블로 출력
    // 테이블에서 수정, 추가, 삭제, 검색하거나 tableModel 갱싱됨.
    private DefaultTableModel tableModel; // Swing에서 테이블 데이터를 저장/관리하는 기본 모델 클래스
    private JTable memberTable; // Swing에서 표 형태(UI) 의 테이블 컴포넌트

    // 검색 관련 컴포넌트
    private JTextField searchField; 
    private JButton searchBtn; 
    private JButton resetBtn; 
    // =============================================================
    
    // 필요한 요소 1) tableModel 2)searchField
    private _5copy service = new _5copy();

    public _4copy() {
        setTitle("회원 가입");
        setSize(900, 500);
        setLocationRelativeTo(null); // 화면에 중앙 배치.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        
        String[] cols = { "이름", "이메일", "패스워드", "가입일" };
        tableModel = new DefaultTableModel(cols, 0) { // 익명클래스,
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        
        service.setTableModel(tableModel);
        service.setSignupFrame(this);

        
        memberTable = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(memberTable); 

        JPanel btnPanel = new JPanel(); // JPanel 의 기본 배치 관리자, FlowLayout ,나란히 배치.
        JButton addBtn = new JButton("회원가입");
        JButton updateBtn = new JButton("수정");
        JButton deleteBtn = new JButton("삭제");
        JButton reloadBtn = new JButton("새로고침");
        
        JButton dummyBtn = new JButton("더미데이터추가");

        
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        btnPanel.add(reloadBtn);
        btnPanel.add(dummyBtn);

        
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);

        
        service.setSearchField(searchField);

        searchBtn = new JButton("검색");
        resetBtn = new JButton("검색 초기화");
        
        searchPanel.add(new JLabel("이름 또는 이메일 검색: "));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        searchPanel.add(resetBtn);

        
        setLayout(new BorderLayout());
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        


        service.loadMembersFromFile();

        // 새로고침 기능 호출.
        service.refreshTable();
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

        dummyBtn.addActionListener(e -> service.dummyMake());


    }

    public void showDialog(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    // 6) 회원 가입 입력 품, 다이얼 로그 창으로 작업, 자바버전으로
    private void showAddDialog() {
        // 이름, 이메일, 패스워드, 입력 창(한줄 공간)
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(15);
        JTextField passwordField = new JPasswordField(10);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 :"));
        panel.add(nameField);

        panel.add(new JLabel("이메일 :"));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 :"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(
                this, // 이 알림창을 어디에 나타나게 할거냐? this : 현재 윈도우 창
                panel, // 사용자에게 보여줄 콘텐츠 ( JPanel )
                "회원 가입", // 알림 창에서의 제목
                JOptionPane.OK_CANCEL_OPTION, // 확인, 취소 버튼을 구성하는 옵션
                JOptionPane.PLAIN_MESSAGE // 아이콘이 없는 일반 메시지 형식의 알림창을 의미함. 기본 알림창
        );

        // 확인 알림창에서 수락시, 데이터를 파일 저장 시스템.
        if (result == JOptionPane.OK_OPTION) {
            // 화면에서, 입력창에 입력 했던 데이터 들을 다 가지고 와서, 임의의 변수 담고,
            // Member 클래스 형식으로 인스턴스 만들고, , 리스트 members 추가하고,
            // 파일에 쓰기 작업함.
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String regDate = DateUtil.getCurrentDateTime();
            // 값 입출력시, 유효성 체크 하기.
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.");
                
                return;
            }
            // 인스턴스
            Member member = new Member(name, password, email, regDate);
            // members.add(member);
            service.addMember(member);
            JOptionPane.showMessageDialog(this, "회원 가입 되었습니다.");
            service.saveMembersToFile();
            // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            service.refreshTable();
        }
    }

    // 7) 회원 수정 창
    private void showUpdateDialog() {
        // 테이블 상에서, 선택된 행의 번호를 가져와서, 수정 작업,
        int row = memberTable.getSelectedRow();
        // 유효성 체크.
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "수정 할 회원을 선택하세요.");
            return;
        }
        
        Member oldMember = service.getMembers().get(row);

        
        JTextField nameField = new JTextField(oldMember.getName(), 10);
        JTextField emailField = new JTextField(oldMember.getEmail(), 15);
        JTextField passwordField = new JPasswordField(oldMember.getPassword(), 10);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("이름 :"));
        panel.add(nameField);

        panel.add(new JLabel("이메일 :"));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 :"));
        panel.add(passwordField);

        
        int result = JOptionPane.showConfirmDialog(
                this, // 이 알림창을 어디에 나타나게 할거냐? this : 현재 윈도우 창
                panel, // 사용자에게 보여줄 콘텐츠 ( JPanel )
                "회원 정보 수정", // 알림 창에서의 제목
                JOptionPane.OK_CANCEL_OPTION, // 확인, 취소 버튼을 구성하는 옵션
                JOptionPane.PLAIN_MESSAGE // 아이콘이 없는 일반 메시지 형식의 알림창을 의미함. 기본 알림창
        );

        // 확인 알림창에서 수락시, 데이터를 파일 저장 시스템.
        if (result == JOptionPane.OK_OPTION) {
         
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText().trim();
            String regDate = DateUtil.getCurrentDateTime();
         
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "모든 항목을 입력해주세요.");
                
                return;
            }
            
            
            // 수정 할 경우
            oldMember.setName(name);
            oldMember.setEmail(email);
            oldMember.setPassword(password);
            oldMember.setRegDate(regDate);
            service.saveMembersToFile();
            // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            service.refreshTable();
        }
    }

    // 8) 회원 삭제 기능.
    private void deleteSelectedMemberDialog() {
        
        int row = memberTable.getSelectedRow();
        // 유효성 체크.
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제 할 회원을 선택하세요.");
            return;
        }

        
        int result = JOptionPane.showConfirmDialog(
                this, // 이 알림창을 어디에 나타나게 할거냐? this : 현재 윈도우 창
                "정말 삭제하시겠습니까?", // 사용자에게 보여줄 콘텐츠 ( JPanel )
                "회원 삭제", // 알림 창에서의 제목
                JOptionPane.YES_NO_OPTION // 확인, 취소 버튼을 구성하는 옵션
        );

        // 확인 알림창에서 수락시, 데이터를 파일 저장 시스템.
        if (result == JOptionPane.YES_OPTION) {
            
            service.getMembers().remove(row);
            service.saveMembersToFile();
            // 변경사항 새로고침, 즉 다 지우고, 전체 회원을 다시 그리기.
            service.refreshTable();
        }
    }

}
// =================================================================
