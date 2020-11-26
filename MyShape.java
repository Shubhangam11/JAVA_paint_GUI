// Shubhangam Dutta - szd77
// Compsc 221 









package pa5;




import java.awt.*;




public abstract class MyShape {


    private Point startPoint;


    private Paint paint;


    private BasicStroke stroke;



    public MyShape(Point p1, Paint paint, BasicStroke stroke) {


        startPoint = p1;

        this.paint = paint;

        this.stroke = stroke;
    }


    public abstract void draw(Graphics2D g);


    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point p) {

        if (p.getX() >= 0 && p.getY() >= 0) {


            startPoint = p;
        } else {
            if (startPoint == null) {
                startPoint = new Point(0, 0); // Initialize Point if not already initialized
            }
        }
    }

    public Paint getPaint() {

        return paint;
    }

    public void setPaint(Paint paint) {

        this.paint = paint;
    }

    public BasicStroke getStroke() {

        return stroke;
    }

    public void setStroke(BasicStroke stroke) {


        this.stroke = stroke;
    }
}
