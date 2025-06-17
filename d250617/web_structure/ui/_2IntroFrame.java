package d250617.web_structure.ui;

import javax.swing.Timer;

import javax.swing.JFrame;

import javax.swing.JLabel;

// 인트로 화면 약 3초 보여주고 메인화면으로 자동전환
public class _2IntroFrame extends JFrame{
    // 설계클래스
    // 생성자에 필요한 기능을 넣고
        // 이 클래스에 기본생성자를 호출(인스턴스생성시) 동작하게끔 하는 원리.
    public _2IntroFrame() {
        // JFrame frame = new JFrame("창의 제목");
            // JFrame 상속을 받았기 때문에 이 클래스는 임의기능을 탑재하고있음.
                // ㄴ 예시) frame.setTitle(); --> 바로 setTitle(); 사용함.
            setTitle("3초_2인트로 Frame 화면 예시"); // 윈도우창 제목
            setSize(400,200);
            setLocationRelativeTo(null); // 화면중앙 배치 기능
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 안내 문구 표시
        JLabel label = new JLabel("환영합니다. >>> 3초후 메인화면으로 이동합니다");
        // 프레임에 라벨 붙이기
        add(label);

        setVisible(true);

        // 3초후 다른 화면으로 이동하는 기능... 타이머 기능 사용하기.
        // Timer timer = new Timer(3000, 1)내부클래스 2) 익명클래스 3) 람다식)
        Timer timer = new Timer(3000,  //new 인터페이스() 없이 곧바로 (매개변수 -> { 구현 }) 형태로 쓰면 람다식
            e -> { 
                new _3MainFrame(); // 메인 화면 생성, 해당 클래스 기본 생성자를 호출하면 기능 동작
                // 현재화면, 인트로 화면만 창 닫기.
                dispose();
            });
        timer.setRepeats(false); // 타이머가 1회만 실행.
        timer.start();
    }

}
