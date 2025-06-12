package d250612.ch9_2;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class _3Container_Layout_Ex3 {
    public static void main(String[] args) {
        // GridLayout 예시
        JFrame frame = new JFrame("GridLayout 예시");
        JPanel panel = new JPanel();
        // 패널에 배치관리자, GridLayout 설정.
        panel.setLayout(new GridLayout(2,2));
        
        // 동, 서, 남, 북, 중앙
        panel.add(new JButton("샘플 1"));
        panel.add(new JButton("샘플 2"));
        panel.add(new JButton("샘플 3"));
        panel.add(new JButton("샘플 4"));
        
        
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 나가겠다.
        frame.setVisible(true);

    }
}
