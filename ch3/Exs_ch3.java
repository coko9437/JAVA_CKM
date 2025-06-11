package ch3;

import java.util.Scanner;

public class Exs_ch3 {
    
    // 기본 예외 처리 방법,
    // 왜? 예외 처리를 해야하나요? 비정상적인 종료를 막기 위해서, UX 향상,
    // 예시) 회원 가입 하는 경우, 제가 잘못해서 입력을 특수 문자등을 입력한 경우,
    // 물론, 기본적으로 특수 문자 유효성 체크가 당연히 들어가거나, 다른 조취가 있지만, 일단 없다는 가정
    // 회원 가입 처리 하는 중간에, 비정상적인 실행이 되면, 전체 웹, 또는 프로그램이 종료가 되버림.
    // 만약, 예외 처리를 해두면, 안전하게, 간단히 경고창으로, 입력에 특수 문자가 있으니 확인 후,
    // 다시 입력해 주세요. 안전하게 사용자에게 안내 해줌.

    // try {
    // 1) 예외가 발생할수 있는 코드 블록 : 실험장 -> catch 구문으로 예외를 던진다고 표현함.
    // } catch (예외타입 e) {
    // 2) 예외가 발생했을 때 처리하는 코드 블록 : 예외 처리
    // }
    // finally {
    // 3) 예외 발생 여부와 상관없이 항상 실행되는 코드 블록 : 자원 반납, 파일 닫기 등
    // }

    // 0으로 나누는 예외 처리 예시
    public static void ex3_9_exception() {
        int a = 10;
        int b = 0; // 0으로 나누는 예외 발생 가능성 있음.
        try {
            // 언제 ? try 블록안에서 작업을 하나요?
            // 네트워크 전송, 파일 입출력, 데이터베이스 연결 등, 이러한 작업을 더 많이함.
            // 실행순서
            // 정상인 경우 : 순서 1 -> 순서 2 -> 순서 4
            // 예외 발생시 : 순서 1 -> 순서 3 -> 순서 4
            int result = a / b; // 예외 발생 가능 코드, 순서1
            System.out.println("결과: " + result);// 순서2,
        } catch (ArithmeticException e) { // ArithmeticException 예외 처리
            // 순서3
            System.out.println("0으로 나눌 수 없습니다. 예외 메시지: " + e.getMessage());
        } finally {
            // 순서4
            System.out.println("예외 처리 블록이 끝났습니다.");
        }
    }


    // -- 퀴즈1,
    // -- 사용자로부터 정수 5개를 입력받아 배열에 저장하고 역순 출력
    public static void ex3_8_quiz1(Scanner scanner) {
        System.out.println("사용자로부터 정수 5개를 입력받아 배열에 저장하고 역순 출력");
        int[] numbers = new int[5];
    
        // for (int i = 0; i < numbers.length; i++)
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt(); // 예시) 1 2 3 4 5 , 공백을 기준으로 입력.
        }

        System.out.println("역순으로 출력: ");
        // numbers.length : 배열의 길이 (여기선 전체 크기 5)
        // for(int i = numbers.length - 1; i >= 0; i--)
        for (int i = 4; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
    }

    // -- 퀴즈2,
    // -- 3x3 배열을 만들어 모든 요소에 1~9 채우고 출력
    public static void ex3_8_quiz2() {
        // int numbers[][] = new int[3][3];
        int[][] numbers = new int[3][3];
        // 빈 배열의 모양 [i][j] ==> [0][2] => 0행 2열
        //    0열 1열 2열
        // 0행 0  0  0
        // 1행 0  0  0
        // 2행 0  0  0

        int num = 1; // 1부터 시작
        for (int i = 0; i< numbers.length; i++) { // 행 반복
            for(int j = 0; j < numbers.length; j++) { // 열 반복
                numbers[i][j] = num++;
            }   
        }
        // 출력
        for (int i = 0; i< numbers.length; i++) {
            for(int j = 0; j < numbers.length; j++) {
                System.out.print(numbers[i][j]+"  ");
            }
            System.out.println(); // 행 끝나면 줄바꿈
        }
    }
    

    // -- 퀴즈3,
    // -- 문자열 배열을 메서드로 받아 가장 긴 문자열을 반환
    public static String ex3_8_quiz3(String[] strings) {
        // 기본 유효성 체크
        if (strings == null || strings.length == 0) {
            return null; // 빈 배열 처리
        }
        // 상태 변수, 가장 긴 문자열을 임시로 저장.
        // 초기값이 예시 : "apple"
        String longest = strings[0]; // 첫 번째 문자열로 초기화

        // strings 문자열을 요소로 가지는 배열을 반복하면서, 하나씩 꺼내서 비교
        for (String str : strings) {
            // longest : 예시 , "apple", length() : 5
            // str : 예시 , "banana" , length() : 6
            if (str.length() > longest.length()) {
                longest = str; // 더 긴 문자열 발견 시 업데이트
            }
        }

        return longest; // 가장 긴 문자열 반환

    }

