package PawIncAgain;


import PawIncAgain.Animals.Animal;
import PawIncAgain.Animals.Cat;
import PawIncAgain.Animals.Dog;
import PawIncAgain.Centers.AdoptionCenter;
import PawIncAgain.Centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private HashMap<String, AdoptionCenter> adoptionCenters;
    private HashMap<String, CleansingCenter> cleansingCenters;

    private List<Animal> cleansedAnimals = new ArrayList<>();
    private List<Animal> adoptedAnimals = new ArrayList<>();

    private AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.cleansedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
    }


    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.put(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        this.adoptionCenters.put(name, adoptionCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).register(dog);

    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, adoptionCenterName, intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> animals = this.cleansingCenters.get(cleansingCenterName).cleanse();

        for (Animal animal : animals) {
            this.adoptionCenters.get(animal.getCenterName()).register(animal);
        }

        this.cleansedAnimals.addAll(animals);

    }

    public void adopt(String adoptionCenterName) {
        List<Animal> animals = this.adoptionCenters.get(adoptionCenterName).adopt();
        this.adoptedAnimals.addAll(animals);
    }

    public void printStatistics() {
        StringBuilder builder = new StringBuilder();

        builder.append("Paw Incorporative Regular Statistics\n");
        builder.append(String.format("Adoption Centers: %d\n", this.adoptionCenters.size()));
        builder.append(String.format("Cleansing Centers: %d\n", this.cleansingCenters.size()));
        builder.append(String.format("Adopted Animals: %s\n", getSortedAnimals(this.adoptedAnimals)));
        builder.append(String.format("Cleansed Animals: %s\n", getSortedAnimals(this.cleansedAnimals)));
        builder.append(String.format("Animals Awaiting Adoption: %d\n", getAwaitingAdoptionCount()));
        builder.append(String.format("Animals Awaiting Cleansing: %d\n", getAwaitingCleansingCount()));

        System.out.println(builder.toString());
    }

    private int getAwaitingCleansingCount() {
        int count = this.cleansingCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .collect(Collectors.toList())
                .size();

        return count;
    }

    private int getAwaitingAdoptionCount() {
        int count = this.adoptionCenters.values().stream()
                .flatMap(c -> c.getAnimals().stream())
                .filter(a -> a.isCleansed())
                .collect(Collectors.toList())
                .size();

        return count;
    }

    private String getSortedAnimals(List<Animal> animals) {
        if (animals.isEmpty()) {
            return "None";
        }

        List<String> sorted = animals.stream()
                .map(a -> a.getName())
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        return String.join(", ", sorted);
    }


}











