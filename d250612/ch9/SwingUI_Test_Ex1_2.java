package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingUI_Test_Ex1_2 {
    public static void main(String[] args) {
        // JFrame 틀 안에 버튼 추가해보기.
        JFrame frame = new JFrame("버튼 추가");
        
        // 버튼 만드려면 버튼객체가 필요함.
        JButton button = new JButton("클릭");

        // 버튼을 프레임에 붙이기
        frame.add(button);

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);
    }
}
