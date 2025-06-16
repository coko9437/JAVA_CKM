package d250613.web_structure.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class _3MainFrame extends JFrame{
    // 설계클래스
    // 실제 화면을 그리는 작업 -> 기본생성자 에서 작업함.

    public _3MainFrame() {
        setTitle("_3메인화면 Frame");
        setSize(400,200);
        setLocationRelativeTo(null); // 화면에 중앙 배치.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    

    // 회원가입 버튼 생성.
    JButton signUpBtn = new JButton("회원가입");

    // 버튼에 이벤트작업...클릭시 회원가입 화면으로 이동
    signUpBtn.addActionListener(e -> {
        new _4SignupFrame(); // 회원가입 화면으로 이동 -> 그 클래스의 생성자를 호출하는 형식.

        // new _4copy();

        dispose(); //현재창 닫기.
    });

    // 프레임 <- 패널 <- 버튼(signUpBtn)
    JPanel panel = new JPanel();
    panel.add(signUpBtn);
    add(panel,BorderLayout.CENTER); //프레임에 가운데로 패널 추가
    setVisible(true); // Frame.setVisible

    }
}
