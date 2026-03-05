import java.util.Random;
public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        Point p = new Point(5.4f, 3.8f);
        System.out.println("RES: " + p);
        System.out.println(p.toSVG());
        p.translate(1.0f, 2.0f);
        System.out.println("RES: " + p);
        Point p2 = p.translated(2.0f, 1.0f);
        System.out.println("RES: " + p2);
        Point pk1 =new Point(2.0f, 3.0f);
        Point pk2=new Point(4.0f, 8.0f);
        Segment s = new Segment(pk1, pk2);
        double len = s.length();
        System.out.printf("Odleglosc=%.2f%n", len);
        Segment[] ss=new Segment[5];
        Random rand=new Random();
        System.out.println("!!!!!!!!!!!!!"+s+"!!!!!!!!!");
        pk1.setX(999.0f); //sprawdzamy
        System.out.println("!!!!!!!!!!!!!"+s+"!!!!!!!!!");
        System.out.println(s.toString1());
        for(int i=0; i<5; i++){
            Point randP1=new Point(rand.nextInt(10), rand.nextInt(10));
            Point randP2=new Point(rand.nextInt(10), rand.nextInt(10));
            ss[i]=new Segment(randP1, randP2);
        }
        Segment winner=Segment.longestSeg(ss);
        System.out.println(winner);
        Point[] trojkat=new Point[3];
        trojkat[0]=new Point(0.0f, 0.0f);
        trojkat[1]=new Point(0.0f, 5.0f);
        trojkat[2]=new Point(5.0f, 0.0f);
        Polygon pol_trojkat=new Polygon(trojkat);
        Polygon temp=new Polygon(pol_trojkat);
        trojkat[2]=new Point(3, 7);
        System.out.println(temp.toSVG());
    }
}
