package ch2;

import java.util.Scanner;

// import java.util.Scanner;

import util.UserService;

public class ScannerTest2 {
    public static void main(String[] args) {
        // 여기에 있던 회원가입 내용을 다른 클래스로 이동 후(UserService),
            // 단순 클래스의 메소드만 호출하는 형태로 변경함.
            // 클래스명.메소드(); 형태로 호출.
        
        // 공용으로 사용을 할 스캐너를 정의.
        Scanner scanner = new Scanner(System.in);


        UserService.registerUser(scanner);
        
        UserService.loginUser(scanner);

        scanner.close();


    }
}
