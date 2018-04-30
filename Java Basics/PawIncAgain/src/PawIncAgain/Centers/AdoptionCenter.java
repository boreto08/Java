package PawIncAgain.Centers;

import PawIncAgain.Animals.Animal;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by boreto on 3/11/2017.
 */
public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public void sendForCleansing(CleansingCenter center){
        List<Animal> animals = super.getAnimals().stream().filter(a -> !a.isCleansed()).collect(Collectors.toList());

        super.removeAnimals(animals);
        center.registerAll(animals);
    }

    public List<Animal> adopt(){
        List<Animal> animals = super.getAnimals()
                .stream()
                .filter(a -> a.isCleansed())
                .collect(Collectors.toList());

        super.removeAnimals(animals);
        return  animals;

    }
}
