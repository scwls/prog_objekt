import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements Runnable {
    public static final int WIDTH  = 640;
    public static final int HEIGHT = 800;
    private final Paddle paddle;
    private final Ball ball;
    private final Thread thread;
    private Boolean running = false;
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        GraphicsItem.setCanvasSize(WIDTH, HEIGHT);
        paddle = new Paddle();
        ball = new Ball();
        thread = new Thread(this);
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                paddle.updatePosition(mouseEvent.getX());
                ball.setInitialPosition(paddle);
                //repaint();
                if(!running){
                    repaint();
                    ball.setInitialPosition(paddle);
                }
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!running){
                    startGame();
                }
            }
        });
    }

    private void startGame(){
        running = true;
        thread.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        paddle.draw(graphics2D);
        ball.draw(graphics2D);
    }


    @Override
    public void run() {
        while(running) {
            update();
            repaint();
        }
    }

    public void update(){
        ball.update();
    }
}