import java.awt.*;

public class Paddle extends GraphicsItem {

    public Paddle() {
        y = canvasHeight * 0.9;
        height = canvasHeight * 0.02;
        width = canvasWidth  * 0.2;
        x = 0.5*(canvasWidth - width);
    }

    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(new Color(0x041D50));
        graphics2D.fillRect((int)x, (int)y, (int)width, (int)height);
    }
}
