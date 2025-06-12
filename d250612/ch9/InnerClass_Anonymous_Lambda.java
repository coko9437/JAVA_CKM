package d250612.ch9;

// 내부클래스 //
//  ㄴ 클래스 안에 또 다른 클래스를 정의하고 사용함
    // 버튼, 이벤트 소스가 여러 곳에서 동일한 리스너를 공유
    // 복잡한 로직을 분리할 때 사용.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerClass_Anonymous_Lambda {    // 클래스
    JFrame frame = new JFrame("내부클래스 예시");
    JButton button = new JButton("닫기");

    // 생성자
    public InnerClass_Anonymous_Lambda() {          // 내부클래스
        // 버튼에 이벤트리스너 붙이기
        button.addActionListener(new SampleListener());
        // 화면에 버튼 붙이기 작업.
        frame.add(button);

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);
    }

        // 내부에 또 다른 클래스 정의
        class SampleListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 이벤트 기능) 닫기기능
                frame.dispose();
            }
        
        }

        public static void main(String[] args) {
            new InnerClass_Anonymous_Lambda();
        }
}
