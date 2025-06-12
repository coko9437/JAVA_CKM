package d250612;

import javax.swing.JFrame;

// 자바 버전으로 GUI(Graphical User Interface)
// HTML(웹) 화면 구성처럼 자바, 데스크톱 버전 화면구성
// 실제로 실무에서 많이 Swing UI 도구를 많이 사용함
// javax.swing 패키지(모음집)
// 기본이 되는 클래스 : JFrame, JPanel, JButton, ~~ 시리즈 형식으로 화면 구성

// JFrame : 프로그램의 기본 윈도우창
// 메서드 //
// 1) setTitle(String title) : 창의 제목설정
// 2) setSize(int width, int height) : 창의 크기설정
// 3) setDafaultCloseOperation(int op) : 창을 닫을때 동작 설정
// 4) setVisible(boolean b) : 창 보이기/숨기기

// JButton : 버튼
// 1) setText(String text) : 버튼에 표시되는 텍스트 설정 

// JLabel : 텍스트나 이미지를 표시하는 컴포넌트

public class SwingUI_Test_Ex1 {
    public static void main(String[] args) {
        // 기본 윈도우 창 생성
        JFrame frame = new JFrame("Hello GUI 창");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);

    }    
}
