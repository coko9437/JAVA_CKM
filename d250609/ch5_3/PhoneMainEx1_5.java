package d250609.ch5_3;

public class PhoneMainEx1_5 {
    public static void main(String[] args) {
        // 기본 인스턴스 2개 생성후 정보확인

        IphoneEx1_4 iphoneEx1_4 = new IphoneEx1_4("애플", "아이폰16", "200만원", "롯데백화점");
        iphoneEx1_4.showInfo();
        // iphoneEx1_4.getCompany();
        System.out.println("============================================");

        GalaxyEx1_3 galaxyEx1_3 = new GalaxyEx1_3("삼성", "갤럭시S25", "190만원", "SAMSUNG");
        galaxyEx1_3.showInfo();
        System.out.println("============================================");
        // 형 변환, 업캐스팅 또는 다운캐스팅 확인...
        // 갤럭시는 폰이다. 아이폰은 폰이다 ==>> Is A 관계(상속)
        // 갤럭시 아이폰 모두 폰 타입으로 받아도 될까?

        PhoneEx1_2 phoneIphone = new IphoneEx1_4("애플", "아이폰16", "210만원", "롯데백화점");
        // 부모클래스 자식클래스
        // 지금은 부모클래스의 타입임(PhoneEx1_2)

        // 형 확인하는 연산자 이용해보기 (instanceof)
        if (phoneIphone instanceof IphoneEx1_4) {
            // 다운 캐스팅 : 위에서 아래로 |부모클래스 -->> 자식클래스 타입으로 변환
            IphoneEx1_4 iphoneEx1_4_2 = (IphoneEx1_4) phoneIphone;
            iphoneEx1_4_2.sellInfo();
            System.out.println("형 이 아이폰 클래스형 이 맞다면 여기에만 있는 기능 확인");
        } // -->> 원래대로 본인의 형으로 변환함 (폰 -> 아이폰)
        else if (phoneIphone instanceof GalaxyEx1_3) {
            GalaxyEx1_3 galaxyEx1_3_2 = (GalaxyEx1_3) phoneIphone;
            galaxyEx1_3_2.logoInfo();
            System.out.println("형 이 갤럭시 클래스형 이 맞다면 여기에만 있는 기능 확인");
        }
        
        // 다형성
        // 갤럭시는 폰이다 / 아이폰은 폰이다.
        // 현재는 A is B
        // 받을때는 큰범위로 받고서, 실제 사용시엔 원래 클래스 형 을 맞춰서 사용을 해야함.
        // 모델 클래스를 만들어서 형 일치 시켜놓고 작업함
        // A a = new A(); 여기서 a는 A
        // A a = new B(); 여기서 a는 B

        PhoneEx1_2 phoneGalaxy = new GalaxyEx1_3("삼성", "갤럭시S25U", "213만원", "SAMSUNG");
        // phoneGalaxy.logoInfo(); // 주의사항!! 현재 타입은 부모타입(Phone)이므로
        // 자식타입의 인스턴스 메소드(logoInfo) 를 가져올 수 없음.
        // 아무타입으로 변경하면 안되니 그래서 형을 확인해야함.
        System.out.println("============================================");
        
        if (phoneGalaxy instanceof IphoneEx1_4) {
            // 다운 캐스팅 : 위에서 아래로 |부모클래스 -->> 자식클래스 타입으로 변환
            IphoneEx1_4 iphoneEx1_4_3 = (IphoneEx1_4) phoneGalaxy;
            iphoneEx1_4_3.sellInfo();
            System.out.println("형 이 아이폰 클래스형 이 맞다면 여기에만 있는 기능 확인");
        } // -->> 원래대로 본인의 형으로 변환함 (폰 -> 아이폰)
        else if (phoneGalaxy instanceof GalaxyEx1_3) {
            GalaxyEx1_3 galaxyEx1_3_3 = (GalaxyEx1_3) phoneGalaxy;
            galaxyEx1_3_3.logoInfo();
            System.out.println("형 이 갤럭시 클래스형 이 맞다면 여기에만 있는 기능 확인");
        }

    }
}
