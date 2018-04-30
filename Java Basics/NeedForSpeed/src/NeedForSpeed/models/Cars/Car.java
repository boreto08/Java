package NeedForSpeed.models.Cars;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

   private boolean isRacing;
   private boolean isParked;



    protected Car(String brand, String model,
                  int yearOfProduction, int horsepower,
                  int acceleration, int suspension, int durability) {

        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    private String getBrand() {
        return this.brand;
    }

    private String getModel() {
        return this.model;
    }

    private int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }


    public void setHP(int hp){
        this.horsepower = hp;
    }

    public   void setSusp(int suspension){
        this.suspension = suspension;
    }

    public boolean getIsParked(){
        return this.isParked;
    }

    public void park(boolean flag){
        this.isParked = flag;
    }

    public boolean getIsRacing(){
        return this.isRacing;
    }

    public void race(){
        this.isRacing = true;
    }




    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %d",this.getBrand(),this.getModel(),this.getYearOfProduction()))
                .append(System.lineSeparator())
                .append(String.format("%d HP, 100 m/h in %d s",this.getHorsepower(),this.getAcceleration()))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability",this.getSuspension(),this.getDurability()))
                .append(System.lineSeparator());

        return  sb.toString();
    }

}
