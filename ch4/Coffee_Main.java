package ch4;

public class Coffee_Main {
    public static void main(String[] args) {

        Coffee Cof1 = new Coffee();
        Cof1.menu = "아메리카노";
        Cof1.price = "2,000원";
        Cof1.capacity = "540ml";
        Cof1.show_info(); // 값 직접 할당
        System.out.println("=========================");

        Coffee Cof2 = new Coffee("카페라떼", "3,300원", "355ml");
        Cof2.show_info(); // 매개변수 3개
        System.out.println("=========================");
        Coffee Cof3 = new Coffee("콜드브루", "2,700원");
        Cof3.show_info(); // 매개변수 2개
        System.out.println("=========================");
        Coffee Cof4 = new Coffee("미니붕어빵");
        Cof4.show_info(); // 매개변수 1개
        System.out.println("=========================");

    // NULL값을 없애는 방법?
        // 1. 가장 확실한 해결책은 모든 필드를 초기화하는 생성자를 사용하는 것
            // ==> Coffee Cof3 = new Coffee("콜드브루", "2,700원", "300ml");
        // 2. 메소드 호출 코드에서 null을 초기화
            // public void show_info() {
        // System.out.println("메뉴는 ? >> " + (this.menu != null ? this.menu : "정보 없음"));
        // System.out.println("가격은 ? >> " + (this.price != null ? this.price : "정보
        // 없음"));
        // System.out.println("용량은 ? >> " + (this.capacity != null ? this.capacity : "정보
        // 없음"));
    }

}
