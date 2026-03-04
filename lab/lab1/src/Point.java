import java.util.Locale;
public class Point {
    private float x;
    private float y;
    public Point(){
        this.x=0.0f;
        this.y=0.0f;
    }
    public Point(float x, float y){
        this.x=x;
        this.y=y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setX(float x){
        this.x=x;
    }

    public void setY(float y){
        this.y=y;
    }

    public Point(Point otherPoint){
        this.x = otherPoint.getX();
        this.y = otherPoint.getY();
    }

    public String toString(){
        return "x="+x+ ", y="+y;
    }
    public String toSVG(){
        return String.format(Locale.ENGLISH,"<circle r=\"5\" cx=\"%f\" cy=\"%f\" fill=\"red\" />", x, y);
    }
    public void translate(float dx, float dy){
        x+=dx;
        y+=dy;
    }
    public Point translated(float dx, float dy){
        Point np=new Point();
        np.x=dx+x;
        np.y=dy+y;
        return np;
    }
}
