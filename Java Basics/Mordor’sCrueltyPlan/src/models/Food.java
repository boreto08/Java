package models;

public class Food {

//    •	Cram:       2 points of happiness;
//    •	Lembas:     3 points of happiness;
//    •	Apple:      1 point of happiness;
//    •	Melon:      1 point of happiness;
//    •	HoneyCake:  5 points of happiness;
//    •	Mushrooms: -10 points of happiness;
//    •	Everything else: -1 point of happiness;

    private final int CRAM_POINTS = 2;
    private final int LEMBAS_POINTS = 3;
    private final int APPLE_POINTS = 1;
    private final int MELLON_POINTS = 1;
    private final int HONEYCAKE_POINTS = 5;
    private final int MUSHROOMS_POINTS = -10;
    private final int EVERYTHING_ELSE_POINTS = -1;


    private String foodName;
    private int foodValue;

    public Food (String foodName){
        this.setFoodName(foodName);
    }

    private int getFoodValue() {
        return this.foodValue;
    }

    private void setFoodValue(int foodValue) {
        this.foodValue = foodValue;
    }

    private void setFoodName(String foodName){
        this.foodName = foodName.toLowerCase();
    }

    private String getFoodName(){
        return  this.foodName;
    }

    private int calcValue(){
        switch (this.getFoodName()){
            case "cram":
                this.setFoodValue(this.getFoodValue() + CRAM_POINTS);
                break;
            case "lembas":
                this.setFoodValue(this.getFoodValue() + LEMBAS_POINTS);
                break;
            case "apple":
                this.setFoodValue(this.getFoodValue() + APPLE_POINTS);
                break;
            case "melon":
                this.setFoodValue(this.getFoodValue() + MELLON_POINTS);
                break;
            case "honeycake":
                this.setFoodValue(this.getFoodValue() + HONEYCAKE_POINTS);
                break;
            case "mushrooms":
                this.setFoodValue(this.getFoodValue() + MUSHROOMS_POINTS);
                break;
            default:
                this.setFoodValue(this.getFoodValue() + EVERYTHING_ELSE_POINTS);
                break;
        }
    }


}
