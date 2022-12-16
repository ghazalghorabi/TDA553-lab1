
import java.util.Stack;



public class CarShop implements IContent, IDistance { 

Loading l = new Loading();
Distance d = new Distance();

    private Stack<Car> amountOfCarsInShop; // Stack of loaded cars
    private int x; // X position for carshop
    private int y; // Y position for carshop
    private double radius; // Radius to check if cars are reasonably close
    private final int carAmount; // How many cars that can max be in shop

    private int unloadAreaX; // x position for unloading area, dont want to unload the cars on top of each
                             // other
    private int unloadAreaY; // y position for unloading area

    public CarShop(int x, int y, double radius, int carAmount, int unloadAreaX, int unloadAreaY) {
        this.x = y;
        this.y = y;
        this.radius = radius;
        this.carAmount = carAmount;
        this.unloadAreaX = unloadAreaX;
        this.unloadAreaY = unloadAreaY;
        this.amountOfCarsInShop = new Stack<Car>();
    }

    @Override
    public int getXPos() {
        return x;
    }

    @Override
    public int getYPos() {
        return y;
    }



    @Override
    public void unloadCar() {
        Car carToUnload = amountOfCarsInShop.pop();
        carToUnload.xPos = unloadAreaX;
        carToUnload.yPos = unloadAreaY;
    }

    @Override
    public void loadCars(Car car) {
        // if carshop is not full and car is in reasonable distance, then we CAN load

        if (!isObjectfull() && d.isInDistance(this, car)) {
            car.xPos = this.x;
            car.yPos = this.y;
            amountOfCarsInShop.push(car);
        }
    }

    public Stack<Car> getCarsInShop() {
        return amountOfCarsInShop;
    }

    public int amountOfCars() { // Current amount of cars in shop
        return amountOfCarsInShop.size();
    }

    public int getMaxCarAmount() { // Current amount of cars in shop
        return carAmount;
    }

    public boolean isInDistance(Car car) {
        return d.isInDistance(this, car);
    }

    public boolean isObjectfull() {
        return l.isObjectfull(this);
    }

    @Override
    public double radius() {
        return radius;
    }

}
