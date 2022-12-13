
import java.util.ArrayList;
import java.util.Timer;
import java.awt.event.ActionEvent;
    //just tesing nothing important
public class Main {
    public static ArrayList<Car> cars;
    public static void main(String[] args) {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();
        Scania car3 = new Scania();
        CarTransporter car4 = new CarTransporter(null, 10, 0, 0);
        cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        //CarModel model = new CarModel(cars);
        CarController cc = new CarController();
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc); //VIEW
        for (Car car : cars){
            if (car.equals(car2)){
                System.out.println(car2.getmodelName());
            }else{
                System.out.println(car1.getmodelName());
            }
        }
}
}