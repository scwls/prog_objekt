import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Point[] points=new Point[3];
        points[0]=new Point(0.0f, 0.0f);
        points[1]=new Point(0.0f, 100.0f);
        points[2]=new Point(100.0f, 0.0f);
        Polygon polygon=new Polygon(points);
        Point[] points2 = new Point[3];
        points2[0] = new Point(78.3F, 200.6F);
        points2[1] = new Point(15.5F, 18.4F);
        points2[2] = new Point(190.4F, 74.2F);
        Polygon polygon2= new Polygon(points2);
        Polygon polygon3 = new Polygon(new Point[]{
                new Point(25.3F, 25.6F),
                new Point(75.3F, 75.6F),
                new Point(15.3F, 90.6F)
        });
        SvgScene svg=new SvgScene();
        svg.addPolygon(polygon);
        svg.addPolygon(polygon2);
        svg.addPolygon(polygon3);
        //svg.addPolygon(polygon3);
        System.out.println(svg.toSvg());
    }
}
