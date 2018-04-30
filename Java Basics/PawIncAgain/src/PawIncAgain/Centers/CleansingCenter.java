package PawIncAgain.Centers;

import PawIncAgain.Animals.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boreto on 3/11/2017.
 */
public class CleansingCenter extends Center {

    public CleansingCenter(String name) {
        super(name);
    }

    public List<Animal> cleanse(){
        List<Animal> animals = new ArrayList<>();

        super.getAnimals().stream().forEach(a -> {
            a.cleanse();
            animals.add(a);
        });

        return animals;
    }
}
