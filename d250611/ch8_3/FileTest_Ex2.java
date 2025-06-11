package d250611.ch8_3;

import java.io.File;

public class FileTest_Ex2 {
    public static void main(String[] args) {
        // 2) 폴더 생성 "backup"폴더 만들기
        // File dir = new File("backup");
        // dir.mkdir();
        // System.out.println("폴더생성 >> "+ dir.mkdir());

        // 3) 파일의 용량(크기)확인 -->> text.txt
        // File file = new File("test.txt");
        //        System.out.println("파일 용량 확인 >> " +file.length()); // Byte용량으로 나옴.
        
        // 4) 현재 폴더의 모든 파일/폴더 이름 출력하기
        // File file = new File("."); // 깃허브 연동할때 git add . 에서 이 (.)
        //     String[] names = file.list(); // 문자열 타입 배열(names)에 담기.
        //     for(String string : names) { // names -> string에 넣기.
        //         System.out.println("파일/폴더명 조회 >> "+ string);
        //     }
        
        // 5) 특정 폴더가 없으면 새로만들기
            // File dir = new File("mydir");
            //     if (!dir.exists()) {
            //         dir.mkdir();
            //     }
        
        // 6) 특정 폴더/파일 삭제하기
                // File file = new File("copyTest7_1.jpg");
                // if (file.isFile()) {
                //     file.delete();
                // }

        // 7) 해당 파일이 있으면 삭제, 없으면 생성하기
            // File file = new File("input.txt");
            // try {
            //     if(file.exists()) {
            //         file.delete();
            //     } else {
            //         file.createNewFile();
            //     }
            // } catch (Exception e) {
            //     e.printStackTrace();
            // }
    }
}
