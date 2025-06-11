package d250611.ch8_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputOutputStreamEx5 {
    // Byte 단위를 이용, 이미지 읽기/쓰기 작업
    public static void main(String[] args) {
        try {
            // 원본사진 읽는 도구
            FileInputStream fis3 = new FileInputStream("test7.jpg");
            // 해당 사진을 출력할 도구
            FileOutputStream fos = new FileOutputStream("copyTest7.jpg");
            // 한 Byte를 읽어서 담아 둘 임시 변수
            int data;
                while ((data = fis3.read()) != -1) { // 이미지의 마지막 픽셀까지 읽겠다 는 의미.
                fos.write(data);    
                }
                fis3.close();
                fos.close();
        } catch (Exception e) {

        }
    }
}
