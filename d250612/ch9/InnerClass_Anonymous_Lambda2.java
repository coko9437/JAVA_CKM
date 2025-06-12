package d250612.ch9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

// 익명 클래스 (= 1회용 클래스), 이벤트 처리하는 한번 만 사용하는 구조에서 많이 사용함. //
// 이름 없는 클래스
// 보통 객체를 생성할때는 new 클래스명(),
// 모양 : new 인터페이스명()
// 모양 : new 부모클래스이름()
// -->> 인터페이스명 변수 = new 인터페이스명() {메서드 구현}


// 과정, 
// 원래는 이름이 있는 버전이 
//  class SampleListener implements ActionListener {

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // 이벤트 기능, 닫기 기능
//         frame.dispose();
//     }

// }
// 1) 해당 클래스의 이름이 없으므로 , 이름 부분 생략, 
// (클래스명 생략) ActionListener {

//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // 이벤트 기능, 닫기 기능
//         frame.dispose();
//     }
// }
//
// 2) 익명 클래스로 인스턴스를 생성 할려고 보니, 이름이 없네, 어떡하죠? 
// 인터페이스명 변수 = new 인터페이스명() {
// 이벤트 처리 구조 , 메서드 구현
//}


public class InnerClass_Anonymous_Lambda2 {
    public static void main(String[] args) { //메인클래스
        JFrame frame = new JFrame("익명 클래스 예시");
        JButton button = new JButton("닫기");

            // 익명클래스 할당 부분
            button.addActionListener(new ActionListener() { // ->new 인터페이스()
            // .addActionListener(...): 버튼에 클릭 이벤트 리스너를 등록
                // (new ActionListener() { ... }): 익명 클래스를 사용하여 ActionListener 인터페이스의 메서드를 직접 구현
                
                public void actionPerformed(ActionEvent e) {
                    // actionPerformed(...): 버튼이 클릭되었을 때 자동으로 호출
                    frame.dispose();

                }
            });

        frame.add(button);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 나가겠다.
        frame.setVisible(true);
    }
}
