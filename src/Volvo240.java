
import java.awt.*;

public class Volvo240 extends Car{

    public final static double trimFactor = 1.25; //satisfied with having trim here, instead of in a own class.
    
    public Volvo240(){
        super(4, 100, 0 ,Color.black, "Volvo240", 0, 0, Direction.EAST);
    }
    
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
