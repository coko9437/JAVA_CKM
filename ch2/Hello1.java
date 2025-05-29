package ch2;


public class Hello1 {
//클래스 메소드
    
    public static int sum (int n, int m) {
    return n+m;
    }
    //sum 메소드
    // Java에서는 메소드 안에 또 다른 메서드를 정의할 수 없습니다.

    // public static void main(String[] args)는 하나의 메서드인데, 그 안에 public static int sum(...)를 넣으면 
        // **"메소드 안에 메소드를 선언했다"**는 것이 되어 컴파일 에러가 발생합니다.
    public static void main(String[] args) {
    // main 메소드

    int result = sum(100, 200);
        // 자바에서 문자열은 ("") 큰따옴표 사이 작성
        // 문자열 + 숫자 = 문자열(타입)
        System.out.println("sum 이라는 함수 이용해서 결과 출력 : " + result);
    }
}
