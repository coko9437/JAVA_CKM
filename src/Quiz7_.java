import java.util.HashMap;
import java.util.Scanner;

public class Quiz7_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> account = new HashMap<>();

        System.out.println("<< 통장 관리 프로그램입니다. >>");

        while (true) {
            System.out.print("이름과 금액 입력>>");
                String word = scanner.nextLine();
            if (word.equals("exit")) {
                System.out.println("프로그램을 종료합니다...");
                break;
            }

            String[] words = word.split(" ");

            String name = words[0]; 
            int amount = Integer.parseInt(words[1]);
            //name : 이름, amount : 입금금액
            int now_money = account.getOrDefault(name, 0);
            account.put(name, now_money+amount);
            // now_money : 현재잔액
            

            for (String user : account.keySet())
            System.out.print("(" +user+ ">" +account.get(user)+ "원)");
                System.out.println();       
        }
        scanner.close(); 
    }
       
}
// 프로그램은 고객의 이름과 잔액을 누적하여 관리
// 한 고객의 입력이 끝나면 현재까지의 모든 고객의 통장 잔액을 출력
