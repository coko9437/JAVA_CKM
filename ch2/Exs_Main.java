package ch2;

import java.util.Scanner;

public class Exs_Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("사용자 이름을 입력하세요:");
        String name = scanner.nextLine();
        System.out.println("좋아하는 월을 입력하세요 (1~12):");
        String month = scanner.nextLine();
        int monthInt = Integer.parseInt(month);
        // 스캐너 이용해서 받아서 입력.d
        String result_exMini_quiz1 = Exs_doc.exMini_quiz1(name, monthInt);
        System.out.println(result_exMini_quiz1);
        scanner.close();
        
        // EX2-9, 삼항 연산자 예시
        String result = Exs_doc.getTernaryExam(75);
        System.out.println("EX2-9, 삼항 연산자 예시: " + result);
        System.out.println("----------------------------");
        
        Exs_doc.getIncDecExam();
        
        // 강제 형변환 예시
        Exs_doc.getTypeExam();
        
        
        System.out.println("파이널 상수를 이용한 반지름을 이용한 원의 넓이 구하기.");
        String result1 = Exs.getCircleArea(4);
            System.out.println(result1);


    }
}
