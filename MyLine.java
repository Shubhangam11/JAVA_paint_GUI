// Shubhangam Dutta - szd77
// Compsc 221 






package pa5;




import java.awt.*;



public class MyLine extends MyShape {



    private Point endPoint;



    public MyLine(Point p1, Point p2, Paint paint, BasicStroke stroke) {
    
	
	    super(p1, paint, stroke);
    
	
	    if (p2.getX() >= 0 && p2.getY() >= 0) {
            endPoint = p2;
    
	
	
	    } else {
            if (endPoint == null) {
                endPoint = new Point(0, 0);
            }
    
	
	    }
    }

    
	
	public Point getEndPoint() {
    
	
	    return endPoint;
    }

    public void setEndPoint(Point p) {
    
	
	    if (p.getX() >= 0 && p.getY() >= 0) {
            endPoint = p;
    
	
	    } else {
            if (endPoint == null) {
                endPoint = new Point(0, 0);
    
	
	        }
        }
    }

    
	@Override
    
	public void draw(Graphics2D g) {
        g.setPaint(getPaint());
        g.setStroke(getStroke());
        Point p1 = getStartPoint();
        Point p2 = getEndPoint();
        g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
    }
}
