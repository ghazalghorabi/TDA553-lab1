import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    public static ArrayList<Car> cars = new ArrayList<>(); //app / main

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50; //Timer stuff -> model
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener()); //more timer stuff

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    CarView frame; //VIEW
    //cars = new ArrayList<Car>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc); //VIEW

        // Start the timer
        cc.timer.start(); //timer, should NOT be in controller
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener { //
        public void actionPerformed(ActionEvent e) { //user input (actionlistner "button")
            for (Car car : cars) {
                car.move();//MODEL
                int x = (int) Math.round(car.getXPos());//VIEW visar vart bilarna är 
                int y = (int) Math.round(car.getYPos());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) throws Exception { //Det enda som ska vara kvar här, borde ändra namn till GasCarController typ
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(amount);
        }
    }
}
