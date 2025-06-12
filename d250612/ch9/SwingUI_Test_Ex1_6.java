package d250612.ch9;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SwingUI_Test_Ex1_6 {
    public static void main(String[] args) {
        // 이름입력(라벨), + 텍스트필드(JTextField)
        JFrame frame = new JFrame("이름 입력 필드");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("이름 입력 : ");
        JTextField text = new JTextField(10); // 텍스트 필드
                                    // columns : 가로 크기 10(10개의문자크기)
        panel.add(label);
        panel.add(text);

        frame.add(panel);

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);

    }
}
