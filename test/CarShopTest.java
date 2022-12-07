import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class CarShopTest {
    @Test
    public void calc_distance_test() {
        CarShop carShop = new CarShop(10, 10, 15.0, 2, 15, 15);

        Car car = new Saab95();

        assertTrue("Should be in distance", carShop.isInDistance(car));
    }

}
