package d250610.ch5_2;

// 추상클래스(공통 기능을 가지는 클래스)
// 추상 메소드를 하나 이상 가져야함.
// 추상 클래스는 인스턴스를 생성할 수 없음.

// 추상 클래스를 상속받은 자식 클래스는
    //  의무적으로 반드시 추상메소드를 구현해야함.
public abstract class Animal_Ex1 {
    abstract void sound(); // <-- 추상 메소드

    void eat() { // <-- 일반 메소드
        System.out.println("먹기");
    }
}
