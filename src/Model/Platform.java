public class Platform{ //can create a class instead because you want to have the functions in scania
    int maxAngle = 70;
    int minAngle = 0;
    private double platformAngle = 0; // denna ska vara privat, instansvariablerna ska helst vara privat
    public int setplatform;


    public double PlatformAngleinterval(double platformAngle ) { // faställer vinkeln för platformen att den max får vara 70 och min vara 0
        platformAngle = Math.max(Math.min(platformAngle, maxAngle), minAngle);
        return platformAngle;
    }


    public double getPlatformAngle() {
        return platformAngle;
    }

    public void setPlatformAngle(double platformAngle) {
        this.platformAngle = platformAngle;
    }


    public double openPlatform(){
        platformAngle= maxAngle;
        PlatformAngleinterval(platformAngle); //  if > 70 , angle = 70
        return platformAngle;
    }


    public double closePlatform(){
        platformAngle= minAngle;
        PlatformAngleinterval(platformAngle);
        return platformAngle;
    }
    }