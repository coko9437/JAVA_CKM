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
import d250613.web_structure.ui._4copy;

public class _5copy {
    
    private static final String FILE_NAME = "member.txt";
    
    private ArrayList<Member> members = new ArrayList<>();

    
    private DefaultTableModel tableModel;

    private JTextField searchField;

    public void setSignupFrame(_4copy signupFrame) {
        this.signupFrame = signupFrame;
    }

    private _4copy signupFrame;

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
        saveMembersToFile();
    }

    public void loadMembersFromFile() {

        members.clear();// 모두 비우기.

        File file = new File(FILE_NAME);
        // 파일 존재 안하면, 생성.
        if (!file.exists()) {
            // 새로운 파일 생성.
            try {
                file.createNewFile(); //
                System.out.println("새로운 파일 생성 : " + FILE_NAME);
            } catch (Exception e) {
        
                System.out.println(e.getMessage());
                return; // 현재 메서드 나가기
                
            }
        }
        // 파일이 있는 경우.
        // 파일에서 한줄 씩 읽어서 -> members 리스트에 저장.
        // member.txt , 이상용,lsy@naver.com,1234,2025-06-13 12시 8분, 한줄 씩 가지고 와서,
        
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
            
            System.out.println(e.getMessage());
        }
    }

    
    public void saveMembersToFile() {
        
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME), "UTF-8"))) {
            for (Member member : members) {
                bw.write(member.toCsv());
                bw.newLine();
            }
        } catch (

        Exception e) {
            
            System.out.println(e.getMessage());
        }
    }

    
    public void dummyMake() {

        
        for (int i = 0; i < 10; i++) {
            Member dummyMember = new Member(
                    "더미회원" + (i + 1),
                    "password" + (i + 1),
                    "dummy" + (i + 1) + "@example.com",
                    DateUtil.getCurrentDateTime());
            members.add(dummyMember);
        }

        saveMembersToFile();
        refreshTable();
        
        signupFrame.showDialog("10명의 더미 회원 추가!!");

    }

    
  
    public void refreshTable() {
        tableModel.setRowCount(0); 
        for (Member member : members) {
            
            tableModel.addRow(new Object[] {
                    member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }
    }

    
    public void showSearchResults(ArrayList<Member> results) {
        tableModel.setRowCount(0);
        for (Member member : results) {
            
            tableModel.addRow(new Object[] {
                    member.getName(), member.getEmail(), member.getPassword(), member.getRegDate()
            });
        }
    }

    
    public void searchMembers() {
        
        String query = searchField.getText().trim().toLowerCase();
        
        if (query.isEmpty()) {
            refreshTable();
            return;
        }
        
        ArrayList<Member> resultList = new ArrayList<>();
        
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(query) ||
                    member.getEmail().toLowerCase().contains(query)) {
                resultList.add(member);
            }
        }
        
        showSearchResults(resultList);

        
        if (resultList.isEmpty()) {
            
            signupFrame.showDialog("검색 결과가 없습니다.");
            
        }

    }

}
