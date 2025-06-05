package user_mini_project;

import java.util.Scanner;

import ch2.OperConditionTest;
import ch3.Exs_ch3;
import util.random.RandomUtil;
import util.user.UserService;

public class MainClass_switch_case {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("========================================================");
            System.out.println("회원 관리 시스템에 오신 것을 환영합니다. 배운거 복습 적용해보기");

            System.out.println("1. 회원 가입  2.로그인 3.산술 연산자 테스트  4.산술 연산자 테스트2  0.종료");
            System.out.println("========================================================");
            System.out.println("메뉴 번호를 선택해주세요 (0~4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    UserService.registerUser(scanner);
                    break;

                case "2":
                    UserService.loginUser(scanner);

                    break;

                case "3":

                    OperConditionTest.oper1();
                    break;

                case "4":

                    OperConditionTest.oper2();
                    break;

                case "5":
                    RandomUtil.generateLottoNumbers();
                    break;
                    
                case "6":
                    int count = Exs_ch3.ex3_2_quiz(scanner);
                    System.out.println("입력한 문자 개수: " + count);
                    break;
                case "0":
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다. 감사합니다!");
                    scanner.close(); // 스캐너 자원 반납
                    return; // while 루프 종료
                default:
                    // 잘못된 입력 처리
                    System.out.println("잘못된 입력입니다. 0, 1, 2 중에서 선택해주세요.");
            } //switch end
        } // while end
    } // main end
}
