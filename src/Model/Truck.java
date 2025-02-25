import java.awt.Color;

public class Truck extends Car {
Turbo t  = new Turbo();
Platform platform= new Platform(); 


public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xPos, int yPos, Direction currentcardirection) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, xPos, yPos, currentcardirection);
    }

    @Override
    public void move(){
        if(platform.getPlatformAngle() == 0 ){ 
            super.move();
        };
    }

    public void openPlatform(){
        platform.openPlatform(); 
    }
    public void closePlatform(){
        platform.closePlatform(); 
    }

    // raiseplatform , gas, move 
    public void raiseplatform(double platformAngle) throws Exception{
        if (platform.getPlatformAngle()> 0 && getCurrentSpeed()==0){  
            platform.openPlatform(); 
        }else if(getCurrentSpeed() > 0){
            throw new Exception("raising the platform is not possible");
        }

    
    }
    
    public void lowerplatform(double platformAngle) throws Exception{
        if (platform.getPlatformAngle()< 70 && getCurrentSpeed()==0){ 
            platform.closePlatform();  
        }else if(getCurrentSpeed() > 0){ 
            throw new Exception("lowering the platform is not possible");
        }
    }


    public double getPlatformAngle() {
        return platform.getPlatformAngle();
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
