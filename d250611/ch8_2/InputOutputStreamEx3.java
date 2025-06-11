package d250611.ch8_2;

import java.io.FileInputStream;

public class InputOutputStreamEx3 {
    public static void main(String[] args) {
        // 파일에서 읽어오는 기능 (한 Byte씩 읽어서) 화면에 출력하기.
        // try_resource 구문 : 문장안에 알아서 fis 자동으로 닫는 코드가 탑재됨
            // 즉 fis.close(); 사용할 필요 XxX
        try (FileInputStream fis = new FileInputStream("test.txt")) {
            // fis <-- 해당 파일(test.txt)을 메모리 상으로 읽은 상태가 들어가있음.
            int data; // 한 Byte씩 읽어서 임시로 닫을 변수 (유니코드값으로 a : 97, b : 98)
                while ((data = fis.read()) != -1) {
                    System.out.println((char)data); // 여기서 97 -> 'a'로 반환
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
