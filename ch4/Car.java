package ch4;

public class Car {
   
   // 퀴즈1
    // 설계 클래스, Phone ,
    // 멤버 변수 : model, price, company
    // 메서드 : showInfo(), 해당 정보 출력하는 메서드 만들기.
    // 객체 3개 이상 생성후, 정보 출력하는 메소드 사용해보기
   
   
    // 멤버 변수
    String model; //차종 : 세단, SUV
    String price; //가격
    String company; //제조사

   

    // 메소드
    public void showInfo() {
        // this : 현재 객체를 가리키는 키워드
        System.out.println("모델명 : " + this.model);
        System.out.println("가격 : " + this.price);
        System.out.println("제조사 : " + this.company);
    }




}
