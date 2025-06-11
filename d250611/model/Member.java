package d250611.model;

public class Member {
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

        // 이름조회기능 : 게터
        public String getName() {
        return name;
        }

        // 이메일 조회기능 : 게터
        public String getEmail() {
        return email;
        }
}
