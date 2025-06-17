package d250616.ch10;

import java.sql.Connection;
import java.sql.PreparedStatement;

import d250616.util._4DBConnectionManager;

public class _6JDBC_Delete {
    public static void main(String[] args) {
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            conn = _4DBConnectionManager.getConnection();
                // _4DBCon클래스의 getConnection()이라는 유틸 메서드를 통해 데이터베이스 연결을 가져옴
            String query = "DELETE FROM MEMBER501 WHERE ID = ?";
                // 특정 조건(id)가 일치할 경우 해당 데이터를 삭제하게 됩니다.
            pstmt = conn.prepareStatement(query); //PreparedStatement는 쿼리의 ?에 값을 넣고 한 후 실행할 수 있도록
            pstmt.setInt(1, 1); // query의 ? 값에 해당하는 숫자.
            int result = pstmt.executeUpdate(); //executeUpdate()는 변경된 row 개수를 반환
                 // 삭제됬다면 result는 1, 일치하는row가 없으면 0
            System.out.println(result + " 개의 데이터가 삭제됨");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
    }
}
