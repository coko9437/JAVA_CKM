package d250609.ch5_3;

public class PhoneEx1_2 {
    // 부모 클래스
    private String company;
    private String name;
    private String price;

    // 기능
    public void powerOn() {
        System.out.println("전원 켜기");

    }
    public void powerOff() {
        System.out.println("전원 끄기");

    }
    public void callPhone() {
        System.out.println("전화 걸기");

    }

    public void showInfo() {
        System.out.println("제조사 : " +company);
        System.out.println("제품명 : " +name);
        System.out.println("가격 : " +price);
    }

    public PhoneEx1_2() {

    } // !!!주의사항 : 기본생성자 만들어줘야함.
    // 매개변수가 3개인 생성자 만들고, Getter 만들기
    
    public PhoneEx1_2(String company, String name, String price) {
        this.company = company;
        this.name = name;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }
    
}
