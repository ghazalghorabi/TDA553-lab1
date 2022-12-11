public class Distance {
    public double calcDistance(IDistance n, Car m) {
        int xDif = Math.abs(m.getXPos() - n.getXPos()); // Using Pythagoras to get DISTANCE from CarShop to car
        int yDif = Math.abs(m.getYPos() - n.getYPos()); // different x and y in carshop + cartransporter

        double distance = Math.sqrt((yDif ^ 2) + (xDif ^ 2));

        return distance;

    }

    public boolean isInDistance(IDistance n, Car m) {
        return calcDistance(n, m) <= n.radius(); // same radius for both cartransporter+ carshop

    }
}
