
public class TimerListener {

    private final int delay = 50; //Timer stuff -> model
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener()); //more timer stuff
    cc.cars.add(new Volvo240());
    // Start the timer
    cc.timer.start(); //timer, should NOT be in controller
    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener { //
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
}
