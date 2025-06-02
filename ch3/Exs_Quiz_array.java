package ch3;

import java.util.Scanner;

public class Exs_Quiz_array {
    static final int MAX_NUM = 255;

    static String[] titles = new String[MAX_NUM];
    static String[] authors = new String[MAX_NUM];
    static String[] publishers = new String[MAX_NUM];
    static String[] prices = new String[MAX_NUM];
    static String[] stocks = new String[MAX_NUM];
    static String[] registrationDates = new String[MAX_NUM];
    static int bookCount = 0;

    // 도서 추가
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
    public static void viewBooks() {
        if (bookCount == 0) {
            System.out.println("해당 도서가 없습니다.");
            return;
        }
        System.out.println("전산에 등록된 도서 목록:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("인덱스 번호 : " + i + ". 제목: " + titles[i] + ", 책의 저자 : " + authors[i] + ", 출판사명 : " +publishers + "등록 날짜 : " + registrationDates[i]);



    }    



































}

