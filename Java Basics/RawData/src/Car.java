
public class Car {
    private String carModel;
    private double engineSpeed;
    private double enginePower;

    private Cargo cargo;
    private Tyre[] tyres;

    public Car(String carModel, double engineSpeed, double enginePower, Cargo cargo,Tyre[] tyres){
        this.setCarModel(carModel);
        this.setEngineSpeed(engineSpeed);
        this.setEnginePower(enginePower);
        this.setCargo(cargo);
        this.setTyres(tyres);
    }

    public String getCarModel() {
        return  this.carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getEngineSpeed() {
        return  this.engineSpeed;
    }

    public void setEngineSpeed(double engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public double getEnginePower() {
        return  this.enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public Cargo getCargo() {
        return  this.cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tyre[] getTyres() {
        return  this.tyres;
    }

    public void setTyres(Tyre[] tyres) {
        this.tyres = tyres;
    }

    public boolean isTherePressureUnderOne(){
        boolean isThere = false;
        for (Tyre tyre : this.getTyres()) {
            if (tyre.getTyrePressure() < 1){
                isThere = true;
                return isThere;
            }
        }

        return  isThere;
    }
}
