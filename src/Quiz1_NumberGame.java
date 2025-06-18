import java.util.Scanner;

public class Quiz1_NumberGame {
    public static void main(String[] args) {
        System.out.println("=== 숫자 맞추기 게임을 시작합니다. ===");
            System.out.println("컴퓨터가 숫자를 생각했습니다.");
                Scanner scanner = new Scanner(System.in);
        int input;
        int count = 0;
        long ans = Math.round(Math.random() * 100) +1;
        if (ans %2 == 0) {
            System.out.println("힌트는 짝수입니다.");
        } else {
            System.out.println("힌트는 홀수입니다.");
        }

        while (true) {
            System.out.print("1~100사이의 값을 입력 >> ");
                input = scanner.nextInt();
            count++;
            if(input < ans) {
                System.out.println("더 큰 수입니다.");
            } else if (input > ans) {
                System.out.println("더 작은 수입니다.");
            } else{
                System.out.println(count+"회 만에 맞췄습니다.");
                break;
            }
        }
        scanner.close();
        System.out.println("=== 게임을 종료합니다. ===");
    }
}