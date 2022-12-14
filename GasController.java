import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasController {

    public int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas"); // GasController

    

    public GasController(int updatedGas) {
        this.gasAmount = updatedGas;
        
    }


    // Calls the gas method for each car once
    public void updateGasAmount(int amount) throws Exception { 
        double updatedGas = ((double) amount) / 100;
    }


}