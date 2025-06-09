package d250609.ch5;

public class Animal_Ex1 { // 부모클래스
    
    protected String name;

    public void speak() {
        System.out.println("동물 소리를 냅니다.");
    }

    public Animal_Ex1() {
        super(); // 모든 클래스는 Object 부모 클래스를 상속받고있다.
    }

    public Animal_Ex1(String name) {
        this.name = name;
    }
}
