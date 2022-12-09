
import java.util.ArrayList;
import java.util.List;
    //just tesing nothing important
public class Main {
    public static ArrayList<Car> cars;
    public static void main(String[] args) {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();
        Scania car3 = new Scania();
        CarTransporter car4 = new CarTransporter(null, 10);

        cars = new ArrayList<Car>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        
        for (Car car : cars){
            if (car.equals(car2)){
                System.out.println(car2.getmodelName());
            }else{
                System.out.println(car1.getmodelName());
            }
        }
        
}}
