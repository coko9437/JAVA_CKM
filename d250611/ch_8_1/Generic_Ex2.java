package d250611.ch_8_1;

import d250611.model.Member;


public class Generic_Ex2<T> { //Generic_Ex2<T> : 제너릭 클래스 선언
    
    private T value; // T타입의 인스턴스(변수) 선언 --> 실제 타입은 객체를 생성할때 정해짐.
    public void set(T value) { // set : Setter의 의미
        this.value = value; // T 값을 설정함.
    }

    //set(T value)와 get() 메서드는 T 타입의 값을 설정하고 가져오는 역할
    public T get() { // get : Getter 의미..
        return value;
    }

    public static void main(String[] args) {
        // 타입을 문자열로 <T> ==>> <String>
        Generic_Ex2<String> boxString = new Generic_Ex2<>(); // T를 String으로 지정, boxString을 String타입으로.
        boxString.set("이상용");

        String resultStr1 = boxString.get();
        System.out.println("제너릭으로 타입을 설정한 클래스의 인스턴스를 생성후 정보 가져오기 >>");
            System.out.println("값 : "+resultStr1);

        // 타입을 정수로. <T> ==>> <Integer>
        Generic_Ex2<Integer> boxInteger = new Generic_Ex2<>();
        boxInteger.set(100);
        Integer resultInt = boxInteger.get();
        System.out.println("제너릭 타입을 Integer 버전으로 >> ");
            System.out.println("값 >> " +resultInt);

        // 타입을 <T> ==>> <멤버> ==>> 클래스 형으로 작업 [추천]
        Generic_Ex2<Member> boxMember = new Generic_Ex2<>();
        // 방법1
        boxMember.set(new Member("이상용", "1234", "lsy@naver.com", "2025-06-11"));
                // ㄴ 이 방법은 Member 객체를 재사용 하지 못함.
        // 방법2
        Member member = new Member("이상용", "1234", "lsy@naver.com", "2025-06-11");
        boxMember.set(member);
        boxMember.get().showInfo();

    }

   
}
