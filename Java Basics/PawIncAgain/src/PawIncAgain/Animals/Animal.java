package PawIncAgain.Animals;

public abstract class Animal {

    private String name;
    private int age;
    private boolean isCleansed;
    private String adoptionCenter;

    private Animal(String name, int age) {
        this.name = name;
        this.age = age;
        isCleansed = false;
    }

    protected Animal(String name, int age, String adoptionCenter){
        this(name, age);
        this.adoptionCenter = adoptionCenter;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCleansed() {
        return this.isCleansed;
    }

    public String getCenterName() {
        return this.adoptionCenter;
    }

    public void cleanse(){
        this.isCleansed = true;
    }
}
