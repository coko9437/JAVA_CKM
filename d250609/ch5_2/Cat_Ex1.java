package d250609.ch5_2;

import d250609.ch5.Animal_Ex1; // 다른패키지의 클래스를 사용함

// 자식 클래스이므로, 부모의 protected의 멤버변수의 접근이 가능함.
public class Cat_Ex1 extends Animal_Ex1{
    String favoriteFood;


    public void showInfo() {
        System.out.println("좋아하는 음식 : " +favoriteFood);
        // 상속을 안받고 다른 패키지 다른폴더의 클래스의 멤버에 접근시도.

    }
    // 기본 생성자가 생략되어있음.
    // public Cat_Ex1() {
        // super(); Animal_Ex1 부모꺼 생략... --> why? 기본 생성자라서
    // }

    public Cat_Ex1() {
        
    }


    // 초기화를 쉽게하기위해서 매개변수 생성자를 만들기.
    public Cat_Ex1(String name, String favoriteFood) {
        super(name);
    }
}
