import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GasController {

    public int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas"); //GasController
    
    public JPanel gasPanel = new JPanel(); 
    JSpinner gasSpinner = new JSpinner();

    public GasController(){
        gasPanel.setLayout(new BorderLayout()); // draw
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        gasPanel.add(gasButton, 0); 


    
    }
    
    
}
