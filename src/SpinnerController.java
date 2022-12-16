import javax.swing.*;


public class SpinnerController extends JSpinner{
    // Subscriber subscriber = new Subscriber();
    public int gasAmount = 0;

    public SpinnerController() {
        super(new SpinnerNumberModel(0,0,100,1));
        
    }
    public int getGasValue(){
        return(int)(getValue());
    }
}
