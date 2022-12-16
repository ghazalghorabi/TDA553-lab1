import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    Point volvoPoint = new Point();     //hur kopplar vi de till subklasserna? we should get this information from the model 
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    // TODO: Make this genereal for all cars 
    void moveit(Car car,int x, int y){ // ska denna vara i car classen? typ använda det vi har i CAR (move + egna x,y)
        car.xPos = x;
        car.yPos = y;
        car.move();
        car.brake(); //TODO make car go vroom
        

        /*volvoPoint.x = x;
        volvoPoint.y = y;
        saabPoint.x = x+50;
        saabPoint.y = y+50;
        scaniaPoint.x = x+100;
        scaniaPoint.y = y+100;*/
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);

        
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex){
            ex.printStackTrace();   //do we need to change this? what does this? 
            
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) { // vi kanske ska ha denna i view??
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null); 
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null); // see javadoc for more info on the parameters
    }


    
}
