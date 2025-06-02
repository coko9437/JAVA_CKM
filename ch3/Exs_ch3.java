package ch3;

import java.util.Scanner;

public class Exs_ch3 {

    public static void ex3_6_3() {
        //기본문법
            // 자료형 [] [] 배열이름 = new 자료형 [행의 수] [열의 수];
        
        //이중배열 선언 및 초기화
        int [][] matrix = {
            {1, 2, 3}
            {4, 5, 6}
            {7, 8, 9}
        };


    }



    public static void ex3_6_2() {
        int[] numbers = {1, 2, 3, 4, 5}; //배열선언과 동시에 값 할당
        // for (자료형타입 변수 : 배열이름) { // 배열에서 각 요소를 하나씩 꺼내서 변수에 할당}
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println(); //줄바꿈
    }


    public static void ex3_6() {
        // 선언하는 방법 크게 2가지
        // 자료형타입 [] 배열이름 = new 자료형타입[크기];  <--기본방식
        // 자료형 배열이름[] = new 자료형[크기];  <--오래된 방식
        int [] numbers = new int[5];
        // 배열에 값 할당
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i + 1;
            }
            // 배열 값 출력
            for (int number : numbers) {
            System.out.print(number + " "); // 1 2 3 4 5 출력
        }
        System.out.println(); // 줄바꿈
    }


    public static void ex3_5(Scanner scanner) {
        // continue
        System.out.println("정수를 5개 입력하세요.");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
                System.out.println("입력한 숫자 : "+ n + "  i 값(인덱스) 확인 : " +i);
            if (n <= 0)
                continue; // 0이나 음수인 경우 더하지 않고 다음 반복으로 진행
            else
                sum += n; // 양수인 경우 덧셈
        }
        System.out.println("양수의 합은 " + sum);
        scanner.close();
    }

    

    public static void ex3_4() {
        for (int i = 1; i < 10; i++) { // 단에 대한 반복. 1단에서 9단
            for (int j = 1; j < 10; j++) { // 각 단의 곱셈
                System.out.print(i + "*" + j + "=" + i * j); // 구구셈 출력
                System.out.print('\t'); // 하나씩 탭으로 띄기
            }
            System.out.println(); // 한 단이 끝나면 다음 줄로 커서 이동
        }
    }

    public static void ex3_3() {
        char a = 'a';
        do {
            System.out.print(a);
            // char 타입의 a -> int 변환시 , 값: 97, 유니코드 값 : 97
            a = (char) (a + 1); // a+1 는 int 타입으로 계산되므로, char로 변환
        } while (a <= 'z');
    }

    // 퀴즈) 사용자로부터 문자를 입력받아 q가 나올때 까지 문자의개수를 세는 프로그램
    public static int ex3_2_quiz(Scanner scanner) {
        // String m;
        // int count = 0;
        // System.out.println("한문자만 입력하세요. 'q'를 입력하면 종료됩니다.");

        // while(true){
        // System.out.println("입력하세요>");
        // m = scanner.nextLine();

        // if (m.equals("q")) {
        // break;
        // }
        // if (!m.isEmpty()) {
        // count++;
        // }
        // }
        // System.out.println("입력한 문자의 총 개수는 "+count+"개 입니다.");

        String total = ""; // 입력된 총 문자열 수

        while (true) {
            System.out.println("문자를 입력하세요 (다음 문장에 q를 입력하면 종료): ");
            String input = scanner.nextLine(); // 한 줄 입력 받기
            total += input; // 입력된 문자열을 누적
            System.out.println("계속 입력하려면 아무키나 입력하고, 종료시에 q를 입력하세요.");
            String command = scanner.nextLine(); // 다음 명령어 입력 받기
            if (command.equals("q")) { // 대소문자 구분 없이 q 입력시 종료
                break; // while 문 종료
            }
        }
        int count = total.length(); // 입력된 문자열의 길이(문자 개수)
        return count;
    }

    // ex3-2) while 문 이용해서 예시
    // 0이 입력되면 while문 종료, 입력한 숫자들의 합을 구하기
    // 숫자는 콘솔에 입력함.
    public static void ex3_2(Scanner scanner) {
        // java.util.Scanner scanner = new java.util.Scanner(system.in);
        int sum = 0;
        int input;

        System.out.println("숫자를 입력하세요 (0입력시 종료)>>>");

        while (true) {
            input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            sum += input;
        }
        System.out.println("입력한 숫자의 합은 : " + sum);
    }

    // ex3-1)
    // 기본 for 이용해서 1~10까지의 합
    // 입력값에 원하는 숫자를 입력시, 1~n 까지의 합을 구하는 메소드로 변경
    public static int getSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("i = " + i);

            sum += i;

            System.out.println("sum = " + sum);
        }

        return sum;

    }
}
