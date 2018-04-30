/**
 * Created by boreto on 3/6/2017.
 */
public class Pizza {
    private String name;
    private double totalCalories;
    private int numOfToppings;
    private boolean Legal = true;

    public Pizza(){

    }

    public Pizza(String name, int numOfToppings) {
        this.setName(name);
        this.setNumOfToppings(numOfToppings);
    }

    public boolean getLegal(){
        return this.Legal;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.length() >= 1 && name.length() <=15) {
            this.name = name;
        }else{
            System.out.println("Pizza name should be between 1 and 15 symbols.");
            this.Legal = false;
        }
    }

    public double getTotalCalories() {
        return this.totalCalories;
    }

    private void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    private int getNumOfToppings() {
        return this.numOfToppings;
    }

    private void setNumOfToppings(int numOfToppings) {
        if (numOfToppings >= 1 && numOfToppings <= 10){
            this.numOfToppings = numOfToppings;
        }else {
            System.out.println("Number of toppings should be in range [0..10].");
            this.Legal = false;
        }

    }

    public void addCalories(double calories){
        this.totalCalories += calories;
    }
}
