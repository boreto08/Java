import java.io.Serializable;

public class Audi implements Car,Serializable, Rentable {

    private Integer rentMinDays;
    private String model;
    private String color;
    private Integer horsePower;
    private Double pricePerDay;
    private String countyProduced;

    public Audi(String model, String color, Integer horsePower,String countyProduced, Integer rentMinDays, Double pricePerDay){

        this.model = model;
        this.color = color;
        this.countyProduced = countyProduced;
        this.horsePower = horsePower;
        this.rentMinDays = rentMinDays;
        this.pricePerDay  = pricePerDay;

    }


    @Override
    public Integer getRentMinDays() {
        return this.rentMinDays;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }



    @Override
    public String toString(){
        return String.format("This is %s produced in %s and have %s tires",
                this.getModel(),this.countyProduced,Car.TYRES);
    }
}
