package NeedForSpeed.models.Cars;

/**
 * Created by boreto on 3/12/2017.
 */
public class ShowCar extends Car {

    private int stars;


    public ShowCar(String brand, String model, int yearOfProduction, int horsepower,
                       int acceleration, int suspension, int durability) {

        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
    }

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower,
                      int acceleration, int suspension, int durability,int stars) {

        this(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = stars;
    }

    public void addStars(int stars){
        this.stars += stars;
    }

    @Override
    public String toString(){

        return super.toString() + this.stars + " *\n";
    }
}
