package d250611.ch8_2;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InputOutputStreamEx4 {
    public static void main(String[] args) {
        // 한글이 깨지지 않도록 UTF-8 사용해서 출력하기.
            // Unicode Transformation Format 8bit (1bit = 8byte)
            // 1~4 byte로 하나의 문자를 표현
            // ASCII 와 호환 : (U+0000 ~ U+007F)
        // 전
        // try (FileInputStream fis2 = new FileInputStream("test.txt")) {
        
        //후 [클래스] [인스턴스] = new [클래스] (매개변수1, 매개변수2) 구조임.
        try (InputStreamReader reader = new InputStreamReader
            (new FileInputStream("test.txt"), StandardCharsets.UTF_8)) {
                    // 매개변수 1 : 읽은 데이터(바이트단위), 매개변수 2 : 변환할 데이터 인코딩 타입
            int data;
                // while ((data = fis2.read()) != -1) {
                while ((data = reader.read()) != -1) {
                    System.out.print((char)data);
                }
        } catch (Exception e) {
            
        }
        
    }
}
