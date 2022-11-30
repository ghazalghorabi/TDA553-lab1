
import java.awt.*;

public abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int xPos; // startposition x värdet
    private int yPos; // startposition y värdet
    private Direction currentcardirection; // the car's current direction

    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, int xPos, int yPos,
            Direction currentcardirection) {
        this.nrDoors = nrDoors; // Number of doors on the car
        this.enginePower = enginePower; // Engine power of the car
        this.currentSpeed = currentSpeed; // The current speed of the car
        this.color = color; // Color of the car
        this.modelName = modelName; // The car model name
        this.xPos = xPos; // the car's x position
        this.yPos = yPos; // the car's y position
        this.currentcardirection = currentcardirection; // startvärdet
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    private void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public String getmodelName() {
        return modelName;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void gas(double amount) throws Exception {
        if (amount >= 0 && amount <= 1) { // gas only accepts values in the interval [0,1]
            incrementSpeed(amount);
        } else { // else error message
            throw new Exception("the amount is not in the interval");
        }
    }

    private void incrementSpeed(double amount) { // the min and max speed interval while gasing
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    public void brake(double amount) throws Exception {
        if (amount >= 0 && amount <= 1) { // brake only accepts values in the interval [0,1]
            decrementSpeed(amount);
        } else { // else error message
            throw new Exception("the amount is not in the interval");
        }

    }

    private void decrementSpeed(double amount) { // the max and min speed interval while braking
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /*public void setcurrentdirection(Direction currentcarDirection){
        this.currentcardirection = currentcardirection;
    }*/

    public Direction getcurrentcardirection() {
        return currentcardirection;
    }

    protected abstract double speedFactor();

    @Override
    public void move() {
        if (currentcardirection == Direction.NORTH) {
            yPos -= 1;
        } else if (currentcardirection == Direction.SOUTH) {
            yPos += 1;
        } else if (currentcardirection == Direction.WEST) {
            xPos += 1;
        } else if (currentcardirection == Direction.EAST) {
            xPos -= 1;
        }

    }

    public void turnLeft() {
        if (currentcardirection == Direction.NORTH) {
            currentcardirection = Direction.WEST;
        } else if (currentcardirection == Direction.WEST) {
            currentcardirection = Direction.SOUTH;
        } else if (currentcardirection == Direction.SOUTH) {
            currentcardirection = Direction.EAST;
        } else if (currentcardirection == Direction.EAST) {
            currentcardirection = Direction.NORTH;
        }
    }

    public void turnRight() {
        if (currentcardirection == Direction.NORTH) {
            currentcardirection = Direction.EAST;
        } else if (currentcardirection == Direction.EAST) {
            currentcardirection = Direction.SOUTH;
        } else if (currentcardirection == Direction.SOUTH) {
            currentcardirection = Direction.WEST;
        } else if (currentcardirection == Direction.WEST) {
            currentcardirection = Direction.NORTH;
        }

    }

}
