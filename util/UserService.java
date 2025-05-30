package util;

import java.util.Scanner;

public class UserService {

    public static void registerUser(Scanner scanner){
        
        System.out.println("홈페이지 회원가입 창 입니다.");
        
        // Scanner scanner = new Scanner(System.in);
        System.out.println("이름을 입력해 주세요 : " );
            String name = scanner.nextLine();
        System.out.println("이메일을 입력해 주세요 : " );
            String email = scanner.nextLine();
        
        String password;
        while (true) {
            System.out.println("패스워드를 입력해주세요.");
                password = scanner.nextLine(); 
            
            System.out.println("패스워드를 재 입력해주세요.");
                String password2 = scanner.nextLine(); 
            
            // 패스워드가 비어있지 않은지 확인
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
            } 
            else if (password.equals(password2)) { // 패스워드와 패스워드2가 일치하는지 확인
                System.out.println("패스워드가 일치합니다");
                break; // 패스워드가 일치하면 루프 종료
            } 
            else {
                System.out.println("패스워드가 일치하지 않습니다. 다시 입력해주세요.");
            }
            

        }


            System.out.println("출력 결과는 >");
                System.out.println("이름 : "+name);
                System.out.println("이메일 : "+email);
                System.out.println("패스워드 : "+password);
            String currentTime = DateUtil.getCurrentDateTime();
            
                    System.out.println(currentTime +" 시간부로 회원 가입이 완료되었습니다.");
        
        
        
    }

    // 유효성 체크를 , 로그인에도 적용해보기.
    // 로그인에서, 데이터 베이스가 없으니,
        // email: admin@naver.com, 패스워드: 1234로 가정하고,
    // 일치 하는 경우에만, "로그인 성공" 메시지 출력,
    // 일치하지 않는 경우, "로그인 실패" 메시지 출력.
    // 이메일 비워져 있으면, "이메일은 비워둘 수 없습니다." 메시지 출력,
    // 패스워드 비워져 있으면, "패스워드는 비워둘 수 없습니다." 메시지 출력.

    public static void loginUser(Scanner scanner){
        System.out.println("검증없이 단순 로그인 정보 출력");    
        // Scanner scanner1 = new Scanner(System.in);
    
        System.out.println("로그인| 이메일 입력해주세요 > ");
        // String login_email = scanner.nextLine();

        String email = ""; // 이메일 변수 초기화
        String password = ""; // 패스워드 변수 초기화
        while (true) {

            System.out.println("이메일 입력해주세요 > ");
            email = scanner.nextLine(); // 이메일 입력 받기

            if (email.isEmpty()) {
                System.out.println("이메일은 비워둘 수 없습니다. 다시 입력해주세요.");
                continue; // 다시 입력 받기 -> while 루프의 처음으로 돌아감 -> 계속 반복 진행한다.
            }
            // 순서2, 패스워드 입력 받기
            System.out.println("패스워드 입력해주세요 > ");
            password = scanner.nextLine(); // 패스워드 입력 받기

            // 패스워드가 비어있으면, 다시 입력 받기
            if (password.isEmpty()) {
                System.out.println("패스워드는 비워둘 수 없습니다. 다시 입력해주세요.");
                continue; // 다시 입력 받기
            }
            if (email.equals("admin@naver.com") && password.equals("1234")) {
                System.out.println("로그인 성공");
            } else {
                System.out.println("로그인 실패, 이메일 또는 패스워드를 확인해주세요.");
                continue; // 다시 입력 받기
            }
            break;

        }
        
        // System.out.println("로그인| 패스워드 입력해주세요 > ");
        //     String login_password = scanner.nextLine();



        System.out.println("출력 결과 >>>");

        System.out.println("로그인완료 | 당신의 이메일은 : "+email);
        System.out.println("로그인완료 | 당신의 패스워드는 : "+password);
    String currentTime = DateUtil.getCurrentDateTime();
            System.out.println("로그인한 시각 : "+currentTime);
            System.out.println("로그인이 되었습니다. 이것은 단순 출력용입니다." );
        
        // scanner.close();
    }

}
