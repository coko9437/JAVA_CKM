package d250613.ch9_3;

import java.util.ArrayList;
import java.awt.*; //수동으로 임폴트
// 이벤트 기능
import java.awt.event.*;
import javax.swing.*;

// 이미지를 JLabel에 출력하고, 버튼 클릭시, 이미지 화면이 변경 되는 프로그램. 
// 각 패널에 UI를 배치하고, -> frame 붙이기 , 

    // 클래스명이 JFrame을 상속합니다 → 즉, 이 클래스 자체가 하나의 창(Window) 입니다.
public class _1ImageGallery extends JFrame {
    // ImageIcon 클래스 이용해서 이미지를 타입으로 가지는 리스트 하나 생성
    private ArrayList<ImageIcon> images;

    // 해당 이미지들 저장할 리스트 제목
    private ArrayList<String> titles;
    
    // 이미지를 출력시 순서를 나타내는 상태변수...이미지가 몇 번째인지 추적하기 위한 인덱스 변수를 currentIndex로 둠.
    private int currentIndex = 0 ; 
        // 왜 private 사용?? -> 현재 클래스 파일에서만 접근가능하게


    // UI구성 
    private JLabel titLabel; // 제목

    private JLabel imageLabel; // 이미지 표시

    private JPanel thumbnailPanel; // 썸네일(손톱) -> 이미지를 손톱만한 크기로 변경함.

    // 매개변수 생성자 정의 
        //  클래스가 호출될 때 실행
    // 1) 정적메서드 ||| 2) 생성자 호출(인스턴스 형식)
    public _1ImageGallery(ArrayList<ImageIcon> images, ArrayList<String> titles) {
        this.images = images;
        this.titles = titles;
            // 리스트 2개를 본인 클래스로 장착하기
    
    // 창 제목
    setTitle("이미지 갤러리 예시");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600,500);
    setLayout(new BorderLayout()); // 기본값이지만 명시적으로 표기

    // 이미지 제목 생성자를 여기서 초기화함.( 생성자 밖에서 선언만 했었음)
        // 이미지 제목 리스트를 여기서 꺼내어 변환함.
    titLabel = new JLabel("", SwingConstants.CENTER); //텍스트 가운데정렬
    
    titLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

    add(titLabel, BorderLayout.NORTH); // 프레임 북쪽에 제목 붙이기

    // 이미지라벨
    imageLabel = new JLabel(); 
    imageLabel.setHorizontalAlignment(SwingConstants.CENTER); //수평 정렬
    add(imageLabel,BorderLayout.CENTER); 

    // 네비게이션, 버튼
    JPanel navPanel = new JPanel(); // JPanel 기본배치 : FlowLayout
    JButton preBtn = new JButton("이전으로");
    JButton nextBtn = new JButton("다음으로");

    navPanel.add(preBtn);
    navPanel.add(nextBtn);
//전
// add(navPanel,BorderLayout.SOUTH);

    // 썸네일 패널 
    thumbnailPanel = new JPanel();
    thumbnailPanel.setLayout(new FlowLayout());
//전
// add(thumbnailPanel, BorderLayout.PAGE_END);
// ==========================================================
    // 2개의 패널 , 합치는 패널.
    // 수정 , 후
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(navPanel, BorderLayout.NORTH);
        southPanel.add(thumbnailPanel, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);
// ==========================================================

    // 버튼에 대해서 이벤트리스너설정 (람다식)
    preBtn.addActionListener(e -> showImage(currentIndex -1));
    nextBtn.addActionListener(e -> showImage(currentIndex +1));
        // 현재 인덱스 번호는 우리가 나타내고싶은 이미지의 인덱스번호와 동일함.
    
    // 함수 호출 기능
        // 1) 썸네일 이미지 호출기능
        // 2) 초기 이미지 호출기능
    loadThumbnails(); //(1)
    showImage(0); //(2)

    // 위치를 중앙에 배치
    setLocationRelativeTo(null);
    setVisible(true);

    }

    // 정의
    // 함수를 호출 기능, 1) 썸네일 이미지 호출 기능 , 2) 초기 이미지 호출 기능
    private void showImage(int index) {
        if(index <0 || index >=images.size()) // 기본 유효성 체크, 인덱스 범위를 넘어갈 경우, 메서드 나가기
            return;
            currentIndex = index;
            // imageLabel.setIcon       :이미지 설정하는기능
            // images.get(currentIndex); : 리스트 요소에 이미지파일
            // 예시) 1번 이미지 : test.jpg -> 인덱스 0번
        imageLabel.setIcon(images.get(currentIndex));
        titLabel.setText(titles.get(currentIndex));
    }

    // 썸네일 이미지 호출 기능
    private void loadThumbnails() {
        // 썸네일 패널에서 기존에 추가된 모든 컴포넌트(이미지)를 제거함.
        thumbnailPanel.removeAll();

        // 이미지 리스트의 크기만큼 반복 할 예정.
        for (int i = 0; i < images.size(); i++) {
            // 원본 이미지를 60x60 리사이즈, 썸네일 아이콘 만들 예정.
            ImageIcon thumbIcon = new ImageIcon(
                    images.get(i).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

            // 썸네일 이미지를 JLabel에 담기.
            JLabel thumLabel = new JLabel(thumbIcon);

            // 인덱스를 이용해서 지정.
            int idx = i;

            // 썸네일 라벨에 테두를 추가
            thumLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

            // 마우스에 커서 올리면 손가락 모양으로 변경 하는 기능.
            thumLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // 썸네일 라벨에 마우스 클릭 이벤트 추가. , 메인 이미지를 보기.
            thumLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showImage(idx);
                }
            });

            // 썸네일 패널에 라벨 추가.
            thumbnailPanel.add(thumLabel);

        } // for문 끝.

        // 썸네일 패널의 레이아웃을 다시 계산 기능
        thumbnailPanel.revalidate();
        // 다시 그리기.
        thumbnailPanel.repaint();
    }

    
    public static void main(String[] args) {
        // 임시 이미지, 제목 담을 리스트 
        ArrayList<ImageIcon> imageList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        
        // 샘플 이미지를 불러오기. 리스트에 담기
        imageList.add(new ImageIcon("test5.jpg"));
        imageList.add(new ImageIcon("test6.jpg"));
        imageList.add(new ImageIcon("test7.jpg"));
        // 이미지 제목, 문자열 , 리스트에 담기.
        titleList.add("첫 번째 이미지");
        titleList.add("두 번째 이미지");
        titleList.add("세 번째 이미지");


        // 인스턴스로 호출.
        // 전
        // new _1ImageGallery(imageList, titleList);
        // 스레드는 뒤에 가서 이야기, 동시에 동작 하기 위한 준비,
        // 1)실행하는 스레드,
        // 2)그림을 그려주는 스레드를 분리해서 작업

        // 후
        SwingUtilities.invokeLater(() -> new _1ImageGallery(imageList, titleList));
        // 자바 스윙에서 GUI 이벤트 디스패치 스레드 (EDT)
        // 스윙에서 표준으로 사용하는 안전한 방식.
        // 만약, 동기화 문제, 무작위 충돌이남, 비정상적인 동작을함, 막기 위해서,
        // 그림을 그려주는 기능 스레드를 따로 분리함
        // 스레드, 어떤 기능을 동시에 실행한다.
        // 예시) 전화, 웹 서핑 하면서, 카톡도하고, 음악도 듣고, 다 스레드.
    }
    
}
