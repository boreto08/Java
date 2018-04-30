package pawinc.models.centers;

import pawinc.models.animals.Animal;

import java.util.ArrayList;
import java.util.List;


public class CleansingCenter extends Center {

    public CleansingCenter(String name) {
        super(name);
    }

    public List<Animal> cleanse(){
        List<Animal> clensed = new ArrayList<>();
        super.getAnimals().stream().forEach(a -> {
            a.cleanse();
            clensed.add(a);
        });
        super.removeAnimals(clensed);
        return  clensed;
    }
}
