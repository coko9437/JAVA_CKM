package ch3;

import java.util.Scanner;

import ch3.Exs_ch3_Main;

public class Exs_Quiz_array_Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int menu;
        do {
            System.out.println("도서 관리 프로그램 예시");
            System.out.println("=================================================================");
            System.out.println("1. 도서 추가 , 2. 도서 조회, 3. 도서 수정, 4. 도서 삭제, 5. 더미 데이터7개 추가,  6. 도서 검색,  0. 종료");
            System.out.println("=================================================================");
            System.out.print("메뉴를 선택하세요(0 ~ 5): ");
            menu = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 제거
            switch (menu) {
                case 1:
                    Exs_Quiz_array.addBooks(scanner);
                    break;
                case 2:
                    Exs_Quiz_array.viewBooks();
                    break;
                case 3:
                    Exs_Quiz_array.updateBooks(scanner);
                    break;
                case 4:
                    Exs_Quiz_array.deleteBooks(scanner);
                    break;
                case 5:
                    Exs_Quiz_array.addDummyBooks();
                    break;
                case 6:
                    Exs_Quiz_array.searchBooks(scanner);
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
            }

        } while (menu != 0); // 메뉴가 0이 아닐 때까지 반복
        System.out.println("=============================================================");
    }
}
