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
import d250613.web_structure.service._5copy;
import d250613.member_project.model.Member_copy;

 

public class _4copy extends JFrame{

    private DefaultTableModel tableModel; 
    private JTable memberTable; 

    
    private JTextField searchField; 
    private JButton searchBtn; 
    private JButton resetBtn; 

    private _5copy service = new _5copy();




    public _4copy() { //Frame 창
        setTitle("_4회원가입 Frame");   
        setSize(900,400);    
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    
    String[] cols = {"이름", "이메일", "패스워드", "가입일"};
    tableModel = new DefaultTableModel(cols,0) { 
        public boolean isCellEditable(int row, int column) {
            return false; 

        }
    };

        // 추가
        service.setTableModel(tableModel);
        
    memberTable = new JTable(tableModel); 
 
    JScrollPane scrollPane = new JScrollPane(memberTable); 

    
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

    
    JPanel searchPanel = new JPanel();
    searchField = new JTextField(20);

        
        service.setSearchField(searchField);

    searchBtn = new JButton("검색");
    resetBtn = new JButton("검색초기화");

    
    searchPanel.add(new JLabel("이름 또는 이메일로 검색 "));
        
    searchPanel.add(searchField);
    searchPanel.add(searchBtn);
    searchPanel.add(resetBtn);


    setLayout(new BorderLayout());
    add(searchPanel,BorderLayout.NORTH);
    add(scrollPane,BorderLayout.CENTER);
    add(btnPanel,BorderLayout.SOUTH);




        service.loadMember_copysFromFile();

        service.refreshTable();

        
        addBtn.addActionListener(e -> showAddDialog());
        // 수정.
        updateBtn.addActionListener(e -> showUpdateDialog());
        // 삭제
        deleteBtn.addActionListener(e -> deleteSelectedMember_copyDialog());
        // 새로고침
        reloadBtn.addActionListener(e -> {
            service.loadMember_copysFromFile();
            service.refreshTable();
        });
        // 검색
        searchBtn.addActionListener(e -> service.searchMember_copys());
        // 검색 초기화
        resetBtn.addActionListener(e -> {
            searchField.setText("");
            service.refreshTable();
        });
        // 검색어에서, 엔터를 입력해도, 실행이 되게끔.
        searchField.addActionListener(e -> service.searchMember_copys());

        // 더미데이터 기능 추가 이벤트리스너 추가
        dummyBtn.addActionListener(e -> service.dummyMake());        
    
    }

// 6) 회원가입 입력폼 <- 다이얼로그 창으로 작업(자바)
    private void showAddDialog() {
        JTextField nameField = new JTextField(10);
        JTextField emailField = new JTextField(18);
        JPasswordField passwordField = new JPasswordField(10);

        
        JPanel panel = new JPanel(new GridLayout(0,2)); //행(row)를 0으로 표기시 -> 행의 갯수를 자동으로 생성하겠다는 의미.
        panel.add(new JLabel("이름 : "));
        panel.add(nameField);

        panel.add(new JLabel("이메일 : "));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 : "));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(this,  
            panel, 
             "회원가입", // 알림창의 제목 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE); 
            
            // 확인 알림창에서 수락 -> 데이터 파일을 저장하는시스템
            if (result == JOptionPane.OK_OPTION) {
                
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String regDate = DateUtil.getCurrentDateTime();
                
                    if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "검색결과가 없습니다. ");
                        return;
                    }
                    
                
                    Member_copy member = new Member_copy(name, password, email, regDate);
                
                    service.addMember_copy(member);
                
                    service.saveMember_copysToFile();
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
        
        Member_copy oldMember = service.getMember_copys().get(row);
        
    
        JTextField nameField = new JTextField(oldMember.getName(),10);
        JTextField emailField = new JTextField(oldMember.getEmail(),18);
        JPasswordField passwordField = new JPasswordField(oldMember.getPassword(),10);

        
        JPanel panel = new JPanel(new GridLayout(0,2)); //행(row)를 0으로 표기시 -> 행의 갯수를 자동으로 생성하겠다는 의미.
        panel.add(new JLabel("이름 : "));
        panel.add(nameField);

        panel.add(new JLabel("이메일 : "));
        panel.add(emailField);

        panel.add(new JLabel("패스워드 : "));
        panel.add(passwordField);

        
        int result = JOptionPane.showConfirmDialog(this,  // this ? 현재 윈도우 창
            panel, 
             "회원정보수정", 
            JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE); 

    
            if (result == JOptionPane.OK_OPTION) {
            
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String password = passwordField.getText().trim();
                String regDate = DateUtil.getCurrentDateTime();
    
                    if(name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "검색결과가 없습니다. ");
                        return;
                    }
                    
                    oldMember.setName(name);
                    oldMember.setEmail(email);
                    oldMember.setPassword(password);
                    oldMember.setRegDate(regDate);
                    service.saveMember_copysToFile();
                    service.refreshTable(); // 변경사항 새로고침 (다지우고 전체회원 다시채우기)
            }

    }


// 8) 회원삭제기능
    private void deleteSelectedMember_copyDialog() {
        // 테이블 상에서, 선택된 행의 번호를 가져와서, 수정 작업,
        int row = memberTable.getSelectedRow();
        // 유효성 체크.
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "삭제 할 회원을 선택하세요.");
            return;
        }

        int result = JOptionPane.showConfirmDialog(
                this, 
                "정말 삭제하시겠습니까?",
                "회원 삭제", 
                JOptionPane.YES_NO_OPTION 
        );

        if (result == JOptionPane.YES_OPTION) {

            service.getMember_copys().remove(row);
            service.saveMember_copysToFile();

            service.refreshTable();
        }
    }

}

