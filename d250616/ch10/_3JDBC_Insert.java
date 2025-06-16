package d250616.ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import d250611.member_project.util.DateUtil;

public class _3JDBC_Insert {
    public static void main(String[] args) {
// 1. 디비 서버에 접근을 위한 준비물
    // 1)드라이버 위치, 2) 유저명, 3) 패스워드, 4) 디비서버의 아이피 및 포트번호

        String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 디비 서버 아이피, 포트, 서비스 이름
        String user = "scott";  //접속할 유저
        String password = "tiger";  //패스워드
        String driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버 위치

    // 객체를 미리 선언만 하고, 초기화는 밑에서... (전역에 사용할 수 있게 선언만)
        Connection conn = null;
        PreparedStatement pstmt = null;
            // ResultSet rs = null; <- 조회 할때만 필요.

        try {
            
// 2. 드라이버 로딩, ojdbc8_g.jar 압축파일에서, 필요한경로를 찾아감.
    // 예) Class.forName(driver위치); -> 대신, .vscode폴더에서 오라클드라이버의 .jar파일을 메모리상에 로드함.
        Class.forName(driver);
            System.out.println("2. 드라이버 로딩 완료");

// 3. Connection 맺기
    // 자바 코드와 오라클 데이터베이스를 연결하는것 을 의미함.
    // java.sql 패키지에서 Connection 클래스 기능을 이용해서 접근한다.
    // 예시) Connection conn = DriverManager.getConnection(url, user, password)
        conn = DriverManager.getConnection(url, user, password);
            System.out.println("3. Connection 맺기 완료");

// 4. SQL문 작성
    // 자바에서 데이터베이스에 요청할 SQL을 문자열로 저장하고 전달.
    // 주의사항) 세미콜론을 입력하지 않는다. (자바 아님!!)
        // 예시) String query = "select sysdate from dual"
    // INSERT INTO member501 (id, name, password, email, reg_date) VALUES (
    // member501_seq.nextval, '이상용', '1234', 'lsy@naver.com', '2025년06월16일12시09분'
    
    // 수동으로 작성
    // String query = "INSERT INTO MEMBER501 (ID, NAME, PASSWORD, EMAIL, REG_DATE)" +
        // "VALUES(?, ?, ?, ?, ?)";

            // 만약, 자동인덱스생성 으로 작성할 경우
            String query = "INSERT INTO MEMBER501 (ID, NAME, PASSWORD, EMAIL, REG_DATE)" +
            "VALUES(MEMBER501_SEQ.NEXTVAL, ?, ?, ?, ?)";
        System.out.println("4. SQL 문 작성 완료");

// 5. PreparedStatement 생성
    // 요청할 SQL 문 을 데이터베이스에 전송할 때 사용하는 기능(API)
    // 예시) PreparedStatement pstmt = conn.prepareStatement(query)
        pstmt = conn.prepareStatement(query);
            // 쓰기전 추가할 데이터를 해당 와일드카드(?)에 해당하는 데이터를 임시로
            // -> 하드코딩으로 넣고있고, 화면에서 데이터를 사용자로부터 받아서 추가 할 예정.

            // 직접 ID 수동으로 넣을경우
            // pstmt.setInt(1, 100);
            // pstmt.setString(2, "이상용");
            // pstmt.setString(3, "1234");
            // pstmt.setString(4, "lsy@naver.com");
            // String date = DateUtil.getCurrentDateTime();
            // System.out.println(date);
            // pstmt.setString(5, date);
            

            // 시퀀스이용해서 자동 순번으로 넣을경우
            pstmt.setString(1, "이상용");
            pstmt.setString(2, "1234");
            pstmt.setString(3, "lsy@naver.com");
            pstmt.setString(4, DateUtil.getCurrentDateTime());
            System.out.println("5. PreparedStatement 생성 완료");


// 6. SQL문 전송 및 결과값 얻기... 
    // 1)조회버전 : executeQuery
    // 2)쓰기,수정,삭제 : executeUpdate()
        // 조회버전 예시) ResultSet rs = pstmt.executeQuery(query)
            // ResultSet : 가상의 테이블임. 데이터베이스에서 조회된 데이터 테이블 형식으로 메모리상에 저장.
            //  ㄴ 특이점 : 0행부터 시작함.
            // 예) while(rs.next()) {    0행 시작 -> 1행의 데이터가 존재하면, 그걸 가져올 작업한다.
            //      int id = rs.getInt("id")
            //      String name = rs.getString("name");
            //  }
        // 쓰기버전 예시) int result = pstmt.executeUpdate(query)
        int result = pstmt.executeUpdate();
        System.out.println("6. 전송 전 완료");
            // 오류 업데이트 시에, 메서도 호출 방법이 다름.
            // int result = pstmt.executeUpdate(query);
            System.out.println("6-2. 전송 후 완료");
                System.out.println(result + "개 의 데이터가 저장됨.");

        
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
// 7. 자원반납
    // 객체를 생성한 역순으로 반납.
    // 1) Connection, 2) PreparedStatement, 3) ResultSet 순서로 객체를 만들었음.
    // 해당 객체의 자원 반납? 객체.close()
        // try ~ resource 구문으로, 자동으로 autocloseable 이용하는방법,
        try {
            // 조회 할 때만 필요
                // if (rs != null)
                // rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();

         } catch (Exception e) {
           
         }
        }

    }
}
