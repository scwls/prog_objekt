import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {
    private String transform;

    public TransformationDecorator(Shape decoratedShape, String transform) {
        super(decoratedShape);
        this.transform = transform;
    }
    @Override
    public String toSvg(){
        return super.decoratedShape.toSvg().replace("/>", String.format(" transform=\"%s\" />", transform));
    }

    public static class Builder{
        private String transform="";
        public Builder(){
        }
        public Builder translate(Vec2 translation){
            transform+=String.format(Locale.ENGLISH, " translate(%f %f)", translation.x(), translation.y());
            return this;
        }
        public Builder scale(Vec2 scale){
            transform+=String.format(Locale.ENGLISH, " scale(%f %f)", scale.x(), scale.y());
            return this;
        }
        public Builder rotate(Double rotation, Vec2 center){
            transform+=String.format(Locale.ENGLISH, " rotate(%f %f %f)", rotation, center.x(), center.y());
            return this;
        }
        public TransformationDecorator build(Shape shape) {
            return new TransformationDecorator(shape, this.transform);
        }
    }
}
