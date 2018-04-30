import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents= new ArrayList<>();
    private List<Child> children = new ArrayList<>();
    private HashSet<Pokemon> pokemons = new HashSet<>();

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public HashSet<Pokemon> getPokemons() {
        return this.pokemons;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void print(){
        System.out.printf("%s\n",this.getName());
        try{
            System.out.println("Company:");
            System.out.println(this.getCompany().toString());
        }catch (Exception e){

        }
        try{
            System.out.println("Car:");
            System.out.println(this.getCar().toString());
        }catch (Exception e){

        }

        System.out.println("Pokemon:");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.toString());
        }
        System.out.println("Parents:");
        for (Parent parent : parents) {
            System.out.println(parent.toString());
        }
        System.out.println("Children:");
        for (Child child : children) {
            System.out.println(child.toString());
        }
    }
}
