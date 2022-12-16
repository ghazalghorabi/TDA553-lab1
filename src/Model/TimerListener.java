
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    private CarView view;
    
    public TimerListener(CarView view){
        this.view = view;
    }

    public void actionPerformed(ActionEvent e) { 
            for (Car car : Main.cars) {
                car.move();
                try {
					car.gas(GasController.getUpdatedGas());
    
				} catch (Exception e1) {
					e1.printStackTrace();
				}

                view.repaint();  
            }
        }
    }