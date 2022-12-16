
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class Main {

    public static List<Car> cars;
    public static CarView view;
    public static final int delay = 50;
    private static Timer timer;

    public static void main(String[] args) {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();
        Scania car3 = new Scania();
        cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        CarController cc = new CarController();
        view = new CarView(cars);
        view.add(cc);

        timer = new Timer(delay, new TimerListener(view));

        for (Car car : cars) {
            if (car.equals(car2)) {
                System.out.println(car2.getmodelName());
            } else {
                System.out.println(car1.getmodelName());
            }
        }
        timer.start();

    }

}
