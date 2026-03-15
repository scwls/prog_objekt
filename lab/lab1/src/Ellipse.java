public class Ellipse extends Shape{
    private Point center;
    private Double rx, ry;
    private Style style;
    public Ellipse(Point center, Double rx, Double ry, Style style){
        this.style=style;
        this.rx=rx;
        this.ry=ry;
        this.center=center;
    }
    @Override
    public String toSvg() {
        String res="<ellipse rx=\""+center.getX()+"\" ry=\""+center.getY()+"\" cx=\"" +rx+"\" cy=\""+ry+"\""+ " "+style.toSvg()+"/>";
        return res;
    }
}
