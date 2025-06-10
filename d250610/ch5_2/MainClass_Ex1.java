package d250610.ch5_2;

public class MainClass_Ex1 {
    public static void main(String[] args) {
        // Dog_Ex1 dog_Ex1 = new Dog_Ex1();
        // dog_Ex1.sound();
        // dog_Ex1.eat(); // 부모가 가지고 있는 메소드
            System.out.println("==============");
        // Cat_Ex1 cat_Ex1 = new Cat_Ex1();
        // cat_Ex1.sound();
        // cat_Ex1.eat();

        // 다향성. 부모타입으로 받아보기
        Animal_Ex1 ani = new Dog_Ex1();
        Animal_Ex1 ani2 = new Cat_Ex1();
        Animal_Ex1 ani3 = new Monkey_Ex1();
        Animal_Ex1 ani4 = new Fish_Ex1();
        
        // 각각의 4가지 종류의 동물들을 배열타입으로?
            // 만드는 타입은 부모타입으로.
        Animal_Ex1[] animals = {ani, ani2, ani3, ani4};

        for (Animal_Ex1 animal_Ex1 : animals) {
            if (animal_Ex1 instanceof Dog_Ex1) {
                Dog_Ex1 dog = (Dog_Ex1) animal_Ex1;
                dog.sound();

            } else if (animal_Ex1 instanceof Cat_Ex1) {
                Cat_Ex1 cat = (Cat_Ex1) animal_Ex1;
                cat.sound(); // 부모클래스(추상클래스)의 메소드 재정의
                cat.eat(); // 부모클래스 기본기능 사용
                cat.move(); // 인터페이스.. 기능 구현
                cat.out(); // 인터페이스.. 기능 구현

            } else if (animal_Ex1 instanceof Monkey_Ex1) {
                Monkey_Ex1 monkey = (Monkey_Ex1) animal_Ex1;
                monkey.sound();

            } else if (animal_Ex1 instanceof Fish_Ex1) {
                Fish_Ex1 fish = (Fish_Ex1) animal_Ex1;
                fish.sound();
            }
        }
    }
}
