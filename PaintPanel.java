// Shubhangam Dutta - szd77
// Compsc 221 













package pa5;





import java.awt.*;


import java.awt.event.MouseAdapter;


import java.awt.event.MouseEvent;


import java.util.ArrayList;


import javax.swing.*;

public class PaintPanel extends JPanel {



    private ArrayList<MyShape> shapeArrayList;


    private String shapeType;


    private boolean isFilled;


    private boolean useGradient;


    private Color color1;


    private Color color2;


    private int lineWidth;



    private int dashLength;


    private boolean isDashed;

    public PaintPanel() {
        shapeArrayList = new ArrayList<>();
        shapeType = "Line";
        isFilled = false;
        useGradient = false;
        color1 = Color.BLACK;
        color2 = Color.RED;
        lineWidth = 5;
        dashLength = 10;
        isDashed = false;
        MouseTracker mt = new MouseTracker();
        addMouseMotionListener(mt);
        addMouseListener(mt);
    }

    public void undo() {
        if (shapeArrayList.size() > 0) {
            shapeArrayList.remove(shapeArrayList.size() - 1);
        }
        repaint();
    }

    public void clear() {
        shapeArrayList.clear();
        repaint();
    }

    @Override


    public void paintComponent(Graphics g) {


        super.paintComponent(g);


        this.setBackground(Color.WHITE);

        Graphics2D g2d = (Graphics2D) g.create();
        for (MyShape s : shapeArrayList) {
            s.draw(g2d);
        }
        g2d.dispose();
    }





    private class MouseTracker extends MouseAdapter {



        @Override


        public void mousePressed(MouseEvent me) {


            Point p1 = me.getPoint();


            Point p2 = new Point((int) p1.getX() + 15, (int) p1.getY() + 15); // Used for gradient pattern


            Paint paint;


            if (useGradient()) {
                paint = new GradientPaint(p1, getColor1(), p2, getColor2(), true);
            } else {
                paint = getColor1();
            }



            BasicStroke stroke;
            if (isDashed()) {
                stroke = new BasicStroke(getLineWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, new float[]{getDashLength()}, 0);
            } else {
                stroke = new BasicStroke(getLineWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            }




            MyShape shape;
            switch (getShapeType().toUpperCase()) {
                


                case "LINE":
                    shape = new MyLine(p1, p1, paint, stroke);
                    break;
                case "OVAL":
                    shape = new MyOval(p1, p1, isFilled(), paint, stroke);
                    break;
                case "RECTANGLE":
                    shape = new MyRectangle(p1, p1, isFilled(), paint, stroke);
                    break;
                default: // Default to a line
                    shape = new MyLine(p1, p1, paint, stroke);
            }
            shapeArrayList.add(shape);
            repaint();
        }



        @Override
        public void mouseReleased(MouseEvent me) {
            repaint();
        }






        @Override
        public void mouseDragged(MouseEvent me) {
            int lastIndex = shapeArrayList.size() - 1;
            if (lastIndex >= 0) {
                MyShape currentShape = shapeArrayList.get(lastIndex);
                if (currentShape instanceof MyLine) {
                    ((MyLine) currentShape).setEndPoint(me.getPoint());
                } else {
                    ((MyBoundedShape) currentShape).setHeightAndWidth(me.getPoint());
                }
            }
            repaint();
        }





        @Override
        public void mouseMoved(MouseEvent me) {
            
            ((Hw5Frame) SwingUtilities.windowForComponent(PaintPanel.this)).setMouseLocationLabel(me.getX(), me.getY());
        }
    }

    
    
    String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    boolean useGradient() {
        return useGradient;
    }

    public void setUseGradient(boolean useGradient) {
        this.useGradient = useGradient;
    }

    Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    int getDashLength() {
        return dashLength;
    }

    public void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }

    boolean isDashed() {
        return isDashed;
    }

    public void setDashed(boolean dashed) {
        isDashed = dashed;
    }
}
