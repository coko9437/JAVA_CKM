package d250610.ch6;

public class Object_Main_Ex1 {
   
    public static void main(String[] args) {
        Object_Ex1 obj = new Object_Ex1("CKM");
        // Object 부모 클래스의 기본기능 확인 ... 별 쓸모가없음.
        String result = obj.toString(); 

        System.out.println("부모클래스의 기본기능 toString 기능확인 :  " +result);

        // (2) 재정의 후 다시실행시 비교해보기 |메모리위치 주소값형태인지..
        // 우리가 필요한 데이터모양인지
    }

    
}
 