package pawinc.models.animals;


public class Cat extends  Animal {
    private  int intelligance;

    public Cat(String name, int age, String adoptionCenter, int intelligance) {
        super(name, age, adoptionCenter);
        this.intelligance = intelligance;
    }
}
