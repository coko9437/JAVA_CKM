package ch3;

import java.util.Scanner;

import util.date.DateUtil;

public class Exs_ch3_2_user_array_doc {
    
    // 퀴즈,
    // 아래 코드를 이용해서,
    // 도서 관리 프로그램을 만들기,
    // + @ : 검색 기능 넣기
    // 도서 정보 1) 도서명, 2) 저자, 3) 출판사, 4) 등록일로 구성,
    // 도서 정보 CRUD , 추가, 조회, 수정, 삭제 기능, 검색까지 구현.
    // 검사 확인시, 기능 구현 다 보여주고, 각 메서드 기능에 대해서 질문 할 예정.

    //회원관리 프로그램 버전2, 저장소 : 임시메모리(배열)
    //배열 --> 주의사항 : 1) 고정길이, 2) 크기 변경불가, 3) 같은 타입 사용.
    //조건 : 회원수 100명 이하 / 회원정보는 이름, 이메일, 패스워드, 등록일 로 구성.
    // 회원정보 CRUD (추가, 조회, 수정. 삭제)구현.
    

    // 이름, 이메일, 패스워드, 등록일을 저장할 배열 선언
    // 예시) 1명이 회원 가입 하게 되면, 이상용, lsy@naver.com , 1234, 2025-06-04
    // 배열은 순서, 인덱스 표현하고, 0부터 시작함.
    // names 배열 : ["이상용"] -> names[0] = "이상용"
    // emails 배열 : ["lsy@naver.com"] -> emails[0] = "lsy@naver.com"
    // passwords 배열 : ["1234"] -> passwords[0] = "1234"
    // registrationDates 배열 : ["2025-06-04 12:00:00"] -> registrationDates[0] =
    // "2025-06-04 12:00:00"

    // 예시2) 1명 회원 더 추가시, 홍길동 , hong@naver.com, 1234, 2025-06-04
    // names 배열 : ["이상용", "홍길동"] -> names[1] = "홍길동"
    // emails 배열 : ["lsy@naver.com", "hong@naver.com"] -> emails[1] =
    // "hong@naver.com"
    // passwords 배열 : ["1234", "1234"] -> passwords[1] = "1234"
    // registrationDates 배열 : ["2025-06-04 12:00:00", "2025-06-04 12:00:00"] ->
    // registrationDates[1] = "2025-06-04 12:00:00"

    // 예시3) 1명 회원 더 추가시, 김철수 , kim1111@naver.com , 1234, 2025-06-04
    // names 배열 : ["이상용", "홍길동", "김철수"] -> names[2] = "김철수"
    // emails 배열 : ["lsy@naver.com", "hong@naver.com", "kim1111@naver.com"] ->
    // emails[2] = "kim1111@naver.com"
    // passwords 배열 : ["1234", "1234", "1234"] -> passwords[2] = "1234"
    // registrationDates 배열 : ["2025-06-04 12:00:00", "2025-06-04 12:00:00",
    // "2025-06-04 12:00:00"] -> registrationDates[2] = "2025-06-04 12:00:00"

    // 결론, 배열은 임시 메모리 저장소이고, 각 배열의 모양
    // names[0] = "이상용", names[1] = "홍길동", names[2] = "김철수" 처럼,
    // emails[0] = "", emails[1] = "", emails[2] = "" 처럼,
    // passwords[0] = "", passwords[1] = "", passwords[2] = "" 처럼,
    // registrationDates[0] = "", registrationDates[1] = "", registrationDates[2] =
    // "" 처럼,
    // MAX_USERS = 100 이므로, 인덱스 : 0 ~ 99 까지 사용 가능.

    static final int MAX_USERS = 100; //최대 회원수

    static String[] names = new String[MAX_USERS];
    static String[] emails = new String[MAX_USERS];
    static String[] passwords = new String[MAX_USERS];
    static String[] registrationDates = new String[MAX_USERS];

    // 상태 변수,
    static int userCount = 0; //현재 등록된 회원 수

    // 회원 추가 메소드

