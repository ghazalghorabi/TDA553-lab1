import java.util.Timer;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TimerListener implements ActionListener {

    public void actionPerformed(ActionEvent e) { // user input (actionlistner "button")
            for (Car car : Main.cars) {
                int x = (int) Math.round(car.getXPos());// VIEW visar vart bilarna är
                int y = (int) Math.round(car.getYPos());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                
            }
        }
    }
