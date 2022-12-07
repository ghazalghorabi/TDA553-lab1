public interface IContent {
    
    public int getXPos();

    public int getYPos();

    public double calcDistance(Car car);

    public double radius();

    public void loadCars(Car car);

    public void unloadCar();

    public boolean isInDistance(Car car);

    public boolean isObjectfull();
    
}
