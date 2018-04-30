package NeedForSpeed.models.Cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car{

    private static final int  FIFTY_PERCENT = 50;

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction,
                             int horsepower, int acceleration, int suspension, int durability) {

        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public PerformanceCar(String brand, String model, int yearOfProduction,
                             int horsepower, int acceleration, int suspension,
                             int durability, ArrayList<String> addOns) {

        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = addOns;
}
    @Override
    public int getHorsepower() {
        return increaseHP(super.getHorsepower());
    }

    @Override
    public int getSuspension() {
        return decreseSuspension(super.getSuspension());
    }

    public void addAddOns(List<String> addOns){
        for (String addOn : addOns) {
            this.addOns.add(addOn);
        }
    }


    @Override
    public String toString(){
        StringBuilder sbRaceCar = new StringBuilder();

        sbRaceCar.append(String.format("Add-ons: %s",this.addOns.isEmpty() ? "None" : String.join(", ",this.addOns)))
                .append(System.lineSeparator());
        return super.toString() + sbRaceCar.toString();
    }

    private int increaseHP(int horsepower){
        return (horsepower + ((horsepower * FIFTY_PERCENT) / 100));
    }

    private int decreseSuspension(int suspension){
        return (suspension - ((suspension * 25) / 100));
    }

}
