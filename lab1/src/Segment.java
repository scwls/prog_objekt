public class Segment {
    public Point p1;
    public Point p2;
    public double length(){
        float x=p2.x-p1.x;
        float y=p2.y-p1.y;
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
        return "x1="+p1.x+ ", y1="+p1.y+"    x2="+p2.x+ ", y2="+p2.y;
    }
}

