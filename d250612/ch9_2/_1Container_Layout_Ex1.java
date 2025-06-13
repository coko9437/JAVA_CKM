package d250612.ch9_2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// 컨테이너 : 버튼, 라벨, UI를 담는 도화지(그릇) : JFrame, JPanel

// 배치관리자(LayoutManager)
    // 정렬을 어떻게 하나?: /// 웹 : FLEX 자동으로 나란히 배치 /// grid : 행x열 (테이블구조)
// 종류 : FlowLayout(웹의 flex와 비슷함), BoarderLayout(동,서,남,북,중앙), GridLayout(웹의 grid와 비슷)

// JFrame => 기본 배치관리자: BoarderLayout  (Default)
// JPanel => 기본 배치관리자: FlowLayout  (Default)

// 1) 패널만들기, 2) 컴포넌트 추가(버튼추가), 3) 패널->프레임(윈도우창)에 붙이기작업.
// JPanel panel = new JPanel();
//  panel.setLayout(배치관리자 인스턴스 생성)
//  panel.setLayout(new FlowLayout()) // FLowLayout 배치 관리자 선택. 기능? 나란히배치(정렬)
//  버튼추가(컴포넌트 추가)
//  panel.add(new JButton("예시버튼"));
//  JFrame frame = new JFrame("배치관리자 예시");
//  frame.add(panel);
//  frame.setSize(300,200);
//  frame.setVisible(true);


// 자주 사용하는 옵션
//  setLayout(LayoutManager manager)... ex) new FlowLayout(), new BoarderLayout(), new GridLayout()
//  add(Component comp) : 버튼추가 등
//  add(Component comp, Object constraints) : 특정 위치에 배치하는방법

public class _1Container_Layout_Ex1 {
    public static void main(String[] args) {
        // JPanel 1개에 FlowLayout 넣기
        JFrame frame = new JFrame("FlowLayout 예시");
        JPanel panel = new JPanel();

        // 배치관리자 설정 (FlowLayout)
        panel.setLayout(new FlowLayout());
        // 패널에 샘플버튼 4개 정도 추가 그리고 나란히 정렬 확인
        panel.add(new JButton("샘플버튼1"));
        panel.add(new JButton("샘플버튼2"));
        panel.add(new JButton("샘플버튼3"));
        panel.add(new JButton("샘플버튼4"));

        // 프레임에 패널붙이기
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 나가겠다.
        frame.setVisible(true);

    }    
}
