package d250611.ch8_3;

import java.io.File;

// File 클래스 이용해서
    // 파일 및 디렉토리 정보처리 방법.
// 생성, 확인, 읽기, 삭제 등
// File file = new File("testFile.txt"); 생성할 파일명 작성. 
//
// 자주 사용하는 옵션 
// exist() :  존재 여부, 
// isFile() : 파일 인지 판별 
// isDirectory() : 폴더 인지 판별 
// length() : 파일 크기 
// delete() : 파일 삭제 
// createNewFile() : 파일 생성 
// mkdir(), : 폴더 생성. 
// list(), : 목록 조회 

public class FileTest_Ex1 {
    public static void main(String[] args) {
        // 1) data.txt가 존재여부 확인
        File file = new File("data.txt");
            System.out.println("파일이 존재하나요? >> " +file.exists());
        
    }
}
