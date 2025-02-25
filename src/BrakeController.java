import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BrakeController {
    private int brakeAmount = 0;
    private JButton brakeButton = new JButton("Brake"); 

    public BrakeController(){
        initialize();
    }

    private void initialize(){

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : Main.cars) {
                    try {
                        cc.brake(brakeAmount);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }

    public JButton getbrakeButton() {
        return brakeButton;
    }
}
