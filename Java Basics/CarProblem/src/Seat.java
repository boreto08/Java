import java.io.Serializable;

public class Seat implements Car, Serializable ,Sellable{

    private String model;
    private String color;
    private Integer horsePower;
    private String countyProduced;
    private Double price;

    public Seat(String model, String color, Integer horsePower, String countyProduced,Double price){
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countyProduced = countyProduced;
        this.price = price;
    }

    public String getCountyProduced(){
        return this.countyProduced;
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
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString(){
        return String.format("This is %s produced in %s and have %s tires",
                this.getModel(),this.getCountyProduced(),Car.TYRES);
    }


}
