import java.awt.*;

public class Scania extends Car {


public double platformAngle;
Turbo t  = new Turbo();

public Scania(){
super(2, 162, 0 ,Color.white, "Scania Dump Truck", 0, 0, Direction.NORTH);
//turboOn = false;
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


    public double getPlatformAngle() {
        return 0;
    }


}