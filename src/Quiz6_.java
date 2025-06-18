import java.util.Scanner;

public class Quiz6_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean shouldExit = false;
        
        while (true) {
           
            int count = 0;
        
            String word = scanner.nextLine();
            String[] words = word.split(",");

            for (String wordList : words) {
                if(!wordList.isEmpty()) {
                    if (wordList.equals("exit")) {
                        shouldExit = true;   
                    }
                count++;
                }
            }
            if (shouldExit) {
                break;
            }
            System.out.println("어절 개수는 : " +count);
        }
        
        System.out.println("종료합니다...");
        scanner.close();

    }
}
