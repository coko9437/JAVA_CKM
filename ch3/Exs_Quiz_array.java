package ch3;

import java.util.Scanner;

import util.date.DateUtil;

public class Exs_Quiz_array {

    static final int MAX_NUM = 255;

    static String[] titles = new String[MAX_NUM];
    static String[] authors = new String[MAX_NUM];
    static String[] publishers = new String[MAX_NUM];
    static String[] prices = new String[MAX_NUM];
    static String[] stocks = new String[MAX_NUM];
    static String[] registrationDates = new String[MAX_NUM];
    static int bookCount = 0;

    // 도서 추가ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    public static void addBook(Scanner scanner) {
        if (bookCount < MAX_NUM) {
            System.out.print("책 제목을 입력하세요 >> ");
            String title = scanner.nextLine();
            titles[bookCount] = title; // 책 제목 저장

            System.out.print("책의 저자를 입력하세요 >>  ");
            String author = scanner.nextLine();
            authors[bookCount] = author; // 책 저자 저장

            System.out.print("출판사를 입력하세요 >>  ");
            String publisher = scanner.nextLine();
            publishers[bookCount] = publisher; // 출판사 저장

            System.out.print("책의 가격을 입력하세요 >>  ");
            String price = scanner.nextLine();
            prices[bookCount] = price; // 가격 저장

            System.out.print("재고수량을 입력하세요 >>  ");
            String stock = scanner.nextLine();
            stocks[bookCount] = stock; // 재고수량

            System.out.print("등록날짜 : ");
            String registrationDate = util.date.DateUtil.getCurrentDateTime();
            registrationDates[bookCount] = registrationDate; // 등록일 저장

            //도서 관리번호 증가
            bookCount++;
            System.out.println("도서가 등록되었습니다. 도서의 제목은 " +titles+ ", 도서의 저자는 : " +authors+ ", 출판사의 이름은 : "
             +publishers+ ", 도서의 가격은  " +prices+ ", 재고 수량은 " +stocks+ ", 해당 도서를 등록한 시간 : " +registrationDates);
            } else {
            System.out.println(" 더이상 책을 등록할 수 없습니다. ");
            }
  
    }

    // 도서조회 메소드ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    public static void viewBooks() {
        if (bookCount == 0) {
            System.out.println("해당 도서가 없습니다.");
            return;
        }
        System.out.println("전산에 등록된 도서 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("인덱스 번호 : " + i + "/ 책 제목: " + titles[i] + ", 책의 저자 : " + authors[i] + ", 출판사명 : "
             + publishers[i] + ", 책의 가격 :" + prices[i] + "원,  재고 수량 :" + stocks[i] + "개, 등록된 날짜 : " + registrationDates[i]);
        }


    }

    // 회원 수정 메서드ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    // 회원 전체 목록에서, 해당 회원의 인덱스를 번호를 이용해서, 회원 정보를 수정해보기.
    public static void updateBook(Scanner scanner) {
        System.out.println("수정할 도서의 인덱스를 입력하세요 (0 ~ " + (bookCount - 1) + "): ");
        int index = scanner.nextInt(); // 수정할 회원의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거
        if (index < 0 || index >= bookCount) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        System.out.println("수정할 책의 제목을 입력하세요: ");
        String title = scanner.nextLine();
        titles[index] = title; // 책 제목 수정

        System.out.println("수정할 책의 저자를 입력하세요: ");
        String author = scanner.nextLine();
        authors[index] = author; // 책 저자 수정

        System.out.println("수정할 출판사명 입력하세요: ");
        String publisher = scanner.nextLine();
        publishers[index] = publisher; // 출판사 수정

        System.out.println("수정할 책의 가격을 입력하세요: ");
        String price = scanner.nextLine();
        prices[index] = price; // 책 가격 수정

        System.out.println("수정할 재고수량을 입력하세요: ");
        String stock = scanner.nextLine();
        stocks[index] = stock; // 재고수량 수정

        // 현재 날짜와 시간 저장
        String registrationDate = DateUtil.getCurrentDateTime();
        registrationDates[index] = registrationDate; // 등록일 수정

        System.out.println("도서의 정보가 수정되었습니다: " + titles[index] + ", "  + authors[index] + ", " 
            + publishers[index] + ", " + prices[index] + ", " + stocks[index]);
            
    }

    // 도서 삭제 메소드
    // 도서 정보의 인덱스 번호를 입력시, 삭제하는 로직.
    public static void deleteBook(Scanner scanner) {
        System.out.println("삭제할 회원의 인덱스를 입력하세요 (0 ~ " + (bookCount - 1) + "): ");
        int index = scanner.nextInt(); // 삭제할 도서의의 인덱스 입력
        scanner.nextLine(); // 개행 문자 제거

        if (index < 0 || index >= bookCount) {
            System.out.println("잘못된 인덱스입니다.");
            return; // 잘못된 인덱스를 입력시, 삭제 기능을 종료 한다는 의미.
        }
        // 삭제할 회원 정보 출력
        System.out.println("삭제하는 도서서 정보: " + titles[index] + ", " + authors[index] + ", " + publishers[index] + ", "
             + prices[index] + ", " + stocks[index] + ", " + registrationDates[index]);

        // 해당 인덱스의 도서 정보를 삭제하고, 뒤에 있는 도서 정보를 앞으로 이동
        for (int i = index; i < bookCount - 1; i++) {
            titles[i] = titles[i + 1];
            authors[i] = authors[i + 1];
            publishers[i] = publishers[i + 1];
            prices[i] = prices[i + 1];
            stocks[i] = stocks[i + 1];
            registrationDates[i] = registrationDates[i + 1];
        }
        // 마지막 도서의 정보는 null로 설정
        titles[bookCount - 1] = null;
        authors[bookCount - 1] = null;
        publishers[bookCount - 1] = null;
        prices[bookCount - 1] = null;
        stocks[bookCount - 1] = null;
        registrationDates[bookCount - 1] = null;

        // 도서 삭제
        bookCount--;
        System.out.println("해당 도서를 삭제하였습니다.");
    }

    // 더미데이터 7개 추가하드 메서드
    public static void addDummyBooks(){
        for (int i = 0; i < 7; i++) {
            if (bookCount < MAX_NUM) {
                titles[bookCount] = "IT공부방법" + (i + 1);
                authors[bookCount] = "이상용" + (i + 1)+" ";
                publishers[bookCount] = "삼성출판사" + (i + 1)+" ";
                prices[bookCount] = " " + (i + 1) + "2,000";
                stocks[bookCount] = "3" + (i + 1);
                registrationDates[bookCount] = DateUtil.getCurrentDateTime();
                bookCount++;
            } else {
                System.out.println("더미정보 추가 실패: 최대로 넣을 수 있는 정보보 초과");
                break;
            }
        }
        System.out.println("도서정보(더미)를 7개 추가하였습니다다.");
    }
}