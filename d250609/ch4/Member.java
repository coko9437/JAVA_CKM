package d250609.ch4;

public class Member {
     // 멤버 변수 : 1) name 2) email 3) password , private 지정
     // 생성자 만들기
    // getter, setter 만들기. 하나씩 조회 및, 수정,
    // 조회는 : showInfo , 각 멤버 정보 호출하는 기능,
    // 수정 : changeNameEmailPassword : 메서드 이름으로 만들기.
    // 실행 후,
    // 1) 각 인스턴스 생성 3개 해보기 
    // 2) 각 인스턴스로 정보 출력, 3) 정보 변경 해보기.
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void showInfo() {
        System.out.println("show 이름 >>> "+ name);
        System.out.println("show 이메일 >>> " + email);
        System.out.println("show 패스워드 >>> " + password);
    }

    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }

        

        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public void changeNameEmailPassword(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        }
}


