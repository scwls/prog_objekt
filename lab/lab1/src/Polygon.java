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


        public String toSVG(){
            String res="<polygon points=\"";
            for(int i=0; i < points.length; i++ ) {
                res += points[i].getX() + "," + points[i].getY() + " ";
            }
            res+="\" " + style.toSvg()+" />";
            return res;
        }


    }
