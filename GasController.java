import javax.swing.*;


public class GasController {

    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas"); // GasController

    private double updatedGas;

    

    //public GasController(int updatedGas) {
      //  this.gasAmount = updatedGas;   }


    public double getUpdatedGas() {
        return updatedGas;
    }



    public void setUpdatedGas(double updatedGas) {
        this.updatedGas = updatedGas;
    }



    // Calls the gas method for each car once
    public void updateGasAmount(int amount, double updatedGas) throws Exception { 
        updatedGas = ((double) amount) / 100;
    }


}