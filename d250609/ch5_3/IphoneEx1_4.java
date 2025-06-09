package d250609.ch5_3;

public class IphoneEx1_4 extends PhoneEx1_2{
    // 자식클래스
    private String sellPlace;

    public void sellInfo() {
        System.out.println("판매처 : "+sellPlace);
    }
    // 생성자 만들기

    public IphoneEx1_4(String sellPlace) {
        //super();가 생략되어있음. (부모꺼)
        this.sellPlace = sellPlace;
    } //본인꺼
    
    // 매개변수가 4개인 생성자를 한꺼번에 만들기
    public IphoneEx1_4(String company, String name, String price, String sellPlace) {
        super(company, name, price); //명시적으로 표기함.
        this.sellPlace = sellPlace;
    }
}
