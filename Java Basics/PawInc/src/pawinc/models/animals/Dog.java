package pawinc.models.animals;

/**
 * Created by boreto on 3/9/2017.
 */
public class Dog extends Animal {

    private int commands;

    public Dog(String name, int age, String adoptionCenter, int commands) {
        super(name, age, adoptionCenter);
        this.commands = commands;
    }
}
