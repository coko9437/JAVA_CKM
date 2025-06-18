import java.util.Scanner;

public class Quiz5_CircleArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// getArea() : r * r * 3.14;
        System.out.print("1 반지름 >> ");
            int r1 = scanner.nextInt();
            Quiz5_Circle radius1 = new Quiz5_Circle(r1);
            double R1 = radius1.getArea();
                // System.out.println("R1의 면적" +R1);
        System.out.print("2 반지름 >> ");
            int r2 = scanner.nextInt();
            Quiz5_Circle radius2 = new Quiz5_Circle(r2);
            double R2 = radius2.getArea();
        System.out.print("3 반지름 >> ");
            int r3 = scanner.nextInt();
            Quiz5_Circle radius3 = new Quiz5_Circle(r3);
            double R3 = radius3.getArea();
        System.out.print("4 반지름 >> ");
            int r4 = scanner.nextInt();
            Quiz5_Circle radius4 = new Quiz5_Circle(r4);
            double R4 = radius4.getArea();
        System.out.println("저장하였습니다...");
        System.out.println("원의 면적 전체 합은 "+(R1+R2+R3+R4));

        // System.out.println("원의 면적 전체 합은  ");
    }
}
