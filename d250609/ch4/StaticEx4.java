package d250609.ch4;

public class StaticEx4 {
    // static : 클래스 단위로 공유되는 필드 / 메소드 ("공유 자원")

    String name;
    // static 키워드를 사용해서 모든 객체가 공유하는 변수
    static int studentCount = 0;

    // 생성자 호출시 학생의 번호가 증가하도록 만들기
    public StaticEx4(String name) {
        this.name = name;
        // 공유 변수인 학생 수를 카운트하는 변수를 증가.
        studentCount++;
    }

    // 인스턴스 메소드
    // --> 객체(인스턴스) 생성 후 인스턴스명 으로 호출.
    // 예시) A a = new A();
    // a.showInfo();

    public void showInfo() {
        System.out.println("이름 >>> " + name);
    }

    // 스태틱 메소드
    //  클래스명으로 바로 사용이 가능함.
    // 예시) A : 클래스명임.
    // A.showInfo();
    public static void showInfoTotal() {
        System.out.println("총 학생 수 >>> " +studentCount);
    }


    // 주의사항!!!
    // 1) 인스턴스 변수, 스태틱 변수 구분 법 ==> static이 있냐없냐
    // 2) 스태틱 변수에 접근시... 클래스명으로 접근
    // 3) 인스턴스변수 명 으로 접근XXX... why? 메모리 적으로 저장공간의 위치가 다름.
    // A a = new A(); -----> A : 클래스명, a : 변수명
    // a.studentCount -> 접근 안하기.
    // 클래스명.studentCount -> 접근하기.
}
