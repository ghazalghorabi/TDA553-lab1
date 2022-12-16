import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GasController {

    private int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");
    private JButton gasButton = new JButton("Gas"); //GasController
    
    private JPanel gasPanel = new JPanel(); 
    private JSpinner gasSpinner = new JSpinner();
    private double updatedGas;

    public GasController(){
        initialize();
   
    }
   
	public void actionListener() {
       gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : Main.cars) {
                    try {
                        cc.gas(gasAmount);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
       });}

    private void initialize(){
    
        gasPanel.setLayout(new BorderLayout()); // draw
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        gasPanel.add(gasButton, 0); 
        
    }
    

    //public GasController(int updatedGas) {
      //  this.gasAmount = updatedGas;   }


    public double getUpdatedGas() {
        return updatedGas;
    }

    public void SetGaspanel(){
        this.gasPanel= gasPanel;
    }

    public JPanel getGaspanel(){
        return gasPanel;
    }

    public void setUpdatedGas(double updatedGas) {
        this.updatedGas = updatedGas;
    }



    // Calls the gas method for each car once
    public void updateGasAmount(int amount, double updatedGas) throws Exception { 
        updatedGas = ((double) amount) / 100;
    }

}