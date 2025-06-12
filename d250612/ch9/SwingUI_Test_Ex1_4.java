package d250612.ch9;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingUI_Test_Ex1_4 {
    public static void main(String[] args) {
        // 프레임에 버튼, 라벨 동시에 넣어보기
        JFrame frame = new JFrame("버튼/라벨 같이 넣기");

        // 윈도우창에 하나의 도화지(panel) 화면을 추가로 붙이기.
        JPanel panel = new JPanel();

        // 도화지에 버튼, 라벨 추가 => 도화지에 프레임 붙이기작업.
        // --> 버튼, 라벨 객체 만들기
        JButton button = new JButton("버튼1");
        JLabel label = new JLabel("라벨1");

        // 패널에 버튼,라벨 붙이기작업
        panel.add(button);
        panel.add(label);

        // 프레임에 패널 붙이기
        frame.add(panel);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);

    }
}
