package d250610.ch5;

public class CircleEx1 extends ShapeEx1{
    private String edgeCount;

    // 부모의 draw 사용하니 단순 도형그리기
    // 원 모양으로 그리기 기능으로 재정의
    // 오버라이딩
    // 메소드 이름과 반환값은 같지만 구현체 실행기능이 다름.

    @Override
    public void draw() {
        System.out.println("원 모양 그리기 (Circle)");
    }
}
