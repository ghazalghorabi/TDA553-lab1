import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller
 * in it's state.
 * It communicates with the Controller by calling methods of it when an action
 * fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/
public class CarView extends JFrame {// denna är kvar
    private static final int X = 800;// 800
    private static final int Y = 400;
    // The controller member, denna ska vara i controller, där man har olika knappar
    // för olika situationer
    // vissa saker ska vara kvar ändå för illustration i programmet
    CarController carC;// controller
    DrawPanel drawPanel = new DrawPanel(X, Y - 240);
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas"); // GasController
    JButton brakeButton = new JButton("Brake"); // BrakeController
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, CarController cc) { // ??
        this.carC = cc;
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // vi ska rita knapparna i draw, för varje sorts knapp skapar vi en controller
    // klass och där har vi user input och att vi ritar upp varje knapp i den
    // klassen så till exempel brake för contollerbrake.
    // TODO: Take a good look and make sure you understand how these methods and
    // components work
    private void initComponents(String title) {// should stay :)
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        SpinnerModel spinnerModel = // GasAmount, i en egen controller ? vara i en egen klass, can contoller spinner
                                    // klass
                new SpinnerNumberModel(0, // initial value
                        0, // min
                        100, // max
                        1);// step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            } // ska vi koppla denna till gas i Car?
        });
        gasPanel.setLayout(new BorderLayout()); // draw
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton, 0); // GasController
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);// BrakeController
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200)); // delegera? metod för kodduplicering
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);// knappbakgrund
        startButton.setBackground(Color.green); // Färgens knapp
        startButton.setForeground(Color.BLACK);// färgens text
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200)); // delegera? metod för kodduplicering
        this.add(startButton);
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));// delegera? metod för kodduplicering
        this.add(stopButton);
        // This actionListener is for the gas button only!!!
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() { // listening for user input = CONTROLLER
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : carC.cars) {
                    try {
                        cc.gas(gasAmount); // GasController, skapa en liknande funktion för Brake
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });
        // the code below should perhaps stay in view??
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
/*
 * // This actionListener is for the gas button only
 * // TODO: Create more for each component as necessary
 * gasButton.addActionListener(new ActionListener() {
 * 
 * @Override
 * public void actionPerformed(ActionEvent e) {
 * carC.gas(gasAmount);
 * }
 * });
 */