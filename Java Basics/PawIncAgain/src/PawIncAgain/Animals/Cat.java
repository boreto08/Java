package PawIncAgain.Animals;

/**
 * Created by boreto on 3/11/2017.
 */
public class Cat extends Animal {

    private  int intelligance;

    private Cat(String name, int age, String adoptionCenter , int intelligance) {
        super(name, age, adoptionCenter);
        this.intelligance = intelligance;
    }
}
