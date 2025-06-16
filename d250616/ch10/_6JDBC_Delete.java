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
                // _4DBConnectionManager의 getConnection()이라는 유틸 메서드를 통해 데이터베이스 연결을 가져온 것입니다.
            String query = "DELETE FROM MEMBER501 WHERE ID = ?";
                // 특정 조건(id)가 일치할 경우 해당 데이터를 삭제하게 됩니다.
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            int result = pstmt.executeUpdate();
            System.out.println(result + " 개의 데이터가 삭제됨");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
    }
}
