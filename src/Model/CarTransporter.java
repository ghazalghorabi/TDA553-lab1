

import java.awt.Color;
import java.util.*;

public class CarTransporter extends Truck implements IContent, IDistance {
    Loading l = new Loading();
    Distance d = new Distance();

    Platform platform;
    private Stack<Car> loadedCars;
    private double radius;
    private int carAmount;
    private int unloadAreaX;
    private int unloadAreaY;

    public CarTransporter(Stack<Car> loadedCars, double radius, int carAmount, int unloadAreaX, int unloadAreaY) {
        super(2, 110, 0, Color.BLUE, "car transporter", 0, 0, Direction.NORTH);

        this.radius = radius;
        this.loadedCars = loadedCars;
        this.platform = new Platform();
        this.carAmount = carAmount;
        this.unloadAreaX = unloadAreaX;
        this.unloadAreaY = unloadAreaY;

    }

    private void SetCaramount(Car carToLoad) {
        loadedCars.push(carToLoad);
    }

    public int GetCaramount(Stack<Car> loadedCars) {
        return loadedCars.size();
    }

    public void openPlatform() {
        platform.setPlatformAngle(platform.maxAngle);
    }

    public void closePlatform() {
        platform.setPlatformAngle(platform.minAngle);
    }

    public void move(Stack<Car> loadcarslist) {
        for (Car car : loadcarslist) {
            car.setxPos(xPos);
            car.setyPos(yPos);
        }
    }

    public void loadCars(Car carToLoad) {
        if (platform.getPlatformAngle() == platform.maxAngle && !isObjectfull() && isInDistance(carToLoad)) {
            SetCaramount(carToLoad);
        } else {
            throw new IllegalArgumentException("Unable to load carTransporter");

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
    public void unloadCar() {
        if (platform.getPlatformAngle() == platform.maxAngle){
            ;
        Car carToUnload = loadedCars.pop();
        carToUnload.xPos = unloadAreaX;
        carToUnload.yPos = unloadAreaY;
        }
    }

    public boolean isInDistance(Car car) {
        return d.isInDistance(this, car);
    }

    public boolean isObjectfull() {
        return l.isObjectfull(this);
    }

    @Override
    public double radius() {
        return this.radius;
    }

    @Override
    public int amountOfCars() {
        return loadedCars.size();
    }

    @Override
    public int getMaxCarAmount() {
        return carAmount;
    }
}
