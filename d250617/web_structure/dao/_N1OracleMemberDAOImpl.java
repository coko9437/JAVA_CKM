package d250617.web_structure.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import d250617.web_structure.ui._4SignupFrame;
import d250617.web_structure.dto._10Member;
import d250617.web_structure.util._4DBConnectionManager;
import d250617.web_structure.util.DateUtil;


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
    public _10Member findById(int member_id) { 
        // 넘어온 회원의 ID를 이용해 회원1명을 조회하는 작업.
        _10Member member = new _10Member(); // 디비에서 조회한 1명의 회원 정보를 담을 객체
        try { 
            conn = _4DBConnectionManager.getConnection();
                // _4DBConnectionManager의 getConnection()이라는 유틸 메서드를 통해 데이터베이스 연결을 가져온 것입니다.
            String query = "SELECT * FROM MEMBER501 WHERE ID = ?";
        pstmt = conn.prepareStatement(query);
// 변경 전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // pstmt.setInt(1, 2);
// 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        pstmt.setInt(1, member_id);
            
        rs = pstmt.executeQuery(); // 오류1 메서드에 쿼리를 넣은 부분
                // executeQuery()는 인자가 없는 형태를 권장
                
         while(rs.next()) { //한 줄 한 줄 접근
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");     
                // member = new _10Member(id, name, email, password2, reg_date);
                member.setId(member_id);
                member.setName(name);
                member.setEmail(email);
                member.setPassword(password2);
                member.setReg_date(reg_date);
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return member;
    }







    @Override
    public boolean insert(_10Member member) { // member : 화면으로 부터 입력 받은 회원 정보
        
        try { 
            conn = _4DBConnectionManager.getConnection();
                // _4DBConnectionManager의 getConnection()이라는 유틸 메서드를 통해 데이터베이스 연결을 가져온 것입니다.
            String query = "INSERT INTO MEMBER501 (ID,NAME,PASSWORD,EMAIL,REG_DATE)" +
                    "VALUES(MEMBER501_SEQ.NEXTVAL,?,?,?,?)";
            pstmt = conn.prepareStatement(query); //prepareStatement() : 쿼리 준비
           
                    // pstmt.setString(1, "이상용");
                    // pstmt.setString(2, "1234");
                    // pstmt.setString(3, "lsy@naver.com");
                    // pstmt.setString(4, DateUtil.getCurrentDateTime());
                    // System.out.println("5. PreparedStatement 생성 완료");
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, DateUtil.getCurrentDateTime());
            // System.out.println("5. PreparedStatement 생성 완료");

            int result = pstmt.executeUpdate(); // 실제로 디비에 쓰기 작업 진행.
            System.out.println(result + " 개의 데이터가 저장됨");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return true;
    }


        // 내가작성
    //     try {
    //         conn = _4DBConnectionManager.getConnection();
    //         String query = "INSERT INTO MEMBER501 (ID, NAME, PASSWORD, EMAIL, REG_DATE)" +
    //             "VALUES(MEMBER501_SEQ.NEXTVAL, ?, ?, ?, ?)";
    //             pstmt = conn.prepareStatement(query);
                
    //             pstmt.setString(1, member.getName());
    //             pstmt.setString(2, member.getPassword());
    //             pstmt.setString(3, member.getEmail());
    //             pstmt.setString(4, DateUtil.getCurrentDateTime());
    //         int result = pstmt.executeUpdate();
    //         return true;
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     } finally {
    //         _4DBConnectionManager.close(null, pstmt, conn);
    //     }
    //     //  return memberList;
    //     return false;
    // }
        //

    @Override
    public boolean update(_10Member member) {
        try {
            // 회원수정 디버깅3
            System.out.println("파일명 : _N1Oracle ");
            System.out.println("넘어온 데이터 확인 ");
            System.out.println(member);
            conn = _4DBConnectionManager.getConnection();
                // _4DBConnectionManager의 getConnection()이라는 유틸 메서드를 통해 데이터베이스 연결을 가져온 것입니다.
            String query = "UPDATE MEMBER501 SET NAME = ?, EMAIL = ?, " +
                    "PASSWORD = ?, REG_DATE = ? WHERE ID = ?";

            
            pstmt = conn.prepareStatement(query);
// 변경 전ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ            
            // 수정 할 내용
            // pstmt.setString(1, "이상용 수정");
            // pstmt.setString(2, "1234 수정");
            // pstmt.setString(3, "lsy@naver.com 수정");
            // pstmt.setString(4, DateUtil.getCurrentDateTime());
            // pstmt.setInt(5, 1);
            
// 변경 후ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, DateUtil.getCurrentDateTime());
            // 주의사항) 멤버의 INDEX를 받아오기 1번이 아니고 member에서 id가져와서
            // pstmt.setInt(5, 1);
            pstmt.setInt(5, member.getId());

            // 쓰기 버전,
            // int result = pstmt.executeUpdate()
            System.out.println("6. 전송 전 완료");
            // 오류 업데이트 시에, 메서도 호출 방법이 다름.
            // int result = pstmt.executeUpdate(query);
            int result = pstmt.executeUpdate();
            System.out.println("6-2. 전송 후 완료");
            System.out.println(result + " 개의 데이터가 수정됨.");

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            // 자원 반납.
            
            // 변경전,
            // try {
            // // 조회 할 때만 필요
            // // if (rs != null)
            // // rs.close();
            // if (pstmt != null)
            // pstmt.close();
            // if (conn != null)
            // conn.close();
            // } catch (Exception e) {
            // // TODO: handle exception
            // }

            // 변경후,
            _4DBConnectionManager.close(null, pstmt, conn);
        }
        return true;
    }

    @Override
    public boolean delete(int member_id) {
                
        try {
            conn = _4DBConnectionManager.getConnection();
                // _4DBCon클래스의 getConnection()이라는 유틸 메서드를 통해 데이터베이스 연결을 가져옴
            String query = "DELETE FROM MEMBER501 WHERE ID = ?";
                // 특정 조건(id)가 일치할 경우 해당 데이터를 삭제하게 됩니다.
            pstmt = conn.prepareStatement(query); //PreparedStatement는 쿼리의 ?에 값을 넣고 한 후 실행할 수 있도록
            pstmt.setInt(1, member_id); // query의 ? 값에 해당하는 숫자.
            int result = pstmt.executeUpdate(); //executeUpdate()는 변경된 row 개수를 반환
                 // 삭제됬다면 result는 1, 일치하는row가 없으면 0
            System.out.println(result + " 개의 데이터가 삭제됨");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        } return true;
    }

    @Override
    public List<_10Member> findByName(String searchName) {
        // DB에서 검색된 회원을 -> _10Member 클래스에 담고 -> 리스트(searchMemberList)에 담기
        
        // 검색된 모델 회원들을 담을 임시 리스트 필요.
        List<_10Member> searchMemberList = new ArrayList<>();
        try {
        conn = _4DBConnectionManager.getConnection();

        String query = "SELECT * FROM MEMBER501 WHERE NAME LIKE ?"; //LIKE ?는 조건 값을 나중에 넣겠다는 의미
        pstmt = conn.prepareStatement(query); //query 준비
// 변경 기존은 하드코딩으로 임의로 값을 넣기 -> 동적으로 검색어를 전달 받아서, 키워드로 검색
            // String searchKeyword = "이상용"; 
            String searchKeyword = searchName;
            pstmt.setString(1, "%" + searchKeyword + "%");
            rs = pstmt.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password2 = rs.getString("password");
                String reg_date = rs.getString("reg_date");
                // 1) 멤버에 담기
                _10Member member = new _10Member(id, name, email, password2, reg_date);
                // 2) 리스트(searchMemberList)에 담기
                searchMemberList.add(member);
            } 
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            _4DBConnectionManager.close(null, pstmt, conn);
        } 
        return searchMemberList;
    }   
    
}
