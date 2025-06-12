package d250612.ch9_2;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class _4Container_Layout_Ex4 {
    public static void main(String[] args) {
        // BorderLayout 이용해서..
        //  북쪽:제목 // 중앙:JTextArea(5,20) // 남쪽: 저장버튼배치

        JFrame frame = new JFrame("BorderLayout 예시2");

        // 프레임에 배치관리자, BorderLayout 설정.
        frame.setLayout(new BorderLayout());
        
        // 동, 서, 남, 북, 중앙
        // frame.add(new JButton("샘플 버튼 동쪽"), BorderLayout.EAST);
        // frame.add(new JButton("샘플 버튼 서쪽"), BorderLayout.WEST);
        frame.add(new JLabel("제목 : ",SwingConstants.CENTER), BorderLayout.NORTH);
        frame.add(new JTextArea(5,20), BorderLayout.CENTER);
        frame.add(new JButton("저장하기"), BorderLayout.SOUTH);
        

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 나가겠다.
        frame.setVisible(true);
    }
}
