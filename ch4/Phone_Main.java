package ch4;

public class Phone_Main {
    public static void main(String[] args) {

        // 앞에서 배운 배열을 이용해서, 클래스 객체를 배열의 요소로 사용하기
        // Phone 클래스 타입을 요소로 가지는 배열.
        Phone[] phoneArray = new Phone[3];

        // phone1 에는 뭐가 들어가 있을까?
        // 정답은 해당 내용이 저장된 메모리 위치 주소값이 들어감.
        // 비유, 여러분 돈 -> 은행 통장 -> 계좌번호 -> 돈이 들어있는 통장
        // 내용은 메모리에 넣어두고, 우리 그 메모리 위치 주소만 알면됨 -> 0x100,
        Phone phone11 = new Phone("아이폰6", "17만원", "애플");
        Phone phone22 = new Phone("아이폰XS", "29만원", "사과");
        Phone phone33 = new Phone("아이폰12 PRO", "48만원", "애플사과");
        // 배열에 객체를 할당
        phoneArray[0] = phone11;
        phoneArray[1] = phone22;
        phoneArray[2] = phone33;
        // 직접 할당.
        Phone[] phoneArray2 = {new Phone("Galaxy S23", "100만원", "삼성전자")};
        
        System.out.println("phoneArray의 주소 : " + System.identityHashCode(phoneArray));
        System.out.println("phone11의 주소 : " + System.identityHashCode(phone11));
        System.out.println("phoneArray2의 주소 : " + System.identityHashCode(phoneArray2));
    }
}
