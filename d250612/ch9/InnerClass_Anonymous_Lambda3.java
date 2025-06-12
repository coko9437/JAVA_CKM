package d250612.ch9;
// 람다식 //
// 자바8버젼 이후 등장함.
// 함수형 인터페이스(메서드가 1개인 경우에만) 람다식으로 구현가능. (= 화살표 함수)

import javax.swing.JButton;
import javax.swing.JFrame;

// 버튼.addActionListener (1)내부클래스, (2)익명클래스, (3)화살표함수
// 버튼.addActionListener( e -> {이벤트 처리구조})
public class InnerClass_Anonymous_Lambda3 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("람다식 표현... 이벤트 처리");
        JButton button = new JButton("닫기");

        // 이벤트 작업... 버튼에 기능 넣기
        button.addActionListener(e -> frame.dispose());

        frame.add(button);

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 나가겠다.
        frame.setVisible(true);
    }
}
