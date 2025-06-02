package ch2;

import java.util.Scanner;

public class Exs_doc {
   
    // 퀴즈) 사용자 이름 입력을 받고, 좋아하는 월 입력받고,
    // 메서드 예시) exMini_quiz1
    // 좋아하는 월에 따른 계절의 이름 출력. 봄(3~5),여름(6~8),가을(9~11),겨울(12~2)
    // switch문 이용 // if~else if 문 이용해서 구현하기.
    // 출력은 : ""님이 좋아하는 월 은 5월입니다. 5월은 봄 입니다.
    public static String exMini_quiz1(String name, int month) {
    // public static void exMini_quiz1() {
    //     Scanner scanner = new Scanner(System.in);
    //         System.out.println("당신의 이름을 입력하세요 >>>");
    //             String name = scanner.nextLine();
    //         System.out.println("좋아하는 월의 숫자(1~12)를 입력하세요 >>>");
    //             int month = scanner.nextInt();
            
        String season = "";
        switch (month) {
            case 3:
            case 4:
            case 5:
                season = "봄";
                break;
            case 6:
            case 7:
            case 8:
                season = "여름";
                break;
            case 9:
            case 10:
            case 11:
                season = "가을";
                break;
            case 12:
            case 1:
            case 2:
                season = "겨울";
                break;
            default:
                return "잘못된 월입니다.";
        }
        // System.out.println(name+"님 안녕하세요");
        // System.out.println("당신이 좋아하는 월은 " +month +"월, 좋아하는 계절은 "+ season +"입니다.");
        
        String result = "" + name + "님, 좋아하는 월은 " + month + "월입니다. 계절은 " + season + "입니다.";
        // return String.format("%s님, 좋아하는 월은 %d월입니다. 계절은 %s입니다.", name, month, season);
        return result;
    }



    // if 문 이용 가능하지만, 조건 연산식으로, 표현.
    // 삼항 연산자 예시, 조건 ? 참일 때 : 거짓일 때
    public static String getTernaryExam(int score) {
        // score가 60 이상이면 "합격", 아니면 "불합격" 문자열 반환
        String result = (score >= 60) ? "합격" : "불합격";
        // if 문으로도 가능
        // if (score >= 60) {
        // result = "합격";
        // } else {
        // result = "불합격";
        // }
        return result;
    }

    public static void getIncDecExam() {
        int a = 10;
        int b = 20;

        // a++ : 후위 연산자 --> a의 값을 먼저 사용하고, 나중에 1증가
        // ++a : 전위 연산자 --> a의 값을 먼저 1증가시키고, 그 다음에 사용
        System.out.println("a++: " + (a++)); // 10 출력 후, a는 11로 증가
        System.out.println("결과1 a: " + a); // 11 출력
        System.out.println("++a: " + (++a)); // 12 출력
        System.out.println("결과2 a: " + a); // 12 출력
        
        // 복합 대입 연산자
        b += 5; // b = b + 5; b는 이제 25
        System.out.println("b += 5: " + b);
    }


    //타입변환
    public static String getTypeExam(){
        
        
        // 왼쪽 : 받는 타입 임.
        long num1 = 100L; // long 타입변수 : 8바이트 
        long num2 = 100;    // 여기서 100 : int타입임(4바이트)
        // -> int타입 100을 long 타입으로 형변환 ==> 자동 형변환임.

        // 작은쪽에서 --> 큰쪽으로 형변환 시 문제가 없음.
        
        // 반대로 큰쪽(타입)에서 작은쪽(타입)으로 형 변환 시 문제 생김.
        byte num3 = 127; // 128은 byte타입 범위를 넘어감
        int num4 = 128;

        // 강제로 형변환 int num4 , -> 강제로 byte 타입으로 변환
        // 값의 손실이 발생하거나, 정상적인 출력이 안나옴.
        // 예시로 확인만.
        byte num5 = (byte) num4;
        System.out.println("num5: " + num5);
        // return "곧 결과 반환 하거나 출력만 할 예정.";
        


        return "곧 결과 반환함.";



    }





    // 정적 메소드 이용
    // 확인 사항 : 파이널, 상수 확인 및 원 면적 구하는 기능
    // 반지름을 매개변수로 받고, 원의 면적을 문자열 타입으로 반환

    public static String getCircleArea(double radius) {
        final double PI = 3.14159; //원주율 상수
        
            if (radius <0){
            return "반지름은 음수가 될 수 없습니다.";
            }
        double area = PI * radius * radius;
        // 여기서 PI는 재할당 불가함.(컴파일에러)  즉, PI = 3.14159123412; <-- 불가능
        // String.format : 기본옵션
        // 소수점 둘째 자리까지 출력
        // %.2f : 소수점 둘째 자리까지 출력 -> radius
        // %.2f : 소수점 둘째 자리까지 출력 -> area

        String result = String.format("반지름 %.2f의 원의 면적은 %.2f입니다.", radius, area);
        return result;
    }
    
}
