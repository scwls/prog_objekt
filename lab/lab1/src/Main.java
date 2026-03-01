import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        Point p = new Point();
        p.x = 5.4f;
        p.y = 3.8f;
        System.out.println("RES: " + p);
        System.out.println(p.toSVG());
        p.translate(1.0f, 2.0f);
        System.out.println("RES: " + p);
        Point p2 = p.translated(2.0f, 1.0f);
        System.out.println("RES: " + p2);
        Segment s = new Segment();
        s.p1 = new Point();
        s.p2 = new Point();
        s.p1.x = 2.0f;
        s.p1.y = 1.0f;
        s.p2.x = 6.0f;
        s.p2.y = 8.0f;
        double len = s.length();
        System.out.printf("Odleglosc=%.2f%n", len);
        Segment[] ss=new Segment[5];
        Random rand=new Random();
        for(int i=0; i<5; i++){
            ss[i]=new Segment();
            ss[i].p1=new Point();
            ss[i].p2=new Point();
            ss[i].p1.x=rand.nextInt(10);
            ss[i].p1.y=rand.nextInt(10);
            ss[i].p2.x=rand.nextInt(10);
            ss[i].p2.y=rand.nextInt(10);
        }
        Segment winner=Segment.longestSeg(ss);
        System.out.println(winner);
    }
}
