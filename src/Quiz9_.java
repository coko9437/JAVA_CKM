import java.util.HashMap;
import java.util.Scanner;

public class Quiz9_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> nations = new HashMap<String, Integer>();
        int count = 0;
        System.out.println("나라 이름과 인구를 5개 입력하세요. (예: Korea 5000)");
        while (count < 5) {
            System.out.print("나라 이름, 인구 >> ");
                String input = scanner.nextLine();

            String[] nation = input.split(" ");

            if(nation.length != 2) {
                System.out.println("공백을 사용해서 입력해주세요.");
                continue;
            }

            String name = nation[0];
            int pop = Integer.parseInt(nation[1]);

            nations.put(name, pop);
            count++;

        }
        String min_name =null;
        int min_pop = Integer.MAX_VALUE;
        
        for(String str : nations.keySet()){
            int pop = nations.get(str);
            if (pop < min_pop) {
                min_pop = pop;
                min_name = str;
            }
        }

        System.out.println("제일 인구가 적은 나라는 (" +min_name+ ", " +min_pop+ ")" );
    }
}
