package ch4;

public class Phone {
    
    // 변수
    String model;
    String price;
    String company;

    public Phone() {
        // 기본 생성자 내용은 비워둠, 필요시 초기화 작업 가능
    }

    // 생성자의 오버로딩 ,같은 생성자이름, 다른 매개변수의 모양(형태)로 정의한 것.

    // 1개의 매개변수를 가지는 생성자
    public Phone(String model) { // 매개변수 매번 다름, 동적인값
        this.model = model; // this.model, 위에 정의한 멤버 변수, model: 동적인 값.
        // price, company는 초기화 안함, 필요시 따로 설정.
    }

    // 2개의 매개변수를 가지는 생성자
    public Phone(String model, String price) { // 매개변수 매번 다름, 동적인값
        this.model = model; // this.model, 위에 정의한 멤버 변수, model: 동적인 값.
        this.price = price;
    }

    // 주의사항, 매개변수가 있는 생성자를 생성시, 기본 생성자는 더이상 지원을 안해줌.
    // 그래서, 만약 기본 생성자를 따로 필요하다면, 따로 만들어야 함.
    
    // 3개 형태의 생성자
    public Phone(String model, String price, String company) { // 매개변수 매번 다름, 동적인값
        this.model = model; // this.model, 위에 정의한 멤버 변수, model: 동적인 값.
        this.price = price;
        this.company = company;
        // 기본 생성자 내용은 비워둠, 필요시 초기화 작업 가능
    }
    // 메소드
    public void showInfo() {
        System.out.println("핸드폰 모델명 : " +this.model);
        System.out.println("가격 : " +this.price);
        System.out.println("제조사명 : " + this.company);
    }
}
