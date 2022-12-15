import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

//Single responsibility princible: ha allt som handlar om controller här

public class CarController extends JPanel {// denna är kvar

    private static final int X = 800;// 800
    CarView frame; // en frame för controller

    BrakeController brakeController = new BrakeController();
    GasController gasController = new GasController();
    SpinnerController gasSpinner = new SpinnerController();

    JPanel gasPanel = new JPanel();
    static JPanel controlPanel = new JPanel();
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    static JButton startButton = new JButton("START");
    static JButton stopButton = new JButton("STOP");

    // la till:
    public void actionListener() {
        gasController.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : Main.cars) {
                    try {
                        cc.gas(gasController.gasAmount);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        brakeController.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : Main.cars) {
                    try {
                        cc.brake(brakeController.brakeAmount);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public void initComponents(String title) {// should stay :)

        controlPanel.add(gasController.gasButton, 0); // GasController
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeController.brakeButton, 3);// BrakeController
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(gasSpinner, BorderLayout.PAGE_END);

    }

    public CarController() {
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
