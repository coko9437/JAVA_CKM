package d250612.ch9_2;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// BorderLayout 이용 그리드
// 북쪽 : 회원가입 JLabel 이용
// 중앙 : 2x2 GridLayout JLabel("아이디")

public class _6Container_Layout_Ex6 {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("회원가입 간단 예시");
        // 프레임에 배치관리자, BorderLayout 설정.

        frame.setLayout(new BorderLayout());

        // 프레임 <- 회원가입 라벨 붙이기 (북쪽)
        frame.add(new JLabel("회원가입", SwingConstants.CENTER),
            BorderLayout.NORTH);              // 가운데정렬

        JPanel centerpanel = new JPanel(new GridLayout(3,3)); 

        centerpanel.add(new JLabel("이름"));
        centerpanel.add(new JTextField(20));
        centerpanel.add(new JLabel("이메일"));
        centerpanel.add(new JTextField(20));
        centerpanel.add(new JLabel("패스워드"));
        centerpanel.add(new JTextField(20));

        // 프레임 <- 패널붙이기 작업(중앙)
        frame.add(centerpanel,BorderLayout.CENTER);
        // 프레임 <- 버튼붙이기 (남쪽)
        frame.add(new JButton("가입"),BorderLayout.SOUTH);
        

        

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 나가겠다.
        frame.setVisible(true);
    
    }
}
