package d250611.ch8_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;


// 버퍼링 ... 입출력 성능 향상을 위해 버퍼(메모리 임시저장소 [배열])활용해 성능 향상시키기
// ㄴ 데이터를 모아 한번에 처리 => 속도향상
    // 기존에는 한번읽고 -> 한번쓰기
// BufferedReader br = new BufferedReader(new FileReader("a.txt")) 읽기도구
// BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt")) 쓰기도구

// readLine() : 한줄 단위로 읽기
// write(String) : 한줄 단위로 쓰기
// flush() : 버퍼 내용을 강제저장
// close() : 자원반납

public class InputOutputStreamEx6 {
    public static void main(String[] args) {
        try {
            // 원본 이미지를 Byte로 읽기 도구
            FileInputStream fis4 = new FileInputStream("test7.jpg");

            // 원본 이미지를 Byte로 쓰기 도구
            FileOutputStream fos2 = new FileOutputStream("Copytest7_1.jpg");

            // 임시로 담을 공간 만들기(메모리 = 버퍼 = 배열)
            byte[] buffer = new byte[1024]; // 1KB

            int data; // 읽어서 임시로 담아둘 변수 선언

            // 기존에 1Byte 읽고쓰기... -->> 현재) 지정한 버퍼의 크기만큼 읽기/쓰기
                while ((data = fis4.read(buffer)) != -1) { //마지막 픽셀까지 읽겠다 는 의미.
                    // 기존에 1Byte쓰기
                        // 쓰기작업 : 지정한 크기만큼씩 쓰기
                        System.out.println("data 값 : " +data);
                    fos2.write(buffer, 0, data);
                }
            System.out.println("이미지파일 복사 완료");
            fis4.close();
            fos2.close();
        } catch (Exception e) {
            
        }        
    }
}
