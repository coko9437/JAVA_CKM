package d250609.ch4;

public class GetterSetterEx {
    
    // public String name; --> 외부에서 접근가능해서 접근지정자 변경해야.
    private String name;
    private String email;
    private String password;

    //매개변수가 3개인 생성자
    public GetterSetterEx(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        
    }

    public void showInfo() {
        System.out.println("이름 >>>" +name);
        System.out.println("이메일 >>>" +email);
        System.out.println("패스워드 >>>" +password);

    }

    // Getter : 데이터를 가져오는 역할
    // Setter : 데이터를 쓰는 역할
    // 접근지정자를 private 사용시에
    // 왜 private 접근 지정자를 사용하나요? 외부에서 해당 데이터에 직접 접근을 막기위해서
    // 캡슐화, 데이터은닉, 숨기기 -> 왜 숨기나요?? 해당 인스턴스 직접 값을 변경하게되면
        // 불변성 또는 데이터 일관성 등이 깨지는 확률이 생김 즉 실수할 확률이 발생.

    // 외부에서 조회하는경우? Getter 를 사용
    public String getName() {
        return this.name; // 여기서 this는 현재 인스턴스에 설정이 된 이름.
    }
    public String getEmail() {
        return this.email; // 여기서 this는 현재 인스턴스에 설정이 된 이름.
    }
    public String getPassword() {
        return this.password; // 여기서 this는 현재 인스턴스에 설정이 된 이름.
    }

        // 외부에서 변경하는경우? Setter 사용함.
        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPassword(String password) {
            this.password = password;
        }

        // 불변성 이유로 Setter 보다는 데이터를 변경하는 메서드를 따로 설정해서 작업함.
}