    public static void addUser(Scanner scanner) {
        if (userCount < MAX_USERS) {
            System.out.print("이름을 입력하세요 >> ");
            String name = scanner.nextLine();
            names[userCount] = name; //이름 저장

            System.out.print("이메일을 입력하세요 >>  ");
            String email = scanner.nextLine();
            emails[userCount] = email; // 이메일 저장

            System.out.print("패스워드를 입력하세요 >>  ");
            String password = scanner.nextLine();
            passwords[userCount] = password; // 패스워드 저장

            System.out.print("등록날짜 : ");
            String registrationDate = util.date.DateUtil.getCurrentDateTime();
            registrationDates[userCount] = registrationDate; // 등록일 저장

            //회원수 증가
            userCount++;
            System.out.println("회원으로 등록되었습니다. 이름은 " +name+ ", 이메일주소 : " +emails+ ", 패스워드는" +passwords+ ", 회원등록한 시간 : " +registrationDates);
            } else {
            System.out.println("회원 수가 최대치를 초과했습니다.");
             }

        }
        // 회원조회 메소드
        public static void viewUsers() {
        if (userCount == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        System.out.println("등록된 회원 목록:");
        for (int i = 0; i < userCount; i++) {
            System.out.println("인덱스 번호 : (" + i + ") | " + names[i] + ", " + emails[i] + ", " + registrationDates[i]);
        }
    } 
    // 회원 수정 메서드
    // 회원 전체 목록에서, 해당 회원의 인덱스를 번호를 이용해서, 회원 정보를 수정해보기.
    public static void updateUser(Scanner scanner) {
        System.out.println("수정할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 수정할 회원의 인덱스 입력 / 개행문자(Enter) 남아있음. 
        scanner.nextLine(); // 개행 문자 제거 (이후에 문자열을 입력받을 때 문제가 없도록)
        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        System.out.println("수정할 회원의 이름을 입력하세요: ");
        String name = scanner.nextLine();
        names[index] = name; // 이름 수정

        System.out.println("수정할 회원의 이메일을 입력하세요: ");
        String email = scanner.nextLine();
        emails[index] = email; // 이메일 수정

        System.out.println("수정할 회원의 패스워드를 입력하세요: ");
        String password = scanner.nextLine();
        passwords[index] = password; // 패스워드 수정

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();
        registrationDates[index] = registrationDate; // 등록일 수정

        System.out.println("회원 정보가 수정되었습니다: " + names[index] + ", " + emails[index]);
    }

    //회원 삭제 메소드
    // 수정 처럼, 회원의 인덱스 번호를 입력시, 삭제하는 로직.
    public static void deleteUser(Scanner scanner) {
        System.out.println("삭제할 회원의 인덱스를 입력하세요 (0 ~ " + (userCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= userCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }
        // 삭제할 회원 정보 출력
        System.out.println("삭제할 회원 정보: " + names[index] + ", " + emails[index] + ", " + registrationDates[index]);

        // 해당 인덱스의 회원 정보를 삭제하고, 뒤에 있는 회원 정보를 앞으로 이동
        for (int i = index; i < userCount - 1; i++) {
            names[i] = names[i + 1];
            emails[i] = emails[i + 1];
            passwords[i] = passwords[i + 1];
            registrationDates[i] = registrationDates[i + 1];
        }
        // 마지막 회원 정보는 null로 설정
        names[userCount - 1] = null;
        emails[userCount - 1] = null;
        passwords[userCount - 1] = null;
        registrationDates[userCount - 1] = null;

        // 회원 수 감소
        userCount--;
        System.out.println("회원이 삭제되었습니다.");
    }

    // 회원 더미데이터 5개 추가하드 메서드
    public static void addDummyUsers(){
        for (int i = 0; i < 5; i++) {
            if (userCount < MAX_USERS) {
                names[userCount] = "더미회원" + (i + 1);
                emails[userCount] = "dummy" + (i + 1) + "@example.com";
                passwords[userCount] = "password" + (i + 1);
                registrationDates[userCount] = DateUtil.getCurrentDateTime();
                userCount++;
            } else {
                System.out.println("더미 회원 추가 실패: 최대 회원 수 초과");
                break;
            }
        }
        System.out.println("더미 회원 5명이 추가되었습니다.");
    }
    
    // 검색 기능
    // 회원 목록에서 이름 또는 이메일로 검색하는 기능을 추가할 수 있습니다.
    public static void searchUser(Scanner scanner) {
        System.out.println("검색할 회원의 이름 또는 이메일을 입력하세요: ");
        String searchQuery = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < userCount; i++) {
            if (names[i].contains(searchQuery) || emails[i].contains(searchQuery)) {
                System.out.println("검색 결과: " + (i + 1) + ". " + names[i] + ", " + emails[i] + ", "
                        + registrationDates[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }
    // 검색 기능

}
