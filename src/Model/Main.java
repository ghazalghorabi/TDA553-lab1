

import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    //just tesing nothing important
public class Main {

    
    public static List<Car> cars;
    public static CarView view;
    public static final int delay=50;
    private static Timer timer;

    public static void main(String[] args) {
        Saab95 car1 = new Saab95();
        Volvo240 car2 = new Volvo240();
        Scania car3 = new Scania();
        cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        
        //CarModel model = new CarModel(cars);
        CarController cc = new CarController();
        //cc.initComponents("hej");

        // Start a new view and send a reference of self
        //cc.frame = 
        view = new CarView(cars); //VIEW
        view.add(cc);

        timer = new Timer(delay,new TimerListener());
      
        
        for (Car car : cars){
            if (car.equals(car2)){
                System.out.println(car2.getmodelName());
            }else{
                System.out.println(car1.getmodelName());
            }
        }
        timer.start();
        

}

public static class TimerListener implements ActionListener {
    private DrawPanel drawPanel = view.drawPanel;

    public void actionPerformed(ActionEvent e) { // user input (actionlistner "button")
            for (Car car : Main.cars) {
                int x = (int) Math.round(car.getXPos());// VIEW visar vart bilarna är
                int y = (int) Math.round(car.getYPos());
                car.move();
                //drawPanel.moveit(car, x, y);
                //repaint() calls the paintComponent method of the panel
                drawPanel.repaint();  
            }
        }
    }

}


