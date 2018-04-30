package pawinc.models;

import pawinc.models.animals.Animal;
import pawinc.models.animals.Cat;
import pawinc.models.animals.Dog;
import pawinc.models.centers.AdoptionCenter;
import pawinc.models.centers.CleansingCenter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private HashMap<String,AdoptionCenter> adoptionCenters;
    private HashMap<String,CleansingCenter> cleansingCenters;

    private List<Animal> clensedAnimals;
    private List<Animal> adoptedAnimals;

    private AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.clensedAnimals = new ArrayList<>();
        this.adoptedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        cleansingCenters.putIfAbsent(name,cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        adoptionCenters.putIfAbsent(name,adoptionCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.adoptionCenters.get(adoptionCenterName).register(dog);

    }

    public  void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, adoptionCenterName,intelligenceCoefficient);
        this.adoptionCenters.get(adoptionCenterName).register(cat);
    }

    public  void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        this.adoptionCenters.get(adoptionCenterName).sendForCleansing(cleansingCenter);
    }

    public void cleanse(String cleansingCenterName) {
        List<Animal> cleansedAnimals =
                this.cleansingCenters.get(cleansingCenterName).cleanse();
        for (Animal cleansedAnimal : cleansedAnimals) {
            this.adoptionCenters
                    .get(cleansedAnimal.getCenterName())
                    .register(cleansedAnimal);
        }

        this.clensedAnimals.addAll(cleansedAnimals);
    }

    public void adopt(String adoptionCenterName) {
        List<Animal> animals = this.adoptionCenters.get(adoptionCenterName).adopt();

        this.adoptedAnimals.addAll(animals);
    }

    public void printStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics\n");
        sb.append(String.format("Adoption Centers: %d\n",this.adoptionCenters.size()));
        sb.append(String.format("Cleansing Centers: %d\n",this.cleansingCenters.size()));
        sb.append(String.format("Adopted Animals: %s\n",getSortedAnimals(this.adoptedAnimals)));
        sb.append(String.format("Cleansed Animals: %s\n",getSortedAnimals(this.clensedAnimals)));
        sb.append(String.format("Animals Awaiting Adoption: %d\n",getAwaitingAdoptionCount()));
        sb.append(String.format("Animals Awaiting Cleansing: %d\n",getAwaitingCleansingCount()));

        System.out.println(sb.toString());

    }


    private String getSortedAnimals(List<Animal> animals) {
        if (animals.isEmpty()){
            return "None";
        }

        List<String> sorted = animals.stream()
                .map(Animal::getName)
                .sorted(Collator.getInstance())
                .collect(Collectors.toList());

        return String.join(", ",sorted);
    }

    private int getAwaitingAdoptionCount() {
        int count = this.adoptionCenters.values()
                .stream().flatMap(c -> c.getAnimals().stream())
                .filter(a -> a.isCleansed())
                .collect(Collectors.toList())
                .size();
        return count;

    }

    private int getAwaitingCleansingCount() {
        int count = this.cleansingCenters.values()
                .stream().flatMap(c -> c.getAnimals().stream())
                .collect(Collectors.toList())
                .size();
        return count;

    }
}
