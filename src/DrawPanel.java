import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    
    
    List<Car> cars;
    


    // Initializes the panel and reads the images
    public DrawPanel(List<Car> cars, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.cars = cars;

        
        // Print an error message in case file is not found with a try/catch block
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("Scania.jpg"));
        } catch (IOException ex){
            ex.printStackTrace();   //do we need to change this? what does this? 
            
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    
    @Override
    protected void paintComponent(Graphics g) { // vi kanske ska ha denna i view??
        super.paintComponent(g);
        g.drawImage(saabImage, cars.get(0).getXPos(), cars.get(0).getYPos(), null); //TODO fixa "ful lösning i mån av tid"
        g.drawImage(volvoImage, cars.get(1).getXPos(), cars.get(1).getYPos(), null);
        g.drawImage(scaniaImage, cars.get(2).getXPos(), cars.get(2).getYPos(), null); // see javadoc for more info on the parameters
    }


    
}
