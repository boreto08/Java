
public class Pokemon {

    private String name;


    public  Pokemon(String name){
        this.setName(name);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
