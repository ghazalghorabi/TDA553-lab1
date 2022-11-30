
import java.util.ArrayList;
import java.util.List;
    //just tesing nothing important
public class Main {
    public static void main(String[] args) {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();

        List<Car> cars = new ArrayList();

        cars.add(car1);
        cars.add(car2);
        
        for (Car car : cars){
            if (car.equals(car2)){
                System.out.println(car2.getmodelName());
            }else{
                System.out.println(car1.getmodelName());
            }
        }
        
}}
