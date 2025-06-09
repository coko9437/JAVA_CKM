package d250609.ch4;

public class FinalEx5Main {
    public static void main(String[] args) {
        FinalEx5 finalEx5 = new FinalEx5();
        finalEx5.circleMethod(10);
            // final로 정의한 공유상수 변경 시도해보기. (PI = 3.14159)
        // FinalEx5.Pi = 3.14; 당연히 변경 불가함

    }
}
