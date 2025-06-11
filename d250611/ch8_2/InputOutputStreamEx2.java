package d250611.ch8_2;

import java.io.FileOutputStream;

public class InputOutputStreamEx2 {
    // test.txt 파일에 hello 문자열을 저장하는 코드 작성.
    public static void main(String[] args) {
        try {
            // test.txt 파일에 데이터를 출력하는 도구(기능) 만들기.
            FileOutputStream fos = new FileOutputStream("test.txt");
            
            // 파일안에 작성할 내용을 추가하는 기능
            // 문자열 -> Byte 단위로 변환하는 작업.
            fos.write("hello! 안녕".getBytes());
                // 파일 입출력, 네트워크통신, DB연결 등 할때... 
                // 반드시 자원 반납해야함. scanner.close();와 같은기능
            fos.close();
        } catch (Exception e) {
            // 오류가 발견되는 과정을 추적해서 밝혀줌.
            e.printStackTrace();
        }
    }
}
