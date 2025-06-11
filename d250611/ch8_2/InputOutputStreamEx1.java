package d250611.ch8_2;

public class InputOutputStreamEx1 {
    // 입,출력에 대한 개념임.
    // Stream : 데이터를 일렬로 흘려보내는 통로 같은것임.
    // 입력 : 외부에서 -> 작업중인 프로그램으로 (예시: 파일읽기, 키보드입력 등)
    // 출력 : 프로그램 -> 외부 (예시: 파일쓰기, 화면 출력)

    // Byte 단위로 I/O : InputStream/OutputStream
    // 문자열 단위로 I/O : Reader/Writer
    // 주의사항 //
    // 1) 파일 입,출력시 의무적으로 예외처리를 해야함 (try ~ cath ~ finally)

    public static void main(String[] args) {
        // 키보드에서 한 글자만 입력받아 정수로 출력
        try {
            int data = System.in.read();
                System.out.println(data);
        } catch (Exception e) {
            // 오류가 발견되는 과정을 추적해서 밝혀줌.
            e.printStackTrace();
        }
    }
}
