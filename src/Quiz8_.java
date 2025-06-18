import java.util.HashMap;
import java.util.Scanner;

public class Quiz8_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        HashMap<String, Integer> drink = new HashMap<>();
        drink.put("밀키스", 700);
        drink.put("코카콜라", 800);
        drink.put("펩시", 1000);
        drink.put("칠성사이다", 1200);

        System.out.println("밀키스, 코카콜라, 펩시, 칠성사이다 있습니다.");
        while (true) {
            System.out.print("선택 >> ");
                String d_name = scanner.nextLine();
                    if (d_name.equals("그만")) {
                        System.out.println("종료합니다...");
                        break;
                    }
            if (drink.containsKey(d_name)) {
                int price = drink.get(d_name);
                System.out.println(d_name+ "는 " +price+"원 입니다.");
            }

        }

    }
}
