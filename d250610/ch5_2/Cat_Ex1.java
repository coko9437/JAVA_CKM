package d250610.ch5_2;

public class Cat_Ex1 extends Animal_Ex1 implements Moveable_Ex1, Outable_Ex1{
    // 상속은 1개만 가능하지만, 인터페이스는 여러개 가능함.
    
    @Override
    void sound() {
        System.out.println("고양이는 야옹.");
    }
    // 추상 클래스를 상속받은 자식 클래스는
    //  의무적으로 반드시 추상메소드를 구현해야함.
        //--------------------------------------------------------------
    @Override
    public void out() {
        System.out.println("야옹이는 앉아서 응가함.");
    }
        // 인터페이스의 추상메소드 구현해줘야함.
    @Override
    public void move() {
        System.out.println("날렵하게 점프 가능");
    }
}
