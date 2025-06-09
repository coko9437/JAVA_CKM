package d250609.ch4;

public class GetterSetterExMain {
    public static void main(String[] args) {
        GetterSetterEx getterSetterEx = new GetterSetterEx("이상용", "lsy@naver.com", "1234");
            // private : 데이터 직접 접근을 막는다.
        // getterSetterEx.name = " 직접 접근해서 이름: 수정이상용"; // 직접 접근해서 임의로 수정함.
        // getterSetterEx.email = "lsy@naver.com 수정";
        // getterSetterEx.password = "패스워드 수정";
        getterSetterEx.showInfo();
            System.out.println("==================================================");
        System.out.println("Getter 라는 메소드 사용해서 각 멤버변수 하나 조회확인용");
        System.out.println("이름 조회 >>>  " + getterSetterEx.getName());
        System.out.println("이메일 조회 >>>  " + getterSetterEx.getEmail());
        System.out.println("패스워드 조회 >>>  " + getterSetterEx.getPassword());
            System.out.println("==================================================");
        System.out.println("Setter 라는 메소드 사용해서 각 멤버변수 하나 수정 확인용");
        getterSetterEx.setName("이상용을 수정");
        getterSetterEx.setEmail("gmail.com");
        getterSetterEx.setPassword("98765");
            getterSetterEx.showInfo();
    }
}
