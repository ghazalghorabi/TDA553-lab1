import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GasController {

    private int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");
    private JButton gasButton = new JButton("Gas"); 
    
    private JPanel gasPanel = new JPanel(); 
    private JSpinner gasSpinner = new SpinnerController();
    private static double updatedGas;

    public GasController(){
        initialize();
    }

    private void initialize(){
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e ) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : Main.cars) {
                    try {
                        cc.gas(gasAmount / 100);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
       });

        gasPanel.setLayout(new BorderLayout()); 
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
    

        gasPanel.add(gasButton, 0); 
        
    }

    public static double getUpdatedGas() {
        return updatedGas;
    }


    public JPanel getGaspanel(){
        return gasPanel;
    }

    public void updateGasAmount(int amount, double updatedGas) throws Exception { 
        updatedGas = ((double) amount) / 100;
    }

}