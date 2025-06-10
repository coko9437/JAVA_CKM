package d250610.ch5_2;

public class Dog_Ex1 extends Animal_Ex1{

    @Override
    void sound() {
        System.out.println("멍멍으로 재정의.");
    }// 추상 클래스를 상속받은 자식 클래스는
    //  의무적으로 반드시 추상메소드를 구현해야함.

    
    
}
