package d250617.web_structure.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 반복되는 코드 
// 1) 연결시 필요한 정보들, 변경이 안되니, 상수로 선언해서, 재사용. 
// 2) 드라이버 로딩 
// 3) 데이터베이스 연결 객체 얻기 
// 4) 자원 해제 

public class _4DBConnectionManager {
    
    // 반복되는 코드
    // 1) 연결시 필요한 정보들, 변경이 안되니, 상수로 선언해서, 재사용.
    private static final String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 디비 서버 아이피, 포트, 서비스 이름
    private static final String user = "scott";  //접속할 유저
    private static final String password = "tiger";  //패스워드
    private static final String driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버 위치

    // 2) 드라이버 로딩
    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 3) 데이터베이스 연결 객체 얻기
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    // getConnection() : 메서드는 데이터베이스 연결을 만들어서 넘김.

    // 4) 자원해제
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
