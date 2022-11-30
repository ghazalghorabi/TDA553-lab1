class Turbo{
    public boolean turboOn;

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    public boolean getTurbo(){
        return turboOn;
    }

    public double turbofactor(){
        double turbo = 1;
        if(getTurbo()) turbo = 1.3;
        return turbo;
    }
}