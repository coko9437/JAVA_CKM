package d250610.ch6;

public class Object_Ex1 { 
    // 모든 클래스는 암묵적으로 Object라는 최고 상위 클래스를 무조건 상속받고있음.
    // 자식 클래스는 부모가 만들어둔 기능을 사용가능함.
        // 사용가능하지만 쓸모가없음.
    // 그래서 우리한테 맞게 변경해서 사용함. (=재정의)
    String name;

    public Object_Ex1(String name) {
        this.name = name;
    }

    // Object 에서 지원해주는 toString에 대해서
        // 1)기본기능으로 사용하기.

        // 2)재정의해서 사용하기.
        @Override
        public String toString() {
            String result = "이 클래스의 멤버변수 name의 값 : " +name;
            return result;
            
        }
}
