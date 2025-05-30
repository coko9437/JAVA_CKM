package ch2;

import java.util.Scanner;

// import java.util.Scanner;

import util.UserService;

public class ScannerTest2 {
    public static void main(String[] args) {
        // 여기에 있던 회원가입 내용을 다른 클래스로 이동 후(UserService),
            // 단순 클래스의 메소드만 호출하는 형태로 변경함.
            // 클래스명.메소드(); 형태로 호출.
        
        // 공용으로 사용을 할 스캐너를 정의.
        Scanner scanner = new Scanner(System.in);


        UserService.registerUser(scanner);
        
        UserService.loginUser(scanner);

        scanner.close();

        // System.out.println("홈페이지 회원가입 창 입니다.");
        
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("이름을 입력해 주세요 : " );
        //     String name = scanner.nextLine();
        // System.out.println("이메일을 입력해 주세요 : " );
        //     String email = scanner.nextLine();
        // System.out.println("패스c워드를 입력해 주세요 : " );
        //     String password = scanner.nextLine();
        
        //     System.out.println("출력 결과는 >");
        //         System.out.println("이름 : "+name);
        //         System.out.println("이메일 : "+email);
        //         System.out.println("패스워드 : "+password);
        //             System.out.println("회원 가입이 완료되었습니다.");
        // scanner.close();  
        
        //퀴즈) 회원가입 기능 만들었고, 로그인 기능을 만들기
        // 현재 DB가 없어서 로그인 기능은 콘솔로..
            // 콘솔로 이메일 입력받고, 패스워드 입력 받기
            // 검증 없이 단순 로그인 정보만 출력하기
            
        // 로그인| 이메일 입력해주세요 >
        // 로그인| 패스워드 입력해주세요 >
        
        // 출력 결과는
        // 로그인 이메일 정보 : {이메일}
        // 로그인 패스워드 정보 : {패스워드}
        // 로그인 완료되었습니다. 현재 임시로 단순 출력용입니다. 조금 있다. 검증도 추가 해보기.
        // 메서드를, UserService 클래스에 , 정적 메소드로 추가해보기.

        // System.out.println("검증없이 단순 로그인 정보 출력");    
                 // Scanner scanner1 = new Scanner(System.in);
    
        // System.out.println("로그인| 이메일 입력해주세요 > ");
        //     String login_email = scanner1.nextLine();
        // System.out.println("로그인| 패스워드 입력해주세요 > ");
        //     String login_password = scanner1.nextLine();
        // System.out.println("출력 결과는?");

        // System.out.println("당신의 이메일 : "+login_email);
        // System.out.println("당신의 패스워드 : "+login_password);
        //     System.out.println("로그인이 되었습니다. 이것은 단순 출력용입니다." );

                    //scanner1.close();
    }
}
