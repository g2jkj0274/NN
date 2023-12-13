package NeonNights_UrbanEscape; // 패키지 선언, 실제 패키지 명에 맞게 수정해야 할 수도 있습니다.

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private ImageIcon backgroundImage;

    public GameWindow() {
        setTitle("Neon Nights Urban Escape"); // 게임 창의 제목 설정
        setSize(1280, 720); // 게임 창의 크기 설정
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 버튼을 누르면 프로그램 종료
        setLocationRelativeTo(null); // 창을 화면 가운데에 위치
        setResizable(false); // 창 크기 변경 불가능하게 설정

        // 이미지 로드 및 크기 조정
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/main.png"));
        Image image = originalIcon.getImage();
        Image resizedImage = image.getScaledInstance(1280, 720,  Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // 배경 이미지를 가진 레이블 생성
        JLabel backgroundLabel = new JLabel(resizedIcon);
        backgroundLabel.setLayout(new FlowLayout()); // 레이아웃 설정

        // CustomButton 생성
        CustomButton startButton = new CustomButton("Start Game");
        CustomButton optionsButton = new CustomButton("Options");

        // 버튼을 배경 레이블에 추가
        backgroundLabel.add(startButton);
        backgroundLabel.add(optionsButton);

        // 컨텐트 팬 설정
        setContentPane(backgroundLabel);

        // 창 표시
        setVisible(true);
    }
}
