package d250609.ch4;

public class Member_Main {
    public static void main(String[] args) {
        Member member = new Member("추교문", "coko9437", "1357");

        member.showInfo();
        System.out.println("==================================================");

        System.out.println("Getter 사용한 조회 >>");
            System.out.println("이름 >>> " + member.getName());
            System.out.println("이메일 >>> " + member.getEmail());
            System.out.println("패스워드 >>> " + member.getPassword());
        System.out.println("==================================================");

            System.out.println("Setter 사용한 수정 >>");

        member.changeNameEmailPassword("이상용", "lsy@naver.com", "12345");
        member.showInfo();
    // ============================================================

    // 인스턴스 3개 생성하기
    Member member1 = new Member("테스트1", "naver.com", "1234");
    Member member2 = new Member("테스트2", "daum.net", "5678");
    Member member3 = new Member("테스트3", "gmail.com", "9012");

    // 방금 만든 인스턴스를 배열로
        // Member[] memberArray = new Member[3];
    Member[] memberArray = { member1, member2, member3 };

    // 반복문으로 담기
        // for (int i = 0; i < memberArray.length; i++) {
        // memberArray[i] = MemberTempArray[i];
        // }

    System.out.println("===============인스턴스 기본 생성 후 , 확인 해보기 ============================");
    // 각 인스턴스를 , 반복문 이용해서 출력 해보기.
    for (Member member4 : memberArray) {
        member4.showInfo();
    }
    System.out.println("===============수정 후  , 확인 해보기 ============================");
    // 각 인스턴스 멤버의 변수를 한번에 3개 다 변경하는 메서드 이용해서 수정하고,
        // 다시 출력 해보기.
    member1.changeNameEmailPassword("가나다", "yahoo.co.kr", "123");
    member2.changeNameEmailPassword("라마바", "네이버", "321");
    member3.changeNameEmailPassword("사아자", "어드민", "5565");
    
}
}
