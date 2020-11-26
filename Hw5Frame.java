// Shubhangam Dutta - szd77
// Compsc 221 









package pa5;






import java.awt.*;







import javax.swing.*;










public class Hw5Frame extends JFrame {

    private final JButton undo;


    private final JButton clear;


    private final JLabel shapeLabel;


    private final JComboBox shapes;


    private final JCheckBox filled;


    private final JCheckBox gradient;


    private final JButton color1;


    private final JButton color2;


    private final JLabel strokeWidthLabel;


    private final JTextField strokeWidth;


    private final JLabel dashLengthLabel;


    private final JTextField dashLength;


    private final JCheckBox dashed;


    private final PaintPanel drawPanel;

    private final JLabel mouseLocation;

    public Hw5Frame(String title) {
        super(title);
        
        setPreferredSize(new Dimension(800, 600));


        Container pane = getContentPane();


        Container topPanel = new Container();


        topPanel.setLayout(new BorderLayout());


        Container rowLine1 = new Container(); //  GUI elements in 1st
        rowLine1.setLayout(new FlowLayout());


        Container rowLine2 = new Container(); // GUI elements in the 2nd
        rowLine2.setLayout(new FlowLayout());
        
        
        drawPanel = new PaintPanel();


        pane.add(drawPanel, BorderLayout.CENTER);
        
        undo = new JButton("Undo");


        rowLine1.add(undo);


        clear = new JButton("Clear");


        rowLine1.add(clear);


        shapeLabel = new JLabel("Shape:");


        rowLine1.add(shapeLabel);


        shapes = new JComboBox(new String[]{"Line", "Oval", "Rectangle"});


        shapes.setSelectedItem(drawPanel.getShapeType());


        rowLine1.add(shapes);


        filled = new JCheckBox("Filled");


        filled.setSelected(drawPanel.isFilled());


        rowLine1.add(filled);


        gradient = new JCheckBox("Use Gradient");


        gradient.setSelected(drawPanel.useGradient());


        rowLine2.add(gradient);


        color1 = new JButton("1st Color...");


        rowLine2.add(color1);


        color2 = new JButton("2nd Color...");


        rowLine2.add(color2);

        strokeWidthLabel = new JLabel("Line Width:");


        rowLine2.add(strokeWidthLabel);


        strokeWidth = new JTextField(String.format("%d", drawPanel.getLineWidth()), 2);


        rowLine2.add(strokeWidth);


        dashLengthLabel = new JLabel("Dash Length:");


        rowLine2.add(dashLengthLabel);


        dashLength = new JTextField(String.format("%d", drawPanel.getDashLength()), 2);


        rowLine2.add(dashLength);


        dashed = new JCheckBox("Dashed");


        dashed.setSelected(drawPanel.isDashed());


        rowLine2.add(dashed);


        topPanel.add(rowLine1, BorderLayout.PAGE_START); // PAGE_START is equivalent to NORTH


        topPanel.add(rowLine2, BorderLayout.PAGE_END); // PAGE_END is equivalent to SOUTH
        pane.add(topPanel, BorderLayout.PAGE_START);

        mouseLocation = new JLabel("Test");
        pane.add(mouseLocation, BorderLayout.PAGE_END); // PAGE_END is like SOUTH




        undo.addActionListener(ae -> drawPanel.undo());
        clear.addActionListener(ae -> drawPanel.clear());
        shapes.addActionListener((ae) -> {
            JComboBox cb = (JComboBox) ae.getSource();
            drawPanel.setShapeType((String) cb.getSelectedItem());
        });
        filled.addActionListener(ae -> drawPanel.setFilled(((JCheckBox) ae.getSource()).isSelected()));
        filled.setSelected(false);
        gradient.addActionListener(ae -> drawPanel.setUseGradient(((JCheckBox) ae.getSource()).isSelected()));
        color1.addActionListener(ae -> {
            Color color = drawPanel.getColor1();
            color = JColorChooser.showDialog(this, "Choose a color", color);
            if (color != null) {
                drawPanel.setColor1(color);
            }
        });
        color2.addActionListener(ae -> {
            Color color = drawPanel.getColor2();
            color = JColorChooser.showDialog(this, "Choose a color", color);
            if (color != null) {
                drawPanel.setColor2(color);
            }
        });

        strokeWidth.addActionListener(ae -> drawPanel.setLineWidth(Integer.parseInt(((JTextField) ae.getSource()).getText())));

        dashLength.addActionListener(ae -> drawPanel.setDashLength(Integer.parseInt(((JTextField) ae.getSource()).getText())));

        dashed.addActionListener(ae -> drawPanel.setDashed(((JCheckBox) ae.getSource()).isSelected()));
    }

    void setMouseLocationLabel(int x, int y) {
        mouseLocation.setText(String.format("(%d, %d)", x, y));
    }

    private static void createAndShowGui() {

        Hw5Frame frame = new Hw5Frame("Java 2D Drawings");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Start GUI on event dispatch thread
        SwingUtilities.invokeLater(() -> Hw5Frame.createAndShowGui());
    }
}
