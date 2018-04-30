
public class Car {

    private String model;
    private  double fuelAmount;
    private double fuelCostPerKm;
    private double distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostPerKm){
        this.model = model;
        this.fuelAmount =fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
    }

    public double getFuelAmount(){
        return  this.fuelAmount;
    }

    public String getModel(){
        return  this.model;
    }

    public double getDistanceTraveled(){
        return  this.distanceTraveled;
    }

    public boolean canItDrive(double kmToTravel){

        double possibleDistance = this.fuelAmount / this.fuelCostPerKm;
        if (possibleDistance >= kmToTravel){
            distanceTraveled += kmToTravel;
            fuelAmount = fuelAmount - (kmToTravel * fuelCostPerKm);
            return  true;
        }

        return  false;
    }
}
