package NeonNights_UrbanEscape; // 패키지 선언, 실제 패키지 명에 맞게 수정해야 할 수도 있습니다.

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NeonNights_UrbanEscape.GameWindow(); // 게임 윈도우를 생성하고 표시합니다.
            }
        });
    }
}
