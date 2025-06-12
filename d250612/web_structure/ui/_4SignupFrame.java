package d250612.web_structure.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class _4SignupFrame extends JFrame{
    public _4SignupFrame() { 
        setTitle("_4회원가입 Frame");   
        setSize(400,200);    
        setLocationRelativeTo(null); // 화면 중앙에 배치
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 안내문구 표시
        JLabel label = new JLabel("회원가입 화면을 보고있습니다.");
        add(label);
        setVisible(true);

    }
}
