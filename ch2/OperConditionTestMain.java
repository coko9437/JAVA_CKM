package ch2;

import java.util.Scanner;

import ch2.OperConditionTest;

public class OperConditionTestMain {
//OperConditionTest 에서 만든 메서드를 1차적으로 확인하는 클래스
    public static void main(String[] args) {
        System.out.println("연산자 확인 및 조건문 테스트 시작");
        // 순서2,
        // 만든 메서드, 확인 1
        OperConditionTest.oper1(); // 산술 연산자 테스트
            System.out.println("=======================================================");
        System.out.println("퀴즈) 임의의 산술 연산자 사용 테스트");    
            System.out.println("=======================================================");
        OperConditionTest.oper2();

        System.out.println("테스트중");
        Scanner scanner = new Scanner(System.in);
        OperConditionTest.oper01(scanner);
        scanner.close();

    }
    
}
