package d250616.ch10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// 자바, 오라클디비 서버 연결설정 확인테스트

// 준비물
// 1) 오라클 연결드라이버 (lib -> ojdbc8_g.jar)
// 2) vscode특성상 해당 라이브러리 경로지정 (.vscode -> settings.json)
// 3) 드라이버 연결테스트
// 4) 오라클디비 서버의 기본정보 및 서버켜기
    //   scott / tiger
    //  주소 : localhost, port : 1521
    //  서비스 : XE
public class _1JDBC_Connection_Test1 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; // 디비 서버 아이피, 포트, 서비스 이름
        String user = "scott";  //접속할 유저
        String password = "tiger";  //패스워드

        // 디비 서버에 네트워크 연결요청, try_catch , try_resource 이용하기

        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select sysdate from dual")) {
            if (rs.next()) {
                System.out.println("현재 시간 : " + rs.getTimestamp(1));
            }

        } catch (Exception e) {
            
        }

    }
}
