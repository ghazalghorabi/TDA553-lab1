import java.util.Stack;

public class CarShop implements IContent {

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
    public double calcDistance(Car car) {
        int xDif = Math.abs(car.getxPos() - this.x); // Using Pythagoras to get DISTANCE from CarShop to car
        int yDif = Math.abs(car.getyPos() - this.y);

        double distance = Math.sqrt((yDif ^ 2) + (xDif ^ 2));

        return distance;

    }

    @Override
    public boolean isInDistance(Car car) {
        return calcDistance(car) <= this.radius;

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

        if (!isObjectfull() && isInDistance(car)) {
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

    @Override
    public boolean isObjectfull() {
        return amountOfCarsInShop.size() >= carAmount;
    }

    @Override
    public double radius() {
        return radius;
    }

}