    // 퀴즈3-1) 
    public static String[] generateRandomStrings(int size) {
        // size : 생성할 문자열의 개수
        String[] randomStrings = new String[size];
        String characters = "abcdefghijklmnopqrstuvwxyz"; // 소문자 알파벳,26

        for (int i = 0; i < size; i++) {
            int length = (int) (Math.random() * 10) + 1; // 1~10 사이의 길이
            // StringBuilder: 문자열인데, 메모리 절약하는 문자열이다.
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < length; j++) {
                int index = (int) (Math.random() * characters.length()); // 0 ~ 25 사이의 랜덤 인덱스
                // sb : 문자열 배열,
                // charAt(0), 문자열의 인덱스에 해당하는 문자 가져오기
                // characters.charAt(index) : 문자열 중에서, 길이가 26, 인덱스 치면, 0~25
                // characters.charAt(0) -> 'a',
                // characters.charAt(1) -> 'b',
                // ..., characters.charAt(25) -> 'z'
                // sb.append('a'); // 랜덤 문자 추가
                sb.append(characters.charAt(index)); // 랜덤 문자 추가
            }

            randomStrings[i] = sb.toString(); // 문자열로 변환하여 배열에 저장
        }

        return randomStrings; // 생성된 문자열 배열 반환
    }


    // int[] : 리턴 타입 정수를 요소로가지는 배열타입.
    public static int[] ex3_8_return() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        return numbers; // 배열 리턴
    }

    // 기본 배열생성, 조회, 반복문 출력, 배열타입 으로 리턴
    public static void ex3_8() {
        int[] numbers2 = { 1, 2, 3, 4, 5 }; // 배열 선언과 동시에 값 할당

        // numbers2의 인덱스 3을 조회하고싶다면?
        int value = numbers2[3]; // 인덱스 3의 값은 4 출력됨.
        System.out.println("number2 의 [3] 의 값은 : " + value);

        for (int number : numbers2) {
            System.out.println(number + " for문 이용한 값.");
        }

    }

    public static void ex3_7(Scanner scanner) {
        // 양수 5개를 입력 받아 배열에 저장하고, 제일 큰 수를 출력하는 프로그램 메소드
        int intArray[]; // 정수형 배열 선언함.
        intArray = new int[5]; // 크기가 5인 정수형 배열 생성
        int max = 0; // 현재 가장 큰 수 ()
        System.out.println("양수 5개를 입력하세요.");
        for (int i = 0; i < 5; i++) {
            intArray[i] = scanner.nextInt();
            // 입력 받은 정수를 배열에 저장
            if (intArray[i] > max)
                max = intArray[i]; // max 변경
        }
        System.out.print("가장 큰 수는 " + max + "입니다.");
        scanner.close();

    }

    // 회원 추가 프로그램 UI 그리는 메소드
    public static void ex_user_ui(Scanner scanner) {
        int menu;
        do {
            System.out.println("회원 관리 프로그램 예시");
            System.out.println("=================================================================");
            System.out.println("1. 회원 추가 , 2. 회원 조회, 3. 회원 수정, 4. 회원 삭제, 5.더미 데이터 추가 5개, 6. 검색기능,  0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0 ~ 6): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    Exs_ch3_2_user_array_doc.addUser(scanner); // 회원 추가
                    break;
                case 2:
                    Exs_ch3_2_user_array_doc.viewUsers(); // 회원 조회
                    break;
                case 3:
                    Exs_ch3_2_user_array_doc.updateUser(scanner); // 회원 수정
                    break;
                case 4:
                    Exs_ch3_2_user_array_doc.deleteUser(scanner); // 회원 삭제
                    break;
                case 5:
                    Exs_ch3_2_user_array_doc.addDummyUsers(); // 더미 데이터 추가
                    System.out.println("더미 데이터 5개가 추가되었습니다.");
                    break;
                case 6:
                    Exs_ch3_2_user_array_doc.searchUser(scanner); // 회원 검색
                    System.out.println("회원 검색 기능이 실행되었습니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
            }

        } while (menu != 0); // 메뉴가 0이 아닐 때까지 반복
        System.out.println("============================");

    }

    public static void ex3_6_3() {
        // 기본문법
        // 자료형 [] [] 배열이름 = new 자료형 [행의 수] [열의 수];

        // 이중배열 선언 및 초기화
        int[][] matrix = {
                // 0열 1열 2열
                { 1, 2, 3 }, // 0행
                { 4, 5, 6 }, // 1행
                { 7, 8, 9 } // 2행
        };

        // 이중 배열 값 출력.
        for (int i = 0; i < matrix.length; i++) { // 행 반복
            for (int j = 0; j < matrix[i].length; j++) { // 열 반복
                System.out.print("matrix[" + i + "] [" + j + "] :" + matrix[i][j] + "  "); // 각 요소 출력
            }
            System.out.println(); // 행이 끝나면 줄바꿈
        }
    }

    public static void ex3_6_2() {
        int[] numbers = { 1, 2, 3, 4, 5 }; // 배열선언과 동시에 값 할당
        // for (자료형타입 변수 : 배열이름) { // 배열에서 각 요소를 하나씩 꺼내서 변수에 할당}
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(); // 줄바꿈
    }

    public static void ex3_6() {
        // 선언하는 방법 크게 2가지
        // 자료형타입 [] 배열이름 = new 자료형타입[크기]; <--기본방식
        // 자료형 배열이름[] = new 자료형[크기]; <--오래된 방식
        int[] numbers = new int[5];
        // 배열에 값 할당
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        // 배열 값 출력
        for (int number : numbers) {
            System.out.print(number + " "); // 1 2 3 4 5 출력
        }
        System.out.println(); // 줄바꿈
    }

    public static void ex3_5(Scanner scanner) {
        // continue
        System.out.println("정수를 5개 입력하세요.");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            System.out.println("입력한 숫자 : " + n + "  i 값(인덱스) 확인 : " + i);
            if (n <= 0)
                continue; // 0이나 음수인 경우 더하지 않고 다음 반복으로 진행
            else
                sum += n; // 양수인 경우 덧셈
        }
        System.out.println("양수의 합은 " + sum);
        scanner.close();
    }

    public static void ex3_4() {
        for (int i = 1; i < 10; i++) { // 단에 대한 반복. 1단에서 9단
            for (int j = 1; j < 10; j++) { // 각 단의 곱셈
                System.out.print(i + "*" + j + "=" + i * j); // 구구셈 출력
                System.out.print('\t'); // 하나씩 탭으로 띄기
            }
            System.out.println(); // 한 단이 끝나면 다음 줄로 커서 이동
        }
    }

    public static void ex3_3() {
        char a = 'a';
        do {
            System.out.print(a);
            // char 타입의 a -> int 변환시 , 값: 97, 유니코드 값 : 97
            a = (char) (a + 1); // a+1 는 int 타입으로 계산되므로, char로 변환
        } while (a <= 'z');
    }

    // 퀴즈) 사용자로부터 문자를 입력받아 q가 나올때 까지 문자의개수를 세는 프로그램
    public static int ex3_2_quiz(Scanner scanner) {
        // String m;
        // int count = 0;
        // System.out.println("한문자만 입력하세요. 'q'를 입력하면 종료됩니다.");

        // while(true){
        // System.out.println("입력하세요>");
        // m = scanner.nextLine();

        // if (m.equals("q")) {
        // break;
        // }
        // if (!m.isEmpty()) {
        // count++;
        // }
        // }
        // System.out.println("입력한 문자의 총 개수는 "+count+"개 입니다.");

        String total = ""; // 입력된 총 문자열 수

        while (true) {
            System.out.println("문자를 입력하세요 (다음 문장에 q를 입력하면 종료): ");
            String input = scanner.nextLine(); // 한 줄 입력 받기
            total += input; // 입력된 문자열을 누적
            System.out.println("계속 입력하려면 아무키나 입력하고, 종료시에 q를 입력하세요.");
            String command = scanner.nextLine(); // 다음 명령어 입력 받기
            if (command.equals("q")) { // 대소문자 구분 없이 q 입력시 종료
                break; // while 문 종료
            }
        }
        int count = total.length(); // 입력된 문자열의 길이(문자 개수)
        return count;
    }

    // ex3-2) while 문 이용해서 예시
    // 0이 입력되면 while문 종료, 입력한 숫자들의 합을 구하기
    // 숫자는 콘솔에 입력함.
    public static void ex3_2(Scanner scanner) {
        // java.util.Scanner scanner = new java.util.Scanner(system.in);
        int sum = 0;
        int input;

        System.out.println("숫자를 입력하세요 (0입력시 종료)>>>");

        while (true) {
            input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            sum += input;
        }
        System.out.println("입력한 숫자의 합은 : " + sum);
    }

    // ex3-1)
    // 기본 for 이용해서 1~10까지의 합
    // 입력값에 원하는 숫자를 입력시, 1~n 까지의 합을 구하는 메소드로 변경
    public static int getSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i);

            sum += i;

            System.out.println("sum = " + sum);
        }

        return sum;

    }
}
