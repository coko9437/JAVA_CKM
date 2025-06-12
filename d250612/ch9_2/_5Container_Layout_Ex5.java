package d250612.ch9_2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class _5Container_Layout_Ex5 {
    public static void main(String[] args) {
        // 패널 2개생성 , 각자 패널에 배치관리자 
        // GridLayout, BorderLayout

        JFrame frame = new JFrame("복합 패널 레이아웃 적용 예시");

        // 추가작업.. 패널2개 생성 
        JPanel northpanel = new JPanel();
            // 북쪽 패널에 버튼2개 예시추가.
            northpanel.add(new JButton("샘플버튼1 추가"));
            northpanel.add(new JButton("샘플버튼2 추가"));
        
        // 중앙 패널 생성, 버튼2개 예시추가
        JPanel centerpanel = new JPanel(new GridLayout(2,1));
        centerpanel.add(new JButton("샘플버튼3 추가"));
        centerpanel.add(new JButton("샘플버튼4 추가"));


        // 프레임에 배치관리자, BorderLayout 설정.
        frame.setLayout(new BorderLayout());

        // 프레임 <- 패널붙이기 작업
        frame.add(northpanel,BorderLayout.NORTH);
        frame.add(centerpanel,BorderLayout.CENTER);
        
        // 동, 서, 남, 북, 중앙
        // frame.add(new JButton("샘플 버튼 동쪽"), BorderLayout.EAST);
        // frame.add(new JButton("샘플 버튼 서쪽"), BorderLayout.WEST);
        // frame.add(new JLabel("제목 : ",SwingConstants.CENTER), BorderLayout.NORTH);
        // frame.add(new JTextArea(5,20), BorderLayout.CENTER);
        // frame.add(new JButton("저장하기"), BorderLayout.SOUTH);
        

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 나가겠다.
        frame.setVisible(true);
    }
}
