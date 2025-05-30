package ch2;

import java.util.Scanner;

public class Scanner_Test {
    public static void main(String[] args) {
        System.out.println("Scanner Test 시작");

    //[클래스명] [변수명] = new [클래스명]();
        Scanner scanner = new Scanner(System.in);
            // System.in : 표준 입력 스트림, 키보드 입력을 받기 위해 사용
        
                System.out.println("이름을 입력하세요.");
        String name = scanner.nextLine();
            // nextLine() 메서드를 사용하여 한 줄 전체를 입력받음
        System.out.println("입력한 이름 : "+ name);
        // 입력받은 이름을 출력
        // scanner.close();
            // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함.

        // Scanner : 자바에서 사용자의 입력을 받는 방법.
        // 자주 사용하는 메서드 : next(), nextLine(), nextInt(), nextDouble() 등
        // next() : 공백 전까지 문자열 입력.
            // 예시: "홍   길   동" -> next()로 가져온 문자열은 "홍"
        // nextLine() : 한 줄 전체를 문자열로 입력
            // 예시: "홍   길   동" -> 가져온 문자열은 "홍   길   동"
        // nextInt() : 정수입력
            // 예시 : "123" -> 가져온 값은 123
        // nextBoolean() : boolean 입력.
            // 예시 : "true" -> 가져온 값은 true
        // hasNext() : 다음에 입력할 값 이 있는지 확인하는 메서드
            // 예시 : 입력이 있다면 true, 없다면 false 반환

        // 기본 문법 형식
        // import : 다른 클래스를 가져오는 명령어
        // java.util.Scanner : java 폴더 -> util 폴더 -> Scanner 클래스

        // 순서1
        // import java.util.Scanner; // Scanner 클래스를 사용하기 위해 import 해야함.
        
        // 순서2, 클래스의 기본 사용방법(객체 생성= 인스턴스를 생성)
        // 기본 모양, [클래스명] [변수명] = new [클래스명]();
        // Scanner scanner = new Scanner(System.in); 
            // System.in : 표준 입력 스트림, 키보드 입력을 받기 위해 사용
        
        // 순서3, 입력받기
        // System.out.println("이름을 입력하세요: ");
        // String name = scanner.nextLine(); 
            // nextLine() 메서드를 사용하여 한 줄 전체를 입력받음

        // 순서4,. 출력해보기.
        // System.out.println("입력한 이름: " + name); // 입력받은 이름을 출력

        // 순서5, scanner 닫기
        // scanner.close(); // Scanner 객체를 사용한 후에는 반드시 닫아줘야 함. 리소스 누수 방지



        //퀴즈1) 좋아하는 숫자를 입력하기 (scanner 사용.)

        System.out.println("좋아하는 숫자를 입력하세요 : ");
        
        int number = scanner.nextInt();

        System.out.println("입력한 숫자 : " +number);
            // scanner.close();

        // 퀴즈2) 새로운 ScannerTest2라는 클래스 만들고,
        //         간단한 회원가입 만들기
        //         홈페이지 회원가입
        //         이름을 입력해주세요 >
        //         이메일을 입력해주세요 >
        //         패스워드를 입력해주세요 >
        //         출력 결과는 
        //         이름 :
        //         이메일 : 
        //         패스워드 :
        //         회원가입 완료되었습니다.
    }
}
