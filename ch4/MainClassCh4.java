package ch4;

public class MainClassCh4 {
    //실행하는 클래스
    public static void main(String[] args) {
        // 설계한 클래스를 이용하여 객체 생성
        // [클래스명] 객체명(인스턴스 변수명) = new [클래스명](매개변수);
        Car car1 = new Car();

                   // new Car() : 기본 생성자 : (소괄호 안에 매개변수가 없는 것.)
        
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
        System.out.println("=======================================");        // 메소드
        // Phone : 클래스 이름 / phone : 객체
        Phone phone = new Phone();
        phone.model = "갤럭시S25";
        phone.price = "1,650,000원";
        phone.company = "삼성전자";

        phone.showInfo();
            System.out.println("=======================================");
        // 퀴즈
        // 본인 만들 Phone 클래스를 , 담을 배열을 만들어서,
        // 1) 담기 2) 출력하기. 3) 각 멤버의 주소값 확인 해보기.

        // 앞에서 배운 배열을 이용해서, 클래스 객체를 배열의 요소로 사용하기
        // Phone 클래스 타입을 요소로 가지는 배열.
        Phone[] phones = new Phone[5]; // Phone 타입의 배열 생성, 5개 요소
        // 우리는 기본형으로 정수형, 실수형, 불린형, char, 문자형
        // 클래스 타입으로 인식을 함. -> 참조형 변수(타입)= 레퍼런스 타입
        // 중요한 정보 ,
        // phone1 에는 뭐가 들어가 있을까?
        // 정답은 해당 내용이 저장된 메모리 위치 주솟값이 들어감.
        // 비유, 여러분 돈 -> 은행 통장 -> 계좌번호 -> 돈이 들어있는 통장
        // 내용은 메모리에 넣어두고, 우리 그 메모리 위치 주소만 알면됨 -> 0x100,
        Phone phone1 = new Phone("Galaxy S23", "100만원", "삼성전자");
        Phone phone2 = new Phone("iPhone 14", "120만원", "Apple");
        Phone phone3 = new Phone("Pixel 7", "90만원", "Google");
        Phone phone4 = new Phone("OnePlus 11", "80만원", "OnePlus");
        Phone phone5 = new Phone("Xiaomi 13", "70만원", "Xiaomi");
        // 배열에 객체를 할당
        phones[0] = phone1; // 0번째 요소에 phone1 객체 할당
        phones[1] = phone2; // 1번째 요소에 phone2 객체 할당
        phones[2] = phone3; // 2번째 요소에 phone3 객체 할당
        phones[3] = phone4; // 3번째 요소에 phone4 객체 할당
        phones[4] = phone5; // 4번째 요소에 phone5 객체 할당

        // 직접 할당.
        Phone[] phones2 = {
                phone1,
                phone2,
                phone3,
                phone4,
                phone5
        };

        // 그래서, 각 인스턴스 주소는 , 독립적이다, 다 다른 메모리 위치 주소에 저장이된다.
        // 그러면, 그 위치 주소를 직접확인. 자바스크립트, 힘들고, '
        // 자바는 기능을 지원 해줌.
        // phone1, phone2 의 메모리 주소를 비교 및 확인.
        System.out.println("phone1 주소: " + System.identityHashCode(phone1));
        System.out.println("phone2 주소: " + System.identityHashCode(phone2));

        // 문자열 타입을 요소로 가지는 배열.
        String[] carModels = { "suv", "k5세단", "아반떼", "소나타", "그랜저" };
        // 정수 타입을 요소로 가지는 배열.
        int[] carPrices = { 4000, 3000, 2500, 3500, 5000 }; // 단위 : 만원

        System.out.println("=======================================");
        // 퀴즈
        // 본인 만들 Phone 클래스를 , 담을 배열을 만들어서,
        // 1) 담기 2) 출력하기. 3) 각 멤버의 주소값 확인 해보기.

        Phone[] phoneArray = new Phone[3];
        Phone phone11 = new Phone("아이폰6", "17만원", "애플");
        Phone phone22 = new Phone("아이폰XS", "29만원", "사과");
        Phone phone33 = new Phone("아이폰12 PRO", "48만원", "애플사과");

        phoneArray[0] = phone11;
        phoneArray[1] = phone22;
        phoneArray[2] = phone33;

        Phone[] phoneArray2 = {new Phone("Galaxy S23", "100만원", "삼성전자"), phone2, phone3 };
        
        System.out.println("phoneArray의 주소 : " + System.identityHashCode(phoneArray));
        System.out.println("phone11의 주소 : " + System.identityHashCode(phone11));
        System.out.println("phoneArray2의 주소 : " + System.identityHashCode(phoneArray2));

    }
}
