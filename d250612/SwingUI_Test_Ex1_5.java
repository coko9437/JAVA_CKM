package d250612;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*; // 수동으로 임폴트 (addActionListener)

public class SwingUI_Test_Ex1_5 {
    public static void main(String[] args) {
        // 윈도우창에 닫기말고 프레임안에 닫기 버튼 추가해서 클릭시 닫아보기(이벤트).
        JFrame frame = new JFrame("닫기버튼 이벤트 추가 ");
        
        JButton button = new JButton("종료버튼");

        // 이벤트 리스너 작업
            // 방법1) 내부 클래스 작업
            // 방법2) 익명 클래스 작업
            // 방법3) 람다식(화살표 함수) 작업
        
        // 버튼에 종료버튼 이벤트 작업
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 창을 종료하고 메모리에서 자원 반납
                frame.dispose(); // 현재 창만 닫을때
            }       // JFrame.EXIT_ON_CLOSE : 프로그램 자체종료.
            // 방법2 익명클래스 작업으로 실행
        });

        frame.add(button);
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);
    }
}
