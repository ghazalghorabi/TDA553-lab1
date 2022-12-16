public class Platform{ 
    int maxAngle = 70;
    int minAngle = 0;
    private double platformAngle = 0;


    public double PlatformAngleinterval(double platformAngle ) { 
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
        PlatformAngleinterval(platformAngle);
        return platformAngle;
    }


    public double closePlatform(){
        platformAngle= minAngle;
        PlatformAngleinterval(platformAngle);
        return platformAngle;
    }
    }