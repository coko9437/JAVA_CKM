package ch2;

public class Hello0530 {
    public static void main(String[] args) {
        System.out.println("Test~~~출력하기");
        // 만들었던 클래스를 불러와서 재사용해보기.
        // 본인 소개 및, 간단 계산해보기
        // 본인소개.
        String myInfo = Introduce.Introduce("추교문", "010-8505-2594", "coko9437@gmail.com");
        System.out.println(myInfo);
        //Introduce_0529 : 클래스명 , introduce : ''클래스에서 만들어놓은 메소드 가져옴.
        String myHobby = Introduce.Introduce2("크리스피도넛","드라이브","핀볼");
        System.out.println(myHobby);

        // 퀴즈1) Introduce_0529 클래스에 정의한 사칙연산 메소드를 이용해서,
        // 각각 계산 결과를 result1, result2, result3, result4 가져와서 출력해보기

        int result1 = Introduce.sum(5, 10);
        System.out.println(result1);
        int result2 = Introduce.sub(7, 4);
        System.out.println(result2);
        int result3 = Introduce.mul(15, 23);
        System.out.println(result3);
        int result4 = Introduce.div(5, 10);
        System.out.println(result4);
        float result5 = Introduce.float_div(5, 10);
        System.out.println(result5);
}
}
