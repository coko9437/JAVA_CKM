package ch3;

import java.util.Scanner;

import ch2.Exs;

public class Exs_ch3_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            Exs_ch3.ex3_6_2();
            System.out.println("=============================================================");
            Exs_ch3.ex3_6();    
            System.out.println("=============================================================");

            Exs_ch3.ex3_5(scanner);
            System.out.println("=============================================================");

            Exs_ch3.ex3_4();
            System.out.println("=============================================================");

                Exs_ch3.ex3_3();
                System.out.println("=============================================================");
            
            //퀴즈
            int count = Exs_ch3.ex3_2_quiz(scanner);
                System.out.println("입력한 문자 개수: " + count);
                System.out.println("=============================================================");


            Exs_ch3.ex3_2(scanner);
            System.out.println("=============================================================");


            int result_ex3_1 = Exs_ch3.getSum(9);
                System.out.println("Ex3-1) 1~10까지의 합 = " + result_ex3_1);

        scanner.close();



    }
}
