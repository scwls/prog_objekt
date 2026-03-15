import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class SvgScene {
    private Shape[] shapes=new Shape[3];
    private int index=0;
    public void addShape(Shape p){
        shapes[index]=p;
        index++;
        if(index==3){
            index=0;
        }
    }

    public String toSvg(){
        StringBuilder polygonsString = new StringBuilder();
        polygonsString.append("\n");
        for (var polygon: shapes){
            if (polygon != null) {
                polygonsString.append("\t");
                polygonsString.append(polygon.toSvg())
                        .append("\n");
            }
        }
        return String.format(Locale.ENGLISH, "<svg height=\"260\" width=\"500\" xmlns=\"http://www.w3.org/2000/svg\">%s</svg>", polygonsString);
    }
    public void save(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        writer.write(toSvg());
        writer.close();
    }
}