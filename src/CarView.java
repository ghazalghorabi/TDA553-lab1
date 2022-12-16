import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CarView extends JFrame {
    // The controller member, denna ska vara i controller, där man har olika knappar
    // för olika situationer
    // vissa saker ska vara kvar ändå för illustration i programmet
    private static final int X = 800;// 800
    private static final int Y = 400;
    public DrawPanel drawPanel;

    // Constructor
    public CarView(List<Car> cars) { // Dependency injection

        this.drawPanel = new DrawPanel(cars, X, Y - 240);
        setTitle("Amazing Cars");
        setPreferredSize(new Dimension(X, Y));
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        add(drawPanel);

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
