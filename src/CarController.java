import javax.swing.*;

import java.awt.*;

public class CarController extends JPanel {
    private BrakeController brakeController = new BrakeController();
    private GasController gasController = new GasController();

    private static JPanel controlPanel = new JPanel();
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");
    private static JButton startButton = new JButton("START");
    private static JButton stopButton = new JButton("STOP");

    public CarController() {

        initComponents("ButtonDisplay");
    }

    private static final int X = 800;

    private void initComponents(String title) {

        controlPanel.add(gasController.getGaspanel(), 0); 
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeController.getbrakeButton(), 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
        controlPanel.setLayout(new GridLayout(2, 4));

        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        add(startButton);
        startButton.setBackground(Color.green); 
        startButton.setForeground(Color.BLACK);

        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        add(stopButton);
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);

    }
}
