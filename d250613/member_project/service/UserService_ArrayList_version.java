package d250613.member_project.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import d250612.member_project.util.DateUtil;
import d250612.member_project.model.*;

public class UserService_ArrayList_version {
//===============================================================
    // 추가사항3
    // 파일에 저장하는 메서드
    // 특정 파일 : 예) member.txt <- 구성은 1줄마다 멤버의 정보가 ,(콤마)를 기준으로 4개씩 구성된 형태.
    // 이상용, lsy@naver.com, 1234, 2025-06-12 00:00:00
    // 이상용2, lsy2@naver.com, 1234, 2025-06-12 00:00:00
    // 저장 기능 -> 추가, 수정, 삭제, 더미 데이터 추가시 , 기능의 맨 마지막에 이용할 예정.

    public static void saveToFile() {
        // 파일 입출력 할 때, 반드시 try ~ catch 또는 try ~ resource형식으로하기.
        
        // FileWriter fw = new FileWriter("member.txt") 작성시 자동으로 fw.close(); 반납함.

    //전
        //try(FileWriter fw = new FileWriter("member.txt")) {
    //후.. 변경, 한글 안깨지게, UTF-8 적용하기.
        try (OutputStreamWriter fw = new OutputStreamWriter(
                new FileOutputStream("member.txt"), "UTF-8")) {

            // ArrayList 메모리상에 있는 데이터를 실제 파일에 적는작업(반복문으로)
                for(Member member : members) { // 리스트에서 members요소를 member인스턴스에
                    // member에서 toCSV() 기능으로 한줄의 멤버정보를 출력하고,
                    // fw.write 실제 물리파일에 한줄씩 쓰기 작업
                    //===== 문제) 파일에 한글이 깨지는현상 찾기 ===============================
                    System.out.println("파일에 데이터 쓰기전에 내용 확인1");
                    System.out.println(member.toCsv()); // 확인) 쓰기전에 한글은 깨지지않았음.
                    //============================================================
                    fw.write(member.toCsv() + "\n");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 추가사항4
    // 파일 불러오기 메서드(시작시 이용)
    // member.txt 에서 한줄씩 불러와 그 정보 하나가 member 인스턴스에 하나씩 담으려함.
    // --> ArrayList<Member> members 라는 리스트에 담을예정.
    public static void loadFromFile() {
        // 우선 파일이 존재하는지 확인 (=유효성체크)
        // 파일관련 기능을 가지고 있는 클래스... File 클래스 이용하기
        File file = new File("member.txt");
        if(!file.exists()) { //파일이 존재 안하면 retrun (메서드를 탈출함)
            try {
                file.createNewFile(); // 물리적으로 파일 생성
                // 파일이 정상적으로 생성되었는지 확인할 수 있습니다.
                System.out.println("파일이 생성되었습니다: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                // 파일 생성 실패 시 예외 처리
            }
        } 
        // 파일안에 내용이 문자 기반이라서, 문자 기반으로 읽고 버퍼에 담아서 작업하기.
        // 파일 입출력시 try ~ catch 또는 try ~ resource 사용
        // 순서1) new FileReader(file) : 물리 파일의 내용을 문자기반으로 읽기
        // 순서2) BufferedReader bf = new BufferedReader(여기) : 버퍼로 읽기
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
           String line; // member.txt 파일에서 한줄씩 읽은 내용을 임시로 담을 문자열 변수
           // 1줄의 멤버정보 -> Member인스턴스로 생성 -> ArrayList에 담는과정.
           while ((line = br.readLine()) != null) { //파일의 내용이 null이 아닐때까지 (= 다 읽을때까지)
            Member member = Member.fromCSV(line);
            // 유효성 체크(Member 있는지 확인)
            if (member != null) {
                members.add(member);
                    userCount++;
            }
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//===============================================================
    static final int MAX_USERS = 100; // 유효성 체크용으로

    // Member 클래스를 담아 둘 배열 생성

// [변경1] 기존배열 -> 컬렉션으로 변경
    //전
    //static Member[] members = new Member[MAX_USERS]; // members 배열 넣을 변수설정
    //---------------------------------------------------------
    //후
    private static ArrayList<Member> members = new ArrayList<>();

    static int userCount = 0; // 현재 등록된 회원 수

    // 추가기능 반영
    // 회원 추가 메서드
    public static void addUser(Scanner scanner) {
        if (userCount < MAX_USERS) { // 기본 유효성 체크 최대 100명까지만 추가함.
            System.out.println("이름을 입력하세요: ");
            String name = scanner.nextLine();

            System.out.println("이메일을 입력하세요: ");
            String email = scanner.nextLine();

            System.out.println("패스워드를 입력하세요: ");
            String password = scanner.nextLine();

            String registrationDate = DateUtil.getCurrentDateTime();

            Member member = new Member(name, password, email, registrationDate);
// [변경2]   
            //전
            // members[userCount] = member;
            //--------------------------------------------------
            //후
            members.add(member);

            userCount++;
            System.out.println("회원이 추가되었습니다: " + name + ", " + email + ", " + registrationDate);
            // 반영하기.
            saveToFile();
        } else {
            System.out.println("회원 수가 최대치를 초과했습니다.");
        }
    } 

    
    // 회원 조회 메서드
    public static void viewUsers() {
        if (userCount == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return; // 등록된 회원이 없을 때, 조회 기능 종료, 메서드(함수)를 나가기
        }
        System.out.println("<<<<등록된 회원 목록>>>>");
// [변경3] 기존 배열에서 -> 컬렉션으로 수정.
        //전
        // for (int i = 0; i < userCount; i++) {
        //    members[i].showInfo();
        // }
        //--------------------------------------------------
        //후
        for(int i = 0; i<members.size(); i++) {
            System.out.println("인덱스 번호 : " + i);
            System.out.println("<<<<회원 정보>>>>");
                members.get(i).showInfo();
        }
    } 
    // 추가기능 반영
    // 회원 수정 메서드
    public static void updateUser(Scanner scanner) {
        System.out.println("수정할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 수정할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거
        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        System.out.println("수정할 회원의 이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.println("수정할 회원의 이메일을 입력하세요: ");
        String email = scanner.nextLine();

        System.out.println("수정할 회원의 패스워드를 입력하세요: ");
        String password = scanner.nextLine();

        String registrationDate = DateUtil.getCurrentDateTime();
// [변경3-2] new Member(); /메모.. new Member(); 이런 형식이 새로운 인스턴스를 생성하는 부분이라서,
        Member member = new Member(name, password, email, registrationDate);
        // 해당 인덱스에 수정된 회원 정보 저장

// [변경4] 기존 member(0x100)에서, 변경할 내용으로 수정이 된 새로운 member(0x200) 로 교체 작업
        // 전
        // members[index] = member;
        //-------------------------------
        // 후
        members.set(index, member);
        
        System.out.println("회원 정보가 수정되었습니다: " + name + ", " + email + ", "
                + registrationDate);
        // 반영하기.
        saveToFile();
    }

    // 추가기능 반영
    // 회원 삭제 메서드
    public static void deleteUser(Scanner scanner) {
        System.out.println("삭제할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }

// [변경5]
        // 전
        // Member member = members[index];
        // System.out.println("삭제할 회원 정보: ");
        // member.showInfo(); // 회원 정보 출력

        
        // members[index] = null; // 해당 인덱스의 회원 정보 삭제
        
        // for (int i = index; i < userCount - 1; i++) {
        //     // 예시, 인덱스 1번 삭제, userCount = 5, 범위 1 이상 4 미만
            
        //     members[i] = members[i + 1]; // 다음 인덱스의 회원 정보를 현재 인덱스로 이동
        // }
        
        // members[userCount - 1] = null; // 마지막 인덱스의 회원 정보 삭제
        //--------------------------------------------------
        // 후
        // 삭제 할 회원정보를 받아오는기능
        Member member = members.get(index); 
            System.out.println("삭제할 회원 정보 : " );
                member.showInfo();
        // 삭제
        members.remove(index);

        userCount--; // 회원 수 감소
        System.out.println("회원이 삭제되었습니다.");
        // 반영하기.
        saveToFile();
    }
    
    // 추가기능 반영
    // 회원 더미 데이터 5개 추가하는 메서드
    public static void addDummyUsers() {
        for (int i = 0; i < 5; i++) {
            if (userCount < MAX_USERS) {
                
                Member dummyMember = new Member(
                        " 더미회원 " + (i + 1),
                        " password " + (i + 1),
                        " dummy " + (i + 1) + "@example.com",
                        DateUtil.getCurrentDateTime());
// [변경6]
                // 전
                // members 배열에 더미 회원 정보 추가
                // members[userCount] = dummyMember;
                //-------------------------------------
                // 후
                members.add(dummyMember);

                userCount++;
                // 반영하기.
                saveToFile();
            } else {
                System.out.println("더미 회원 추가 실패: 최대 회원 수 초과");
                break;
            }
        }
        System.out.println("더미 회원 5명이 추가되었습니다.");
        
    }
    

    // 검색 기능
    public static void searchUser(Scanner scanner) {
        System.out.println("검색할 회원의 이름 또는 이메일을 입력하세요: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < userCount; i++) {
            
// [변경7]
            // 전
            // if (members[i].getName().contains(searchQuery) || members[i].getEmail().contains(searchQuery)) {
            //     members[i].showInfo(); // 회원 정보 출력
            //     found = true;
            // }
            //-----------------------------------------------------
            // 후
            if(members.get(i).getName().contains(searchQuery) ||
                members.get(i).getEmail().contains(searchQuery) ) {
                System.out.println("검색 결과 : ");
                    members.get(i).showInfo();
                found = true;
            }

        }

        if (!found) { // 검색 결과가 있을 경우, 실행이 안됨, found = true; -> false;
            System.out.println("검색 결과가 없습니다.");
        }
    }
    
}
