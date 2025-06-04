package ch4;

public class MainClassCh4 {
    //실행하는 클래스
    public static void main(String[] args) {
        // 설계한 클래스를 이용하여 객체 생성
        // [클래스명] 객체명(인스턴스 변수명) = new [클래스명]();
        Car car1 = new Car();
                   // new Car() : 기본 생성자
        
        // 해당 자동차의 멤버변수에 값 대입... 직접 값을 할당함.
            // BUT 실무에서는 이렇게 사용안함
        // --> getter / setter 메소드를 사용 ==> 불변성을 이용해서 캡슐화 함.
            // 밖에서 안보이게 접근 지정자로 숨길 예정.
        car1.model = "SUV";
        car1.price = "4000만원";
        car1.company = "기아자동차";

        // 기능확인... 객체명.메소드명(); 형식
        // 이전까지썼던 정적인 메소드?? 클래스명.메소드명();
        car1.showInfo();
        System.out.println();
        // 또다른 인스턴스를 생성 (기성품 처럼)

        Car car2 = new Car();
        car2.model = "K5 세단";
        car2.price = "3000만원";
        car2.company = "기아자동차";

        car2.showInfo();
        System.out.println();
        // 메소드

        Phone phone = new Phone();
        phone.model = "갤럭시S25";
        phone.price = "1,650,000원";
        phone.company = "삼성전자";

        phone.showInfo();

    }
}
