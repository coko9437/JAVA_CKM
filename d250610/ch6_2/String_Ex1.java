package d250610.ch6_2;

public class String_Ex1 {
    // 자주 사용하는 문자열은 타입이 참조형임 (기본형XX)
    // --> 도장을 찍어 내듯이 사용함,

    // 문자열을 변경할 때 새로운 메모리값을 사용함.
        // 그래서 메모리낭비가 많음.
    // 대책으론 이걸 업그레이드 해보자.
        // StringBuffer 클래스가 등장 (재사용 가능!)
    public static void main(String[] args) {
        
    
    String str = "hello"; // 리터럴 방식
    String str2 = new String(" JAVA"); // 객체를 생성하는 방식 

    String str3 = str + str2 + " HI!!!!";
        
    System.out.println("str (임시)메모리주소 확인 : " +System.identityHashCode(str));
    System.out.println("str2 (임시)메모리주소 확인 : " +System.identityHashCode(str2));
    System.out.println("str3 (임시)메모리주소 확인 : " +System.identityHashCode(str3));
        System.out.println("결과물 확인 str3 : " +str3);
    // 출력결과 확인할때마다 매번 다른 메모리주소임.


    // StringBuffer 클래스를 이용해서 똑같이 시도해보자.
    StringBuffer sb = new StringBuffer();
    sb.append("Hello");
    sb.append("Bye~");
    
    String result = sb.toString();
        System.out.println("sb 문자열은 >>> "+sb);
        System.out.println("result 값은 : "+result);
        System.out.println("StringBuffer를 이용한 메모리주소 : " +System.identityHashCode(sb));
    }
}
