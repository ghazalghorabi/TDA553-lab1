
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    private DrawPanel drawPanel;

    public void actionPerformed(ActionEvent e) { // user input (actionlistner "button")
            for (Car car : Main.cars) {
                int x = (int) Math.round(car.getXPos());// VIEW visar vart bilarna är
                int y = (int) Math.round(car.getYPos());
                //drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                drawPanel.repaint();  
            }
        }
    }
