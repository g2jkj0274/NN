package NeonNights_UrbanEscape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    // CardLayout과 JPanel 선언
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GameWindow() {
        setTitle("Neon Nights Urban Escape");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // CardLayout 초기화
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // 배경 이미지 로드 및 설정
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/main.png"));
        Image image = originalIcon.getImage();
        Image resizedImage = image.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel backgroundLabel = new JLabel(resizedIcon);

        // 메인 메뉴 패널 설정
        JPanel mainMenuPanel = new JPanel(new BorderLayout());
        mainMenuPanel.add(backgroundLabel, BorderLayout.CENTER);
        cardPanel.add(mainMenuPanel, "MainMenu");

        // 테스트 게임 화면 패널 설정
        JPanel testGamePanel = new TestGamePanel(); // TestGamePanel은 여러분의 게임 콘텐츠를 포함할 클래스입니다.
        cardPanel.add(testGamePanel, "TestGame");

        // 시작 버튼 생성 및 액션 리스너 추가
        CustomButton startButton = new CustomButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "TestGame");
            }
        });

        // 옵션 버튼 생성 및 설정 (선택적)
        CustomButton optionsButton = new CustomButton("Options");
        // 옵션 버튼에 대한 액션 리스너 추가 (선택적)

        // 메인 메뉴 패널에 버튼 추가
        JPanel buttonPanel = new JPanel(); // 버튼을 위한 새로운 패널
        buttonPanel.setOpaque(false); // 패널 배경을 투명하게 설정
        buttonPanel.add(startButton);
        buttonPanel.add(optionsButton);
        mainMenuPanel.add(buttonPanel, BorderLayout.SOUTH); // 버튼 패널을 남쪽에 배치

        // 컨텐트 팬 설정
        setContentPane(cardPanel);

        // 창 표시
        setVisible(true);
    }

    // 테스트 게임 화면을 위한 패널 클래스
    private class TestGamePanel extends JPanel {
        public TestGamePanel() {
            setBackground(Color.BLACK); // 배경 색 설정
            // 여기에 게임 컨텐츠를 구성
        }
    }
}
