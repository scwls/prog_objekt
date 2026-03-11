    public class Polygon {
        private Point[] points;
        public Polygon(Point[] points) {
            this.points = new Point[points.length];
            for(int i=0; i< points.length; i++){
                this.points[i]=points[i];
            }
        }

        public Polygon(Polygon p) {
            this(p.points);
        }

        public String toString(){
            String res="Polygon: ";
            for(int i=0; i< points.length; i++){
                res += points[i];
                if(i< points.length-1){
                    res+=" ,";
                }
            }
            return res;
        }
        public String toSVG(){
            String svg="<polygon points=\"";
            for(int i=0; i< points.length; i++){
                svg+=points[i].getX()+ ","+points[i].getY()+" ";
            }
            svg += "\" style=\"fill:none;stroke:black;stroke-width:1\" />";
            return svg;
        }
        public BoundingBox boundingBox(){
            float minX=points[0].getX();
            float minY=points[0].getY();
            float maxX=points[0].getX();
            float maxY=points[0].getY();
            for(int i=1; i<points.length; i++){
                float tmpX=points[i].getX();
                float tmpY=points[i].getY();
                if(tmpX<minX){
                    minX=tmpX;
                }
                if(tmpX>maxX){
                    maxX=tmpX;
                }
                if(tmpY<minY){
                    minY=tmpY;
                }
                if(tmpY>maxY){
                    maxY=tmpY;
                }
            }
            float width=maxX-minX;
            float height=maxY-minY;
            BoundingBox box=new BoundingBox(minX, minY, width, height);
            return box;
        }

    }
