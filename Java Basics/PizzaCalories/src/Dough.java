import java.util.HashMap;

public class Dough {
    private static final HashMap<String,Double> MAP_BAKING_TECH = new HashMap<>();
    static{
        MAP_BAKING_TECH.put("crispy",0.9);
        MAP_BAKING_TECH.put("chewy",1.1);
        MAP_BAKING_TECH.put("homemade",1.0);
    }
    private static final HashMap<String,Double> MAP_FLOUR_TYPE = new HashMap<>();
    static {
        MAP_FLOUR_TYPE.put("white", 1.5);
        MAP_FLOUR_TYPE.put("wholegrain", 1.0);
    }

    private int gramsDough;
    private double caloriesPerGram;
    private double totalCalories;
    private String bakingTech;
    private String flourType;
    private boolean isIlegal = false;


    public Dough(int gramsDough, String bakingTech, String flourType) {

        this.setGramsDough(gramsDough);
        this.setBakingTech(bakingTech);
        this.setFlourType(flourType);
        if (!isIlegal){
            this.setTotalCalories(this.calcTotalCalories(this.getFlourType(),this.getBakingTech()));
            this.setCaloriesPerGram(this.calcCalariesPerGram(totalCalories));
        }

    }

    public boolean getIsIlegal(){
        return  this.isIlegal;
    }

    public double getTotalCalories() {
        return this.totalCalories;
    }

    private void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    private String getBakingTech() {
        return this.bakingTech;
    }

    private void setBakingTech(String bakingTech) {
        this.bakingTech = bakingTech;
    }

    private String getFlourType() {
        return this.flourType;
    }

    private void setFlourType(String flourType) {
        if (MAP_FLOUR_TYPE.containsKey(flourType.toLowerCase())){
            this.flourType = flourType.toLowerCase();
        }else{
            this.isIlegal = true;
            System.out.println("Invalid type of dough.");
        }

    }

    private double getCaloriesPerGram() {
        return this.caloriesPerGram;
    }

    private void setCaloriesPerGram(double caloriesPerGram) {
        this.caloriesPerGram = caloriesPerGram;
    }

    private int getGramsDough() {
        return this.gramsDough;
    }

    private void setGramsDough(int gramsDough) {
        if (gramsDough >= 1 && gramsDough <= 200){
            this.gramsDough = gramsDough;
        }else{
            System.out.println("Dough weight should be in the range [1..200].");
            this.isIlegal= true;
        }
    }

    private double calcTotalCalories(String flourType ,String bakingTech){
        double flourValue = MAP_FLOUR_TYPE.get(flourType.toLowerCase());
        double bakingTechValue = MAP_BAKING_TECH.get(bakingTech.toLowerCase());

        return (this.getGramsDough() * 2 * flourValue * bakingTechValue);
    }

    private double calcCalariesPerGram(double totalCalories){
        return totalCalories / this.getGramsDough();
    }
}
