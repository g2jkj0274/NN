package NeonNights_UrbanEscape;

import javax.swing.JButton;
import java.awt.Font;

// CustomButton 클래스는 JButton을 확장하여 재사용 가능한 버튼 구성을 제공합니다.
public class CustomButton extends JButton {

    // 생성자에서 버튼의 텍스트와 다른 속성들을 설정합니다.
    public CustomButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 16)); // 글꼴 설정
        // 여기에 필요한 버튼 속성들을 추가할 수 있습니다.
    }
}
