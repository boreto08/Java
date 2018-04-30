package PawIncAgain.Centers;

import PawIncAgain.Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Center {

    private String name;
    private List<Animal> animals;

    protected Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void register(Animal animal){
        this.animals.add(animal);
    }

    public void registerAll(List<Animal> animals){
        this.animals.addAll(animals);
    }

    public List<Animal> getAnimals(){
        return this.animals;
    }

    public void removeAnimals(List<Animal> animals){
        this.animals.removeAll(animals);
    }

}
