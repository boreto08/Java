import java.util.HashMap;

public class Topping {

    private static final HashMap<String, Double> MAP_TOPPING = new HashMap<>();

    static {
        MAP_TOPPING.put("meat", 1.2);
        MAP_TOPPING.put("veggies", 0.8);
        MAP_TOPPING.put("cheese", 1.1);
        MAP_TOPPING.put("sauce", 0.9);
    }

    private int grams;
    private double totalCalories;
    private String toppingType;
    private boolean isIlegal = false;

    public Topping(String toppingType, int grams) {
        this.setToppingType(toppingType);

        if (!isIlegal) {
            this.setGrams(grams);
            this.setTotalCalories(this.calcTotalCalories());
        }

    }


    public boolean getIlegal() {
        return this.isIlegal;
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private void setToppingType(String toppingType) {
        if (!MAP_TOPPING.containsKey(toppingType.toLowerCase())) {
            System.out.printf("Cannot place %s on top of your pizza.", toppingType);
            isIlegal = true;
        } else {
            this.toppingType = toppingType;
        }

    }

    public double getTotalCalories() {
        return this.totalCalories;
    }

    private void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    private int getGrams() {
        return this.grams;
    }

    private void setGrams(int grams) {
        if (grams > 0 && grams <= 50) {
            this.grams = grams;
        } else {
            System.out.printf("%s weight should be in the range [1..50].", this.getToppingType());
            isIlegal = true;
        }

    }

    private double calcTotalCalories() {
        double toppingValue = MAP_TOPPING.get(this.getToppingType().toLowerCase());
        double result = (2 * this.getGrams() * toppingValue);
        return result;
    }
//    private   double calcCaloriesPerGram(){
//        return  this.getTotalCalories() / this.getGrams();
//    }
}
