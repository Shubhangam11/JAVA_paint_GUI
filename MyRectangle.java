// Shubhangam Dutta - szd77
// Compsc 221 







package pa5;



import java.awt.*;



public class MyRectangle extends MyBoundedShape {



    public MyRectangle(Point p1, Point p2, boolean isFilled, Paint paint, BasicStroke stroke) {


        super(p1, p2, isFilled, paint, stroke);
    }

    @Override


    public void draw(Graphics2D g) {


        g.setPaint(getPaint());


        g.setStroke(getStroke());


        int[] drawParam = getDrawParameters();


        if (isFilled()) {
            g.fillRect(drawParam[0], drawParam[1], drawParam[2], drawParam[3]);
        } else {
            g.drawRect(drawParam[0], drawParam[1], drawParam[2], drawParam[3]);
        }
    }
}
