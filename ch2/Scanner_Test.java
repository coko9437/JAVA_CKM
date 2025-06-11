package ch2;

import java.util.Scanner;

public class Scanner_Test {
    public static void main(String[] args) {
        System.out.println("Scanner Test 시작");

    try (//[클래스명] [변수명] = new [클래스명]();
        Scanner scanner = new Scanner(System.in)) {
            System.out.println("이름을 입력하세요.");
                String name = scanner.nextLine();
            System.out.println("입력한 이름 : "+ name);

            System.out.println("좋아하는 숫자를 입력하세요 : ");
                int number = scanner.nextInt();
            System.out.println("입력한 숫자 : " +number);
        }

    }
}
