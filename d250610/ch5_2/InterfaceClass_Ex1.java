package d250610.ch5_2;

public class InterfaceClass_Ex1 {
    
    // 추상클래스 : 템플릿제공자 - 케이크를 만들기 위한 반죽틀을 주지만
        // 데코는 알아서 하는 구조

    // 인터페이스 : 설계 계약서, 모든 클래스는 이 규칙을 반드시 구현해야함.
        // 기능표준을 보장

    // 추상클래스
        //  is A : 개는 동물이다 (Dog extends Animal)

    // 인터페이스
        // can do 관계 : 새는 날수있다. Bird implements Flyable
    
    
    
    // 인터페이스
        // ㄴ 기능을 갖추기 위한 약속(계약)
    // 자바는 다중 상속을 지원하지 않음. 다중구현을 하기위해서 인터페이스 가 도입됨
        // 키워드 : interface      ||| 상속 : abstract
        // 구현하기위해선 implements ||| 상속 : extends

    // 기능 규약 정의, 설계 기반 제공 등에 사용함.
    // 상수 또는 추상메소드를 기본으로 구성함.

    // 기본예시) 
        // public interface Flyable{
        //  void fly(); <-- 추상메소드 ... 이름만 있고 몸통(구현체)는 없음.
        // }

        // 구현)
        // public class Bird implements Flyable{
        //
        //      @Override
        //      public void fly() {
        //        system.out.println("날기")
        //      }
        // }
}
