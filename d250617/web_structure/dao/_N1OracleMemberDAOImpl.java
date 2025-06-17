package d250617.web_structure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import d250617.web_structure.dto._10Member;
import d250617.web_structure.util._4DBConnectionManager;



// 순서1
// 인터페이스를 구현한 구현체클래스, JDBC 연결한 기능들 재정의(DAO)
public class _N1OracleMemberDAOImpl implements _9DAO_Interface {

    // 객체를 미리 선언만 하고, 초기화는 밑에서... (전역에 사용할 수 있게 선언만)
        private Connection conn = null;
        private PreparedStatement pstmt = null;
        private ResultSet rs = null;

    // 순서2 전체 조회기능 만들기
    @Override
    public List<_10Member> findAll() {
        // JDBC의 Select 하는 부분 벤치마킹해서 기능을 만들기
        // JDBC 실행순서 //
// 1. 디비 서버에 접근을 위한 준비물
    // 1)드라이버 위치, 2) 유저명, 3) 패스워드, 4) 디비서버의 아이피 및 포트번호
        // -->> 분리함.
        
        // 임시로 저장할 리스트
        // 디비에서 조회한 한명의 회원 -> 모델 클래스로 -> 멤버를 타입으로 하는 리스트에 담기.
        List<_10Member> memberList = new ArrayList<>();
        try { 
            conn = _4DBConnectionManager.getConnection();
                // _4DBConnectionManager의 getConnection()이라는 유틸 메서드를 통해 데이터베이스 연결을 가져온 것입니다.
            String query = "SELECT * FROM MEMBER501 ORDER BY ID DESC";
                // 특정 조건(id)가 일치할 경우 해당 데이터를 삭제하게 됩니다.
            pstmt = conn.prepareStatement(query); //prepareStatement() : 쿼리 준비
            rs = pstmt.executeQuery(query); // 실제 디비에 연결해서 실행결과(rs)에 받아옴.
                // executeQuery()는 PreparedStatement(pstmt) 에 미리 
                    // 준비되어 있는 쿼리를 실행
                    // 이 결과로 ResultSet(rs)이라는 형태의 데이터를 받음.
                    
                while(rs.next()) {
                    // DB에서 한명의 회원 정보를 가져오기--
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String password2 = rs.getString("password");
                    String reg_date = rs.getString("reg_date");
                    // 멤버의 인스턴스 담기
                    _10Member member = new _10Member(id, name, email, password2, reg_date);
                        // 멤버 -> 리스트 담기
                        memberList.add(member);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return memberList;
    }

    @Override
    public _10Member findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean insert(_10Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public boolean update(_10Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(_10Member member) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public _10Member findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }
    
}
