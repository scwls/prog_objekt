public class Segment {
    public Point p1;
    public Point p2;
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

