import java.util.Locale;

public class SolidFilledPolygon extends Polygon{
    private String color;
    public SolidFilledPolygon(Vec2[] points, String color){
        super(points);
        this.color=color;
    }
    @Override
    public String toSvg(String parametrs){
        String newParametrs=String.format(Locale.ENGLISH, "fill=\"%s\" %s ", color, parametrs);
        return super.toSvg(newParametrs);
    }
}
