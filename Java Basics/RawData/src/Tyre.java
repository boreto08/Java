
public class Tyre {
   private  double tyrePressure;
   private double tyreAge;

   public Tyre(double tyrePressure, double tyreAge){
       this.setTyrePressure(tyrePressure);
       this.setTyreAge(tyreAge);
   }

    public double getTyrePressure() {
        return this.tyrePressure;
    }

    public void setTyrePressure(double tyrePressure) {
        this.tyrePressure = tyrePressure;
    }

    public double getTyreAge() {
        return this.tyreAge;
    }

    public void setTyreAge(double tyreAge) {
        this.tyreAge = tyreAge;
    }
}
