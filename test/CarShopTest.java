import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarShopTest {
    @Test
    public void calc_distance_test() {
        CarShop carShop = new CarShop(10, 10, 15.0, 2, 15, 15);

        Car car = new Saab95();

        assertTrue("Should be in distance", carShop.isInDistance(car));
    }

    @Test
    public void loadCar_should_increase_list_test() {
        CarShop carShop = new CarShop(10, 10, 15.0, 2, 15, 15);
        Car car = new Volvo240();

        carShop.loadCars(car);

        assertEquals(1, carShop.amountOfCars());
    }

    @Test
    public void loadCar_should_decrease_list_test() {
        CarShop carShop = new CarShop(10, 10, 15.0, 2, 15, 15);
        Car car = new Volvo240();

        carShop.loadCars(car);

        carShop.unloadCar();

        assertEquals(0, carShop.amountOfCars());
    }
}
