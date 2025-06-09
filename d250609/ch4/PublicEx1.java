package d250609.ch4;

public class PublicEx1 {
    // 접근지정자
    // public : 모든 클래스에서 접근가능
    // private : 같은 클래스 내부에서만 접근가능
    // protected : 같은 패키지 또는 상속관계 클래스에만 접근가능
    // (default) : 같은 패키지에서만 
    // 결론... 접근 지정자는 해당 클래스에 접근이 가능한지 여부
    //  예시) 패키지(폴더) 개념임.
    // exA 패키지 : Ex1Test.java
    // ezB 패키지 : Ex2Test.java

    //  각 접근 지정자 확인
    //  멤버변수를 설정
    private String name; // 외부 접근 불가.
    public String eamil; // 모든 클래스에서 접근 가능.
    String phone; // default 생략.. 같은 패키지에서만 접근 가능함.
    protected String hobby; // 같은 패키지 또는 상속 관계 클래스에서만 접근 가능.


    // 기능만들기
    public void showInfo() {
        System.out.println("정보 출력 >>> " + this.name);
        System.out.println("이메일 >>>" + this.eamil);
        System.out.println("전화번호 >>>" + this.phone);
        System.out.println("취미 >>>" + this.hobby);
    }
}
