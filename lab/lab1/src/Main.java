import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Point[] points=new Point[3];
        points[0]=new Point(0.0f, 0.0f);
        points[1]=new Point(0.0f, 5.0f);
        points[2]=new Point(5.0f, 0.0f);
        Polygon polygon=new Polygon(points);
        Point[] points2 = new Point[3];
        points2[0] = new Point(1.3F, 4.6F);
        points2[1] = new Point(8.5F, 12.4F);
        points2[2] = new Point(15.4F, 74.2F);
        Polygon polygon2= new Polygon(points2);
        Polygon polygon3 = new Polygon(new Point[]{
                new Point(4.3F, 7.6F),
                new Point(2.3F, 8.6F),
                new Point(5.3F, 10.6F)
        });
        SvgScene svg=new SvgScene();
        svg.addPolygon(polygon);
        svg.addPolygon(polygon2);
        svg.addPolygon(polygon3);
        svg.addPolygon(polygon3);
    }
}
