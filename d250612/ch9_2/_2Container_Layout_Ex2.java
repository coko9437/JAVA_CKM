package d250612.ch9_2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _2Container_Layout_Ex2 {
    public static void main(String[] args) {
        // JPanel에 BorderLayout 설정.
        JFrame frame = new JFrame("BorderLayout 예시");

        // 프레임에 배치관리자, BorderLayout 설정.
        frame.setLayout(new BorderLayout());
        
        // 동, 서, 남, 북, 중앙
        frame.add(new JButton("샘플 버튼 동쪽"), BorderLayout.EAST);
        frame.add(new JButton("샘플 버튼 서쪽"), BorderLayout.WEST);
        frame.add(new JButton("샘플 버튼 중앙"), BorderLayout.CENTER);
        frame.add(new JButton("샘플 버튼 남쪽"), BorderLayout.SOUTH);
        frame.add(new JButton("샘플 버튼 북쪽"), BorderLayout.NORTH);
        

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 나가겠다.
        frame.setVisible(true);
    }

}