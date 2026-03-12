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
        Style customStyle= new Style("red", "black", 3.5);
        Polygon polStyle = new Polygon(points, customStyle);
        Polygon polDefault = new Polygon(points2);
        System.out.println(polStyle.toSVG());
        System.out.println(polDefault.toSVG());
        SvgScene scene=new SvgScene();
        scene.addPolygon(
                Polygon.square(new Segment(
                                new Point(130.0f, 100.0f), new Point(100.0f, 140.0f)),
                        new Style("red", "green", 3.0))
        );
        Segment segment1=new Segment(new Point(3.0f, 0.0f), new Point(0.0f,4.0f));
        Segment segment2=segment1.perpendicular();
        System.out.println(segment2);
    }
}
