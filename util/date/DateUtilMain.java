package util.date;

public class DateUtilMain {
    public static void main(String[] args) {
        System.out.println("현재시간을 불러오는 기능 확인.");

        String currentTime = DateUtil.getCurrentDateTime();
        
        System.err.println("현재시간 : "+ currentTime);

    }
    // 퀴즈) user_mini_project 폴더에 -> MainClass.java 파일에
    // 회원 가입 항목에 현재 가입시간 추가, 출력

}
