package user_mini_project;

import java.util.Scanner;

import ch2.OperConditionTest;
import ch3.Exs_ch3;
import util.random.RandomUtil;
import util.user.UserService;

public class MainClass_if_case {
    
    public static void main(String[] args) {
        //공용으로 사용할 스캐너 생성
        Scanner scanner = new Scanner(System.in);

        // 무한 루프이고, 메인 메뉴를 출력하는 부분
        // 반복문 안에서, 리턴등으로 나오지 않는 이상, 계속 출력이 됨.

        while (true) {
            System.out.println("======================================================");
        System.out.println("회원관리 시스템에 오신것을 환영합니다.");
        System.out.println("0. 종료  1.회원가입  2.로그인   3.산술연산자  4.복합 산술연산자");
        System.out.println("5. 로또 번호 생성기(배열없는버전)");
            System.out.println("======================================================");
        System.out.println("메뉴 번호를 선택해주세요. (0번 ~~ 5번)");
        // 사용자가 입력한 번호를 문자열 형태로 받기
        String choice = scanner.nextLine();

       // 첫번째, if 형태의 조건문
            // 문자열을 비교 할 때는 , 문자열에 탑재된 기능 중에서, equals() 메서드를 이용함.
            // 기본 문법
            // 문자열.equals("비교할 문자열");
            // 예시 ) choice.equals("1") // choice 변수에 저장된 문자열이 "1" 문자열 과 같은지 비교

            if (choice.equals("1")) {
                // 회원 가입 기능
                UserService.registerUser(scanner);
                // UserService.registerUser(scanner);
            } 
            else if (choice.equals("2")) {
                // 로그인 기능
                UserService.loginUser(scanner);
            }
            else if (choice.equals("3")) {
                // 산술연산자 기능
                OperConditionTest.oper1();
            }
            else if (choice.equals("4")) {
                // 퀴즈) 기능 호출
                OperConditionTest.oper2();
            } 
            else if (choice.equals("5")) {
                // 로또번호 생성기
                RandomUtil.generateLottoNumbers();
            }
            else if (choice.equals("6")) {
                // 문자개수
                int count = Exs_ch3.ex3_2_quiz(scanner);
            }  
            else if (choice.equals("0")) {
                // 프로그램 종료
                System.out.println("프로그램을 종료합니다. 감사합니다!");
                scanner.close(); // 스캐너 자원 반납
                return; // while 루프 종료
            } 
            else {
                // 잘못된 입력 처리
                System.out.println("잘못된 입력입니다. 1, 2, 3 중에서 선택해주세요.");
            }
            
        }
    }
}
