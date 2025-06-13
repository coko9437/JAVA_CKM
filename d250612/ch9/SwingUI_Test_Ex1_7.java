package d250612.ch9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SwingUI_Test_Ex1_7 {
    public static void main(String[] args) {
        // JTextArea : 여러줄 입력을 받을수 있는 창 이용
        // 저장버튼 클릭시 콘솔에 출력하는 기능 만들기.

        JFrame frame = new JFrame("메모 입력시 콘솔에 출력");
        // 여러줄 입력 가능한 UI : JTextArea 사용
        JTextArea textArea = new JTextArea(10,30);
                                        // 10줄, 30 가로크기
        JButton saveButton = new JButton("저장하기");
        
        
        // 버튼 이벤트 처리
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(textArea.getText());
            }
        // ㄴ => 람다식클래스로는 : 
            // saveButton.addActionListener(e -> System.out.println(textArea.getText()));
        });

    JPanel panel = new JPanel();
    // 패널에 텍스트 영역 추가시, 범위를 넘어가면 스크롤이 생기는 기능
    panel.add(new JScrollPane(textArea)); 
    panel.add(saveButton);
    
    frame.add(panel);
    frame.setSize(300,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
    frame.setVisible(true);
    
    }
}
