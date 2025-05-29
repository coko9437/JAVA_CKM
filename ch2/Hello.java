package ch2; //package 폴더

//public : 접근 지정자, 파란색으로 표기되는 부분은 예약어 키워드
//변수명으로 따로 사용 안됨.

//파일명.java  -->> 클래스명 같아야함.
    // 클래스 이름의 첫문자는 대문자여야함.
    // 특수문자는 _ / , / $ 사용가능.
    // 패키지명, 변수명, 함수명(메소드) 는 소문자로 시작함.

public class Hello { // class : 변수, 상수, 함수 기능들의 묶음
    // 정적인 메소드 하나 생성
    // static : 정적 자원(공유 자원)... 나중에 인스턴스 개념과 
        // 구분해서 따로 설명이 필요함.
    // int : 기본형 타입, 현재는 함수의 반환 타입
    // sum : 함수의 이름
    // (int n, int m) : 매개변수, 받는변수
    // return : 함수를 실행 후 반환하는 값.
    // 결론 : 정수로 n, m  값이 들어오면 2개의 값을 더해서 반환함.

    // public static [반환값의 타입] [함수의 이름] ([매개변수1], [매개변수2]) {
    // return 반환 하는 값;
    // }

    public static int sum (int n, int m) {
        return n+m;
    } // 

    public static int mul(int x,int y){
            return x*y;
    }
    
    public static int sub(int x,int y){
           return x-y;
    }

    public static int div(int x,int y){
           return x/y;
    }

    public static float float_div(int x,int y){
           return (float) x/y; // 정수를 입력받아서 계산시, 이것도 정수로 계산이되서
    }

    // public :: 접근 지정자. 누구나 다 접근이 됨(볼 수 있음.)
    // static :: 공유자원 의미 // void :: 반환 값 이 없다는 의미. 
    // main :: 함수의 이름... 메인 함수에서 실행하여 메인으로 종료함.
    // String[] args : --> String : 문자열 타입, [] : 배열을 의미 // args : 배열의 이름(변경 가능)
    public static void main(String[] args) {
        // sum(100, 200) : 함수 이용
        // 사용법 : [받을 변수 타입] [받는 변수명]
            //      함수이름(인자값1, 인자값2);
        // 함수를 사용하면 => 함수가 정의된 곳으로 이동함.
        int result = sum(100, 200);
        // 자바에서 문자열은 ("") 큰따옴표 사이 작성
        // 문자열 + 숫자 = 문자열(타입)
        System.out.println("sum 이라는 함수 이용해서 결과 출력 : " + result);

        // 퀴즈1) 정적 메소드 하나 만들어서 곱하기... result2 에 담아서 출력
        
        // 퀴즈2) ..... 빼기... result3에 담아서
        int result2 = mul(100,200);
        System.out.println("mul 이라는 함수 이용해서 결과 출력 : " + result2);

        int result3 = sub(97,15);
        System.out.println("sub 이라는 함수 이용해서 결과 출력 : " + result3);

        int result4 = div(4,3);
        System.out.println("'div' 라는 함수 이용해서 결과 출력 : " + result4);

        float result5 = float_div(10,4);
        System.out.println("'div' 라는 함수 이용해서 결과 출력 : " + result5);


        //데이터 타입
// 기본형
// bit, byte, int, short, float, long, double, char, boolean
// 참조형
// Object(객체), Array(배열), String(문자열) 등

// 결론 : 클래스 영역과 메인함수 영역을 구분.
//         메인함수로 시작해서 끝까지 한다.
//          메인 함수도 알고보니, 정적인 함수(메소드)임.
//          클래스명, 파일명(.java) 동일해야한다.
//          변수에서 기본형/참조형 이 있는데, 현재는 2개 (int, String) 사용해봄.
//          문자열을 표기시에, 큰 따옴표""로 표기해서 사용한다.
//          정적 메소드(함수)를 정의하고, 사용(호출)시 정의한 메소드로 돌아와서 재사용.
//          클래스 명은 대문자로 시작, 패키지명과 메소드(함수)는 소문자로 시작.
//          이름 작성시 사용 가능한 특수문자는 $ / _ / 두가지만 사용가능.


        int s; // 변수를 정의만 했고, 실제 할당은 안한상태
        char a; // 한 문자만을 의미함
        s = 100;
        a = 'd';
        System.out.println("정수 표현 : " +s);
        System.out.println("문자 표현 : " +a);


        // 이름, 전화번호, 이메일... 매개변수3개, 출력값은 문자열 타입
        // 저는 {이름}입니다.
        // 제 전화번호는 : {전화번호}
        // 저의 이메일주소는 : {이메일}
        String na;
        String num;
        String mail;
        na = "추교문";
        num = "010-8505-2594";
        mail = "coko9437@gmail.com";
        System.out.println("저의 이름은 : " +na +" 이고,");
        System.out.println("저의 전화번호는 : " +num +" 입니다.");
        System.out.println("저의 이메일주소는 : " +mail +" 입니다.");
    }
}

