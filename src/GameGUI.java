import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame {
    private JLabel backgroundLabel;
    private JLabel characterLabel;
    private JLabel textLabel;
    private int characterX;
    private int characterY;

    public GameGUI() {
        setTitle("Game Zombie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        characterX = 100;
        characterY = 280;

        // Load and set background image
        ImageIcon backgroundImage = new ImageIcon("src/asset/background.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 550);
        add(backgroundLabel);

        // Load, scale and set character image
        ImageIcon characterImage = new ImageIcon("src/asset/character.png");
        Image image = characterImage.getImage(); // transform it
        Image scaledImage = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        characterImage = new ImageIcon(scaledImage);  // transform it back

        characterLabel = new JLabel(characterImage);
        characterLabel.setBounds(characterX, characterY, 200, 200);
        backgroundLabel.add(characterLabel); // Add characterLabel to backgroundLabel


        textLabel = new JLabel("welcome to the journey of ???");
        textLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        textLabel.setForeground(Color.GRAY);
        textLabel.setBounds(350, 200, 400, 30);
        backgroundLabel.add(textLabel);

        // Add key listener
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch (keycode) {
                    case KeyEvent.VK_W:
                        characterY -= 10;
                        break;
                    case KeyEvent.VK_S:
                        characterY += 10;
                        break;
                    case KeyEvent.VK_D:
                        characterX += 10;
                        break;
                    case KeyEvent.VK_A:
                        characterX -= 10;
                        break;
                }
                characterLabel.setLocation(characterX, characterY);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not needed for this example
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not needed for this example
            }
        });
    }
}