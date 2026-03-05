import java.util.Locale;

public class SvgScene {
    private Polygon[] polygons=new Polygon[3];
    private int index=0;
    public void addPolygon(Polygon p){
        polygons[index]=p;
        index++;
        if(index==3){
            index=0;
        }
    }
    public String toSvg(){
        String res="";

        for(int i=0; i<polygons.length; i++){
            if(polygons[i]!=null){
                res+=polygons[i].toSVG()+"\n";
            }
        }
        return String.format(Locale.ENGLISH, "<svg height=\"260\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n%s</svg>", res);
    }

}
