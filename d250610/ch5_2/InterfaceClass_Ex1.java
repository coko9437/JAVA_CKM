package d250610.ch5_2;

public class InterfaceClass_Ex1 {
    // 인터페이스
        // ㄴ 기능을 갖추기 위한 약속(계약)
    // 자바는 다중 상속을 지원하지 않음. 다중구현을 하기위해서 도입됨
        // 키워드 : interface      ||| 상속 : abstract
        // 구현하기위해선 implements ||| 상속 : extends

    // 기능 규약 정의, 설계 기반 제공 등
    // 상수 또는 추상메소드를 기본으로 구성함.

    // 기본예시) 
        // interface Flyable{
        //  void fly(); <-- 추상메소드
        // }

        // 구현)
        // class Bird implements Flyable{
        //
        //      @Override
        //      public void fly() {
        //        system.out.println("날기")
        //      }
        // }
}
