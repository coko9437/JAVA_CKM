package d250610.ch5;

public class ShapeEx1 {
    // 설계 클래스인데, 내가 만든 기능인 draw() 사용안하고 자식클래스에서 메소드를 다르게 재정의해서
    // 그럼 여기 draw()기능은 필요가 없을까?
    
    // 설계시 주의점...
    // 1) 내가 만든 기능은 이름만 정의를 하고, 기능을 구현을 안해야지 왜? 어차피 내꺼 안쓰고
        // 알아서 각자 재정의해서 사용하니까
    // 2) 갑자기 자식클래스에서 필수적으로 재정의해야할 기능을 사용을 누락하는 경우가 있음.
        // 그래서 필수 기능은 강제적으로 반드시 구현을 하게끔... 경고 띄우기
    // 3) 공통기능. 부모클래스에 정의하고 재사용하는데 단점은 상속은 하나만 가능함.
        // 그럼 다양한 기능을 추가하고싶을때 하나의 클래스에서 파일의 내용이 길어짐.

    private String kind;
    private String name;

    public void draw() {
        System.out.println("도형 그리기 기능");
    }
    // 생성자 만들지 여부
    public ShapeEx1() {
    }
    // 오버로딩? 짐을 더 추가해줌 
    // --> 생성자의 모양은 똑같지만 매개변수의 모양,갯수가 다른모양
    public ShapeEx1(String kind, String name) {
        this.kind = kind;
        this.name = name;
    }
    // 게터/세터 여부  
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //  showInfo() 여부

    public void showInfo() {
        System.out.println("종류 : " + kind);
        System.out.println("이름 : " + name);
    }
    
    // 실무에서 ==>> 세터 보다는 변경하는 메소드를 만들어서 수정하고,
    // 직접 수정을 안함 (불변성을 유지하기 위해서)
    
}
