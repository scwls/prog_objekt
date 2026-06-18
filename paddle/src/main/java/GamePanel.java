import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static final int WIDTH  = 640;
    public static final int HEIGHT = 800;
    private final Paddle paddle;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        GraphicsItem.setCanvasSize(WIDTH, HEIGHT);
        paddle = new Paddle();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        paddle.draw(graphics2D);
    }




}