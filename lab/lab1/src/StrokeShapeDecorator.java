public class StrokeShapeDecorator extends ShapeDecorator {
    String color;
    Double width;
    StrokeShapeDecorator(Shape decoratedShape,String color, Double width){
        super(decoratedShape);
        this.color=color;
        this.width=width;
    }
    @Override
    public String toSvg(){
        return super.toSvg().replace("/>", String.format("stroke=\"%s\" stroke-width=\"%f\" />", color, width));
    }
}
