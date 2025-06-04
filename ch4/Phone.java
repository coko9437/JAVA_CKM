package ch4;

public class Phone {
    
    //매개변수
    String model;
    String price;
    String company;

    //메소드
    public void showInfo() {
        System.out.println("핸드폰 모델명 : " +this.model);
        System.out.println("가격 : " +this.price);
        System.out.println("제조사명 : " + this.company);
    }
}
