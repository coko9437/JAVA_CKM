package ch4;

public class Car_doc {
    // 설계하는 클래스
    
    // 객체 : 클래스 로 부터 만들어진 실체 (=인스턴스) ==> Car1
    
    // 생성자 : 객체를 생성시 자동으로 호출되는 특별한 메소드
        // 1. 기본 생성자,  2. 매개변수 생성자
    
    // 클래스의 구성품
        // 1) 멤버 변수
        // 2) 생성자
        // 3) 메소드

    // 멤버 변수 (클래스 영역에 선언된 변수)
    String model; //차종 : 세단, SUV
    String price; //가격
    String company; //제조사

    // 생성자
        // 1.기본 생성자 : 클래스명과 동일 .. public Car_doc()
            // 다른 매개변수 생성자가 없으면 기본 지원.
            // 역할 -> 객체를 생성시, 속한 멤버의 값을,
                //지정한 값으로 초기화(변수 할당
                // 기본 생성자가 있는 것과 마찬가지.


        // 2. 매개변수 생성자 : public Car_doc(String model, Stirng price, String company) {   // 3개 다 할수도, 1개만 할수도 있음.
                            //              this.model = model;
                            //              this.price = price;
                            //              this.company = company; 
                            //              }
        // 주의사항, 매개변수가 있는 생성자를 생성시, 기본 생성자는 더이상 지원을 안해줌.
        // 그래서, 만약 기본 생성자를 따로 필요하다면, 따로 만들어야 함.


    // 메소드
    public void showInfo() {
        // this : 현재 객체를 가리키는 키워드
        System.out.println("모델명 : " + this.model);
        System.out.println("가격 : " + this.price);
        System.out.println("제조사 : " + this.company);
    }




}
