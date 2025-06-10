package d250610.ch5;

public class ShapeMainEx1 {
    public static void main(String[] args) {
        // 기본 인스턴스 생성
        // 다향성 이용해서 부모타입으로 받게
        CircleEx1 circleEx1 = new CircleEx1();
        circleEx1.draw();
        RectangleEx1 rectangleEx1 = new RectangleEx1();
        rectangleEx1.draw();
        System.out.println("===================================");
        // 부모 클래스에도 메소드draw()가 있고,
        // 자식 크래스에도 메소드draw()가 있음.
        // 현재 circleEx1 타입이 본인타입(CircleEx1)
        // draw() 사용시...누구꺼 사용했나? 부모/자식중 ==> 자식꺼.

        // 다향성 이용
        // --> [부모타입] [인스턴스 변수명] = new [자식클래스명()];
        // [인스턴스 변수명]의 타입? --> 부모타입.

        // [인스턴스 변수명]으로 메소드 draw()사용시 누구꺼 사용하나요?
            // 정답은 자식 꺼 draw() 사용.
        
        // 가상메소드? 부모 자식에 같은 메소드가 있다면 
            // 자식의 메소드를 이용하는것.
        ShapeEx1 shapeEx1 = new CircleEx1(); //자식타입-->> 부모타입으로 형변환 "업 캐스팅"
        
        ShapeEx1 shapeEx2 = new RectangleEx1();
        shapeEx1.draw();
        shapeEx2.draw();

    }
}
