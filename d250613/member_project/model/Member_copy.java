package d250613.member_project.model;


public class Member_copy {
    //멤버변수
    String name;
    String password;
    String email;
    String regDate;

// CSV 쓰는이유
// CSV는 아주 단순하게 한 줄 한 줄 저장되어 있어 
    // 다양한 어플, 엑셀, 데이터베이스에서 쉽게 인식할 수 있습니다.
// 별도의 파서나 라이브러리 필요없이 String.split(",") 만으로 풀 수 있습니다.
// 그냥 메모장이나 엑셀로 바로 열어볼 수 있습니다.
    public String toCsv() {
        return name + "," + password + ","+ email + "," + regDate;
    }


    public static Member_copy fromCSV(String csvLine) {

        String[] parts = csvLine.split(",", -1); 

        if(parts.length !=4) {
            return null;
        }
        return new Member_copy(parts[0], parts[1], parts[2], parts[3]);
    }
    
//===============================================================
    //생성자
    public Member_copy(String name, String password, String email, String regDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.regDate = regDate;

    }
        //메소드
        public void showInfo() {
        System.out.println("회원 이름 :"+this.name);
        System.out.println("회원 이메일 : "+this.email);
        System.out.println("회원 패스워드 : "+this.password);
        System.out.println("회원 등록일 : "+this.regDate);
        }

        // 이름조회기능 : 게터
        public String getName() {
        return name;
        }

        // 이메일 조회기능 : 게터
        public String getEmail() {
        return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRegDate() {
            return regDate;
        }

        public void setRegDate(String regDate) {
            this.regDate = regDate;
        }

        
}
