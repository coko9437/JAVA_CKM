package ch4;

public class Coffee {
    
    //멤버변수
    String menu;
    String price;
    String capacity;

    // 기본생성자
    public Coffee() { // 기본 생성자 호출, Coffee() : 소괄호안에 매개변수가 없는 것.
        // 값을 직접 할당. 실무에서는 private 선언하고, setter 등으로 설정함, 캡슐화,

    }

    // 매개변수 1개의 생성자
    public Coffee(String menu) {
        this.menu = menu;
        
    }

    // 매개변수 2개의 생성자
    public Coffee(String menu, String price) {
        this.menu = menu;
        this.price = price;
       
    }

    // 매개변수 3개의 생성자
    public Coffee(String menu, String price, String capacity) {
        this.menu = menu;
        this.price = price;
        this.capacity = capacity;
    }

    // 호출하는 메소드
    public void show_info() {
        System.out.println("메뉴는 ? >>" +this.menu);
        System.out.println("가격은 ? >>" +this.price);
        System.out.println("용량은 > >>" +this.capacity);

    }
}
