package NeonNights_UrbanEscape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GameWindow() {
        initializeFrame();
        initializeCardLayout();
        setupPanels();
        setVisible(true);
    }

    // 윈도우의 기본 설정을 초기화합니다.
    private void initializeFrame() {
        setTitle("Neon Nights Urban Escape");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // CardLayout을 초기화합니다.
    private void initializeCardLayout() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
    }

    // 메인 메뉴 패널과 테스트 게임 패널을 설정합니다.
    private void setupPanels() {
        JPanel mainMenuPanel = createMainMenuPanel();
        JPanel testGamePanel = createTestGamePanel();

        cardPanel.add(mainMenuPanel, "MainMenu");
        cardPanel.add(testGamePanel, "TestGame");

        setContentPane(cardPanel);
    }

    // 메인 메뉴 패널을 생성합니다.
    private JPanel createMainMenuPanel() {
        JPanel mainMenuPanel = new JPanel(new BorderLayout());
        JLabel backgroundLabel = createBackgroundLabel();

        mainMenuPanel.add(backgroundLabel, BorderLayout.CENTER);
        mainMenuPanel.add(createButtonPanel(), BorderLayout.SOUTH);

        return mainMenuPanel;
    }

    // 배경 이미지를 가진 레이블을 생성합니다.
    private JLabel createBackgroundLabel() {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/images/main.png"));
        Image image = originalIcon.getImage();
        Image resizedImage = image.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        return new JLabel(new ImageIcon(resizedImage));
    }

    //시작 및 옵션 버튼이 있는 패널을 생성합니다.
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);

        CustomButton startButton = new CustomButton("Start Game");
        startButton.addActionListener(e -> cardLayout.show(cardPanel, "TestGame"));
        buttonPanel.add(startButton);

        CustomButton optionsButton = new CustomButton("Options");
        // optionsButton.addActionListener(...); // 옵션 버튼 리스너 설정
        buttonPanel.add(optionsButton);

        CustomButton characterButton = new CustomButton("Character");
        buttonPanel.add(characterButton);

        return buttonPanel;
    }

    // 테스트 게임 패널을 생성합니다.
    private JPanel createTestGamePanel() {
        return new TestGamePanel();
    }

    // 게임 컨텐츠를 위한 내부 클래스입니다.
    private class TestGamePanel extends JPanel {
        public TestGamePanel() {
            setBackground(Color.BLACK);
            setLayout(new BorderLayout());

            setupKeyBindings();

            // 메뉴 버튼 생성 및 설정
            CustomButton menuButton = new CustomButton("Menu");
            menuButton.addActionListener(e -> openPopupMenu());
            add(menuButton, BorderLayout.NORTH);
        }

        private void setupKeyBindings() {
            // 메뉴 열기 액션
            Action openMenuAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openPopupMenu();
                }
            };

            // InputMap과 ActionMap 설정
            getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "openMenu");
            getActionMap().put("openMenu", openMenuAction);
        }

        // 팝업 메뉴를 여는 메소드
        private void openPopupMenu() {
            JPopupMenu popupMenu = new JPopupMenu();

            // 메인 메뉴로 돌아가기 버튼
            JMenuItem mainMenu = new JMenuItem("Main Menu");
            mainMenu.addActionListener(e -> cardLayout.show(cardPanel, "MainMenu"));
            popupMenu.add(mainMenu);

            // 취소 버튼
            JMenuItem cancel = new JMenuItem("Cancel");
            cancel.addActionListener(e -> popupMenu.setVisible(false));
            popupMenu.add(cancel);

            // 팝업 메뉴 표시
            popupMenu.show(this, getWidth() / 2, getHeight() / 2);
        }
    }
    // main 메소드는 Main 클래스에 있습니다.
}
