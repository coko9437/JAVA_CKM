package d250609.ch5_2;

public class Cat_Main_Ex1 {
    public static void main(String[] args) {
        Cat_Ex1 cat_Ex1 = new Cat_Ex1(); //생성자를 호출했다. 초기화했다. 클래스를 가져왔다.
        cat_Ex1.favoriteFood = "소세지";
        cat_Ex1.showInfo();
                System.err.println("=========================================");
        // 2번째 인스턴스 생성.
        Cat_Ex1 cat_Ex2 = new Cat_Ex1("야옹님", "생선");
        cat_Ex2.showInfo();
        // 결론 : 접근지정자 protected는 상속받은 자식클래스 또는 같은 패키지,폴더 내에서만 사용가능.
        // cat_Ex2.name = "이름 수정, 다른 외부 클래스에서 접근 시도";
        
    }
}
