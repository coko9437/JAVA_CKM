public class Quiz2_Phone {

    String name;
    String tel;
    String address;

    public Quiz2_Phone() {

    }

    public Quiz2_Phone(String name, String tel, String address) {
        this.name = name;
        this.tel = tel;
        this.address = address;
    }

    public void showInfo() {
        System.out.println(this.name+"의 번호와 주소는 "+this.tel+", "+this.address+" 입니다." );


    }
}
