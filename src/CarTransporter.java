import java.awt.Color;
import java.util.*; 

public class CarTransporter extends Truck implements IContent{
    
    Platform platform;
    private Stack<Car> loadedCars;
    private double radius;
    private int carAmount;

    

    public CarTransporter(Stack<Car> loadedCars, double radius) {
        super(2, 110, 0, Color.BLUE, "car transporter", 0, 0, Direction.NORTH);
        
        this.radius = radius;
        this.loadedCars = loadedCars;
        this.platform = new Platform();
        this.carAmount = 2; //this never changes, changed this to 2 on purpose!
        

        
    }

    private void SetCaramount(Car carToLoad){
        loadedCars.push(carToLoad);
    }
    
    public int GetCaramount(Stack<Car> loadedCars){
        return loadedCars.size();
    }

    public void openPlatform() {
        platform.setPlatformAngle(platform.maxAngle);
    }

    public void closePlatform() { 
        platform.setPlatformAngle(platform.minAngle); 
    }

    public void move(Stack<Car> loadcarslist){
        for (Car car : loadcarslist) {
            car.setxPos(xPos);
            car.setyPos(yPos);
        }
    }

    public void loadCars(Car carToLoad) {
        if (platform.getPlatformAngle() == platform.maxAngle && !isObjectfull() && isInDistance(carToLoad)) {
                   SetCaramount(carToLoad);
        }
        else{throw new IllegalArgumentException("Unable to load carTransporter");

        }
    }
   
    @Override
    public int getXPos() {
        
        return xPos;
    }

    @Override
    public int getYPos() {
     
        return yPos;
    }

    @Override
    public double calcDistance(Car car) {
        int xDif = Math.abs(car.getxPos() - this.xPos); // Using Pythagoras to get DISTANCE from CarShop to car
        int yDif = Math.abs(car.getyPos() - this.yPos);

        double distance = Math.sqrt((yDif ^ 2) + (xDif ^ 2));

        return distance;
    }

    
    @Override
    public void unloadCar() {
        if (platform.getPlatformAngle() == platform.maxAngle);
        
    }

    @Override
    public boolean isInDistance(Car car) {
        return calcDistance(car) <= this.radius;
    }

    @Override
    public boolean isObjectfull() {
        return loadedCars.size() >= carAmount;
    }

    @Override
    public double radius() {
        return this.radius;
    }
}
