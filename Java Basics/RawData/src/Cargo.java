public class Cargo {
    private double cargoWeight;
    private String cargoType;

    public Cargo(double cargoWeight , String cargoType){
        this.setCargoWeight(cargoWeight);
        this.setCargoType(cargoType);
    }

    public double getCargoWeight() {
        return  this.cargoWeight;
    }

    public void setCargoWeight(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return  this.cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }
}
