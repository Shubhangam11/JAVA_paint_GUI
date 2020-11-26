// Shubhangam Dutta - szd77
// Compsc 221 





package pa5;




import java.awt.*;




public abstract class MyBoundedShape extends MyShape {





    private int width;


    private int height;
    
	
	private boolean isFilled;

    public MyBoundedShape(Point p1, Point p2, boolean isFilled, Paint paint, BasicStroke stroke) {
        
		super(p1, paint, stroke);
        
		if (p2 != null) {
            
            
            width = (int) (p2.getX() - p1.getX());
            height = (int) (p2.getY() - p1.getY());
        }
        this.isFilled = isFilled;
    }

    public int getWidth() {
    
	
	    return width;
    }



    public void setWidth(int width) {
    
	    this.width = width;
    
	}

    public int getHeight() {
    
	
	    return height;
    }

    public void setHeight(int height) {
    
	
	    this.height = height;
    }

    public boolean isFilled() {
    
	
	    return isFilled;
    }

    public void setFilled(boolean filled) {
    
	
	    isFilled = filled;
    }

    public void setHeightAndWidth(Point p) {
    
	
	    if (p != null) {
            
            
            setWidth((int) (p.getX() - getStartPoint().getX()));
            
			
			setHeight((int) (p.getY() - getStartPoint().getY()));
        }
    }

    protected int[] getDrawParameters() {
        
		Point p1;
        
		
		int w = getWidth();
        
		
		int h = getHeight();
        
		
		if (w < 0 && h < 0) {
            
            p1 = new Point((int) getStartPoint().getX() + w, (int) getStartPoint().getY() + h);
            
			w = w * -1;
            
			h = h * -1;
        } else if (w < 0) {
           
		    p1 = new Point((int) getStartPoint().getX() + w, (int) getStartPoint().getY());
            
			w = w * -1;
        } else if (h < 0) {
            
			p1 = new Point((int) getStartPoint().getX(), (int) getStartPoint().getY() + h);
            
			h = h * -1;
        } else {
            
			
			p1 = getStartPoint();
        }
        return new int[]{(int) p1.getX(), (int) p1.getY(), w, h};
    }
}
