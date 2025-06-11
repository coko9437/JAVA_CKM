package util.model;

public class Member {
    // 사용할 멤버변수 : 이름, 패스워드, 이메일, 등록일 ... String타입
    // 생성자 : 매개변수 4개로 구성
    // 각각 정보를 호출하는 메소드 생성
    // 주의사항 : 현재 접근지정자, 상속, 객체지향 모두 배운게 아님
        // 그래서 캡슐화 등 안하고 public으로 함.
    //멤버변수
    String name;
    String password;
    String email;
    String regDate;
    //생성자
    public Member(String name, String password, String email, String regDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.regDate = regDate;

    }
    //메소드
    public void showInfo() {
        System.out.println("회원 이름"+this.name);
        System.out.println("회원 이메일"+this.email);
        System.out.println("회원 패스워드"+this.password);
        System.out.println("회원 등록일"+this.regDate);
    }

    // 검색을 위해서 해당 이름과 이메일 정보를 조회하는기능.
    // 이름 조회 기능 (게터) : 자동 생성 또는 라이브러리에서.
    // 이름조회기능 : 게터
    public String getName() {
        return name;
    }

    // 이메일 조회기능 : 게터
    public String getEmail() {
        return email;
    }
    public void set(int index, Member member) {

        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }
}
