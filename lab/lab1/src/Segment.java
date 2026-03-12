public class Segment {
    private Point p1;
    private Point p2;
//    public Segment(Point p1, Point p2){ //конструктор с уязвимостями
//        this.p1=p1;
//        this.p2=p2;
//    }

    public Segment(Point p1, Point p2){
        this.p1=new Point(p1);
        this.p2=new Point(p2);
    }
    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }

    public Segment perpendicular(){
        float x1= p1.getX();
        float y1= p1.getY();
        float x2= p2.getX();
        float y2= p2.getY();
        float midX=(x1+x2)/2.0f;
        float midY=(y1+y2)/2.0f;
        float dx=(x2-x1)/2.0f;
        float dy=(y2-y1)/2.0f;
        Point p3=new Point(midX-dy, midY+dx);
        Point p4=new Point(midX+dy, midY-dx);
        return new Segment(p3, p4);
    }

    public String toString1(){
        return "początek: "+p1+"  koniec: "+p2;
    }

    public double length(){
        float x=p2.getX()-p1.getX();
        float y=p2.getY()-p1.getY();
        return Math.sqrt(x * x + y * y);
    }
    public static Segment longestSeg(Segment[] segs){
        if(segs==null || segs.length==0){
            return null;
        }
        Segment longest=segs[0];
        for(int i=1; i<segs.length; i++){
            if(segs[i].length()>longest.length()){
                longest=segs[i];
            }
        }
        return longest;
    }
    public String toString(){
        return "x1="+p1.getX()+ ", y1="+p1.getY()+"    x2="+p2.getX()+ ", y2="+p2.getY();
    }
}

