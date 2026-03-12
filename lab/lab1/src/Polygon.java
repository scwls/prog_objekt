    public class Polygon {
        private Point[] points;
        private Style style;
        public Polygon(Point[] points) {
            this.points = new Point[points.length];
            for(int i=0; i< points.length; i++){
                this.points[i]=points[i];
            }
            this.style= new Style("none", "black", 1.0);
        }

        public Polygon(Point[] points, Style style) {
            this.points = points;
            this.style=style;
        }
        public static Polygon square(Segment segment, Style style){
            Segment perp=segment.perpendicular();
            Point[] pointsSquare= new Point[4];
            pointsSquare[0]=segment.getP1();
            pointsSquare[1]=perp.getP1();
            pointsSquare[2]=segment.getP2();
            pointsSquare[3]=perp.getP2();
            return new Polygon(pointsSquare, style);
        }


        public String toSVG(){
            String res="<polygon points=\"";
            for(int i=0; i < points.length; i++ ) {
                res += points[i].getX() + "," + points[i].getY() + " ";
            }
            res+="\" " + style.toSvg()+" />";
            return res;
        }


    }
