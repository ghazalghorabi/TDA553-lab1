import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Single responsibility princible: ha allt som handlar om controller här

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */
public class CarController { 
    CarView frame; //en frame för controller
    BrakeController brakeController = new BrakeController();
    GasController gasController = new GasController();


    // la till:
    public void actionListener() {
        gasController.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : Main.cars) {
                    try {
                        cc.gas(gasController.gasAmount);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        brakeController.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car cc : Main.cars) {
                    try {
                        cc.brake(brakeController.brakeAmount);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }


   /*  // Calls the gas method for each car once
    public void gas(int amount) throws Exception { // Det enda som ska vara kvar här, borde ändra namn till
        // GasCarController typ
double gas = ((double) amount) / 100;
for (Car car : cars) {
car.gas(amount);
}
}*/
}
