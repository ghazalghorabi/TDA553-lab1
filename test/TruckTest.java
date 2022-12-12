import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;


public class TruckTest {
@Test
  public void PlatformAngleIntervaltest(){
    Platform platform = new Platform();
    double angle = platform.PlatformAngleinterval(71);     // ska bli 70
    assertTrue(angle <= 70 && angle >= 0);
  }
  @Test
  public void platformOpenTest(){
    Platform platform = new Platform();
    double oldAngle = 50;
    platform.openPlatform();
    double newAngle= platform.getPlatformAngle(); 
    assertTrue(newAngle>oldAngle);
  }
  @Test
  public void platformCloseTest(){
    Platform platform = new Platform();
    double oldAngle = 50;
    platform.closePlatform();
    double newAngle = platform.getPlatformAngle();
    assertTrue(newAngle<oldAngle);
  }
  @Test
  public void raiseplatformTest() throws Exception{
    Scania scania = new Scania();
    scania.setCurrentSpeed(5);
    scania.openPlatform();
    assertThrows(Exception.class,()-> scania.raiseplatform(scania.getPlatformAngle()));
  }
  @Test
  public void lowerplatformTest() throws Exception{
    Scania scania = new Scania();
    scania.setCurrentSpeed(5);
    scania.closePlatform();
    assertThrows(Exception.class,()-> scania.lowerplatform(scania.getPlatformAngle()));
  }

@Test
  public void raiseplatformForScaniaTest() throws Exception{
    Scania scania= new Scania();
    scania.setCurrentSpeed(10);
    scania.openPlatform();
    assertThrows(Exception.class,()-> scania.raiseplatform(scania.getPlatformAngle()));   
  }
  @Test
  public void lowerPlatformTransporter() throws Exception{
    CarTransporter carTransporter = new CarTransporter(null, 10, 0, 0);
    carTransporter.setCurrentSpeed(10);
    carTransporter.closePlatform();
    assertThrows(Exception.class,()-> carTransporter.lowerplatform(carTransporter.getPlatformAngle()));
  }
    

  @Test
  public void truck_dont_move_with_platformRaised_test() throws Exception{
    Scania scania = new Scania();
    
    int yPos = scania.getYPos();

    scania.raiseplatform(70); 
    scania.gas(1);
    scania.move(); //should not MOVE so yPos should be the same
    
    assertEquals(100, yPos); 
    //100 är start yPos i ny "draw filen"
  }

}
