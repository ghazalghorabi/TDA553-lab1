import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class SpinnerController {
    public int gasAmount = 0;
    JSpinner gasSpinner = new JSpinner();  
    
    
    public SpinnerController(){
    SpinnerModel spinnerModel = // GasAmount, i en egen controller ? vara i en egen klass, can contoller spinner
    // klass
    new SpinnerNumberModel(0, // initial value
    0, // min
    100, // max
    1);// step

    gasSpinner = new JSpinner(spinnerModel);
    
    gasSpinner.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) {
        gasAmount = (int) ((JSpinner) e.getSource()).getValue(); //actionperformed when we click a button getsource determines what button was clicked
    } // ska vi koppla denna till gas i Car?
});
    }}
