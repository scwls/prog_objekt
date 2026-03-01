import java.util.Locale;
public class Point {
    public float x;
    public float y;
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
