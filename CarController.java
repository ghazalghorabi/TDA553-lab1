import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


//Single responsibility princible: ha allt som handlar om controller här


public class CarController extends JFrame {// denna är kvar
    private static final int X = 800;// 800
    private static final int Y = 400;
    CarView frame; // en frame för controller
    BrakeController brakeController = new BrakeController();
    GasController gasController = new GasController();

    

    JPanel gasPanel = new JPanel();
    DrawPanel drawPanel = new DrawPanel(X, Y - 240);
    JPanel controlPanel = new JPanel();
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

   

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
    

    private void initComponents(String title) {// should stay :)
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        
      
   
    controlPanel.setLayout(new GridLayout(2, 4));
    controlPanel.add(gasController.gasButton, 0); // GasController
    controlPanel.add(turboOnButton, 1);
    controlPanel.add(liftBedButton, 2);
    controlPanel.add(brakeController.brakeButton, 3);// BrakeController
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
    gasPanel.setLayout(new BorderLayout()); // draw
      
    gasPanel.add(gasController.gasLabel, BorderLayout.PAGE_START);

    gasPanel.add(gasController.gasButton, 0);
    gasPanel.setLayout(new BorderLayout()); // draw
    gasPanel.add(gasController.gasLabel, BorderLayout.PAGE_START);
    gasPanel.add(gasSpinner, BorderLayout.PAGE_END); // view 
    gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

}
}