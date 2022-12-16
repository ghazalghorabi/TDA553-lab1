import javax.swing.*;
import java.awt.*;

/**
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/
public class CarView extends JFrame {
    // The controller member, denna ska vara i controller, där man har olika knappar
    // för olika situationer
    // vissa saker ska vara kvar ändå för illustration i programmet
    private static final int X = 800;// 800
    private static final int Y = 400;
    public JPanel panel;

    DrawPanel drawPanel = new DrawPanel(X, Y - 240);

    // public DrawPanel drawPanel;

    // Constructor
    public CarView() { // ??

        setTitle("Amazing Cars");
        setPreferredSize(new Dimension(X, Y));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(drawPanel);
       // add(controller);
       // add(CarController.startButton);
        //add(CarController.stopButton);
        

        // This actionListener is for the gas button only!!!
        // TODO: Create more for each component as necessary

        // Make the frame pack all it's components by respecting the sizes if possible.
        pack();// view eller draw?
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        // Make the frame visible
        setVisible(true);
        // Make sure the frame exits when "x" is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
