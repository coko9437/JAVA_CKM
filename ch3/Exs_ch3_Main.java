package ch3;

import java.util.Scanner;

import ch2.Exs;

public class Exs_ch3_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 방법1
        String[] strings = { "apple", "banana", "cherry", "date" };
        String longestString = ch3.Exs_ch3.ex3_8_quiz3(strings);
        System.out.println("방법1, 가장 긴 문자열: " + longestString);
        // 방법2, strings, 랜덤하게 생성하는 메서드 이용해서,
        String[] randomStrings = ch3.Exs_ch3.generateRandomStrings(5);
        String longestRandomString = Exs_ch3.ex3_8_quiz3(randomStrings);
        System.out.println("방법2, 랜덤 문자열 중 가장 긴 문자열: " + longestRandomString);      


        ch3.Exs_ch3.ex3_8_quiz2();
        scanner.close();

        ch3.Exs_ch3.ex3_8_quiz1(scanner);        


        // ex3_8_2) 배열을 리턴하는 메서드
        // int[] returnArray = Exs_ch3.ex3_8_return(); // 배열 생성, 조회, 반복문 출력 예시
        // System.out.println("ex3-8-2, 리턴된 배열의 값:");
        // for (int number : returnArray) {
        //     System.out.print(number + " "); // 1 2 3 4 5 출력
        // }
        // System.out.println("=============================================================");

        // ch3.Exs_ch3.ex3_8();
        // System.out.println("=============================================================");

        // ch3.Exs_ch3.ex3_7(scanner); 
        System.out.println();
        System.out.println("=============================================================");

        // ch3.Exs_ch3.ex_user_ui(scanner);

        // int menu;
        // do {
        //     System.out.println("회원 관리 프로그램 예시");
        //     System.out.println("=================================================================");
        //     System.out.println("1. 회원 추가 , 2. 회원 조회, 3. 회원 수정, 4. 회원 삭제, 5.더미 데이터5개 추가, 6. 검색기능,  0. 종료");
        //     System.out.println("=================================================================");
        //     System.out.print("메뉴를 선택하세요(0 ~ 5): ");
        //     menu = scanner.nextInt();
        //     scanner.nextLine(); // 개행 문자 제거
        //     switch (menu) {
        //         case 1:
        //             Exs_ch3_2_user_array_doc.addUser(scanner); // 회원 추가
        //             break;
        //         case 2:
        //             Exs_ch3_2_user_array_doc.viewUsers(); // 회원 조회
        //             break;
        //         case 3:
        //             Exs_ch3_2_user_array_doc.updateUser(scanner); // 회원 수정
        //             break;
        //         case 4:
        //             Exs_ch3_2_user_array_doc.deleteUser(scanner); // 회원 삭제
        //             break;
        //         case 5:
        //             Exs_ch3_2_user_array_doc.addDummyUsers(); // 더미 데이터 추가
        //             System.out.println("더미 데이터 5개가 추가되었습니다.");
        //             break;
        //         case 6:
        //             Exs_ch3_2_user_array_doc.searchUser(scanner); // 회원 검색 기능
        //             System.out.println("해당 회원을 검색하였습니다.");
        //             break;
        //         case 0:
        //             System.out.println("프로그램을 종료합니다.");
        //             break;
        //         default:
        //             System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
        //     }

        // } while (menu != 0); // 메뉴가 0이 아닐 때까지 반복
        // System.out.println("=============================================================");

        // Exs_ch3.ex3_6_3();
        System.out.println("=============================================================");

        // Exs_ch3.ex3_6_2();
        System.out.println("=============================================================");

        // Exs_ch3.ex3_6();
        System.out.println("=============================================================");

        // Exs_ch3.ex3_5(scanner);
        System.out.println("=============================================================");

        // Exs_ch3.ex3_4();
        System.out.println("=============================================================");

        // Exs_ch3.ex3_3();
        System.out.println("=============================================================");

        // 퀴즈
        // int count = Exs_ch3.ex3_2_quiz(scanner);
        // System.out.println("입력한 문자 개수: " + count);
        System.out.println("=============================================================");

        // Exs_ch3.ex3_2(scanner);
        System.out.println("=============================================================");

        // int result_ex3_1 = Exs_ch3.getSum(9);
        // System.out.println("Ex3-1) 1~10까지의 합 = " + result_ex3_1);

        // scanner.close();

    }

    
}
