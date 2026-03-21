import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon triangle = new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        });

        Polygon rectangle = new Polygon(new Vec2[]{
                new Vec2(350, 0),
                new Vec2(750, 0),
                new Vec2(750, 200),
                new Vec2(350, 200)
        });

        Shape pentagon = new StrokeShapeDecorator(new SolidFilledPolygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        }, "green"), "red", 10.0);

        Shape transformedPentagon= new TransformationDecorator.Builder()
                .translate(new Vec2(50, 50))
                .scale(new Vec2(1.2, 1.2))
                .rotate(45.0, new Vec2(300, 410))
                .build(pentagon);

        Ellipse ellipse = new Ellipse(new Vec2(500, 700), 400, 100);

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(transformedPentagon);
        scene.addShape(ellipse);
        scene.save("result.svg");
    }
}
