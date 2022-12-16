import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

//Single responsibility princible: ha allt som handlar om controller här

public class CarController extends JPanel {// denna är kvar
    private BrakeController brakeController = new BrakeController();
    private GasController gasController = new GasController();
    private SpinnerController gasSpinner = new SpinnerController();

    //private JPanel gasPanel = new JPanel();
    private static JPanel controlPanel = new JPanel();
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");
    private static JButton startButton = new JButton("START");
    private static JButton stopButton = new JButton("STOP");

    public CarController( ){
        
       // this.controlPanel = controlPanel;
        this.turboOnButton= turboOnButton;
        this.turboOffButton= turboOffButton;
        this.liftBedButton = liftBedButton;
        this.lowerBedButton = lowerBedButton;
        this.startButton = startButton;
        this.stopButton = stopButton;
        initComponents("hej");
    }
    private static final int X = 800;// 800
    //CarView frame; // en frame för controller

   
    // la till:
    

    private void initComponents(String title) {// should stay :)

        controlPanel.add(gasController.getGaspanel(), 0); // GasController
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
       // controlPanel.add(brakeController.brakebutton, 3);// BrakeController
        controlPanel.add(turboOffButton, 3);
        controlPanel.add(lowerBedButton, 4);
        controlPanel.add(gasSpinner, BorderLayout.PAGE_END);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200)); // delegera? metod för kodduplicering
        add(controlPanel);

        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200)); // delegera? metod för kodduplicering
        add(startButton);

        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));// delegera? metod för kodduplicering
        add(stopButton);

        controlPanel.setBackground(Color.CYAN);// knappbakgrund
        controlPanel.setLayout(new GridLayout(2, 4));

        startButton.setBackground(Color.green); // Färgens knapp
        startButton.setForeground(Color.BLACK);// färgens text

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);

        
    }
}
