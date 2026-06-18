import java.awt.*;
import java.awt.geom.Point2D;

public class Ball extends  GraphicsItem{

    private Point2D.Double moveVector = new Point2D.Double(1, -1);
    private static double velocity = 0.00003;

    public Ball(){
        height = 0.018 * canvasHeight;
        width = 0.018 * canvasHeight;
    }

    public void setInitialPosition(Paddle paddle){
        x = paddle.getX() + paddle.getWidth()/2;
        y = paddle.getY() - height/2 +1;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillOval((int)x - (int)(width*0.5), (int) y - (int)(width*0.5), (int) width, (int) height);
    }

    public void update(){
        x = x + moveVector.x * velocity;
        y = y + moveVector.y * velocity;
    }
}
