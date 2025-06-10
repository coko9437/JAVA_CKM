package d250610.ch6;

import java.util.ArrayList;

public class WrapperMain_Ex1 {
    public static void main(String[] args) {

        // 예시) 문자열 -> Wrapper 객체 변환(Integer)
        Integer intObj1 = Integer.valueOf("123");
        // 기본형 -> 참조형으로 변경을 왜 하나요?
            // 배열, 업그레이드된 배열(컬렉션(리스트,셋,맵))등 사용시,
            // 해당 요소를 클래스 형으로 담아야함. why?
                // 컬렉션의 요소는 전부 타입으로 지정해야함.
            // 자바 : 코틀린 언어... 모든 타입이 객체임
        Integer [] ints = { intObj1};
        // ArrayList arrayList = new ArrayList<Integer>();
        // arrayList.add(intObj1);
        // arrayList.add(1); // 여기서 1은 기본형...
                            // ㄴ 자동으로 참조형으로 박싱이 됨.
//
        // 문자열 -> 기본형 int
        int num1 = Integer.parseInt("12345");
            // ㄴ 여기서 Integer : wrapper클래스
            //  parseInt : 메소드 (정적메소드)
//
        // Wrapper 객체(문자열) -> 기본형
        // Double doubleObj = null;
        double d = Double.parseDouble("135.0");

        // 최대값, 최소값 많이 활용함.
        int num2 = Integer.MAX_VALUE;
        int num3 = Integer.MIN_VALUE;
    }
}
