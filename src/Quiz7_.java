import java.util.HashMap;
import java.util.Scanner;

public class Quiz7_ {





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> accounts = new HashMap<>();

        System.out.println("<< 통장 관리 프로그램입니다. >>");
        while (true) {
            System.out.print("이름과 금액 입력>>");
                String word = scanner.nextLine();

            if (word.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                break;
            }
            String[] words = word.split(" ");

            if(words.length != 2 ){
                System.out.println("다시 입력해 주세요.");
                continue;
            }

            
        }

            
// 프로그램은 고객의 이름과 잔액을 누적하여 관리
// 한 고객의 입력이 끝나면 현재까지의 모든 고객의 통장 잔액을 출력






    }
}
