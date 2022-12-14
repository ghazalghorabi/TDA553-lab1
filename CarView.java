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
    public JButton stopButton;
    public JButton startButton;
    DrawPanel drawPanel = new DrawPanel(X, Y - 240);

    // public DrawPanel drawPanel;

    // Constructor
    public CarView(JPanel controlPanel) { // ??
        this.startButton = new JButton("START");
        this.stopButton = new JButton("STOP");

        this.setTitle("Amazing Pink Cars");
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200)); // delegera? metod för kodduplicering
        this.add(controlPanel);

        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200)); // delegera? metod för kodduplicering
        this.add(startButton);

        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));// delegera? metod för kodduplicering
        this.add(stopButton);

        controlPanel.setBackground(Color.CYAN);// knappbakgrund
        controlPanel.setLayout(new GridLayout(2, 4));


        startButton.setBackground(Color.green); // Färgens knapp
        startButton.setForeground(Color.BLACK);// färgens text

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);

        // This actionListener is for the gas button only!!!
        // TODO: Create more for each component as necessary

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();// view eller draw?
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
