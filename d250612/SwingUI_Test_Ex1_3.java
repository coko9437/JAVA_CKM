package d250612;

import javax.swing.JLabel;
import javax.swing.JFrame;

public class SwingUI_Test_Ex1_3 {
    public static void main(String[] args) {
        // 프레임에 라벨 붙이기
        JFrame frame = new JFrame("프레임에 라벨 붙이기");
        
        // 라벨 객체 생성
        JLabel jLabel = new JLabel("스윙에 JLabel");

        frame.add(jLabel);
        
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);
    }
}
