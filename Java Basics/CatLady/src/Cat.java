/**
 * Created by boreto on 2/27/2017.
 */
public class Cat {
    private String name;
    private String breed;



    public Cat(String name, String breed){
        this.setName(name);
        this.setBreed(breed);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
