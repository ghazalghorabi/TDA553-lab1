
import java.awt.*;

public class Saab95 extends Car{
   Turbo t  = new Turbo();
    
    public Saab95(){
        super(2, 125, 0 ,Color.red, "Saab95", 50, 50, Direction.WEST);
        speedFactor();
    }


    public void setTurboOn(){
	    t.setTurboOn();
    }

    public void setTurboOff(){
	    t.setTurboOff();
    }
    
    protected double speedFactor(){ 
        return getEnginePower() * 0.01 * t.turbofactor();
    }

}
