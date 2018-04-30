import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonTrainer {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Trainer> mapStringTrainer = new LinkedHashMap<>();

        while(true){
            String input = scan.readLine();
            if (input.equals("")){
                return;
            }
            if (input.equals("Tournament")){
                break;
            }
            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            Long health = Long.parseLong(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName,element,health);
            Trainer trainer = new Trainer(trainerName,pokemon);

            if (!mapStringTrainer.containsKey(trainerName)){
                  mapStringTrainer.put(trainerName,trainer);
            }else {
                mapStringTrainer.get(trainerName).getPokemons().add(pokemon);
            }
        }

        while(true){
            String input = scan.readLine();
            if (input.equals("End")){
                break;
            }
            String element = input;

            for (Trainer trainer : mapStringTrainer.values()) {
                List<Pokemon> trainersPokemons = trainer.getPokemons();
                boolean isThereEl = false;
                for (Pokemon pokemon : trainersPokemons) {
                    String elPokemon = pokemon.getElement();
                    if (element.equals(elPokemon)){
                        isThereEl = true;
                        trainer.addBadge();
                        break;
                    }
                }

                if (!isThereEl){
                    for (Pokemon pokemon : trainersPokemons) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                    }
                }

            }
        }

        for (Trainer trainer : mapStringTrainer.values()) {
           List<Pokemon> pokemons = trainer.getPokemons();
          List<Pokemon> filteredPokemons = pokemons.stream()
                  .filter(p -> p.getHealth() > 0)
                  .collect(Collectors.toList());
          trainer.setPokemons(filteredPokemons);
        }

        mapStringTrainer.entrySet().stream()
                .sorted((t1,t2) -> t2.getValue().getNumberOfBadges() >= t1.getValue().getNumberOfBadges()? 1 : -1)
                .forEach(t -> {
                    System.out.printf("%s %d %d\n",
                            t.getKey(),t.getValue().getNumberOfBadges(),t.getValue().getPokemons().size());
                });



    }

}
class Trainer{

    //Trainers have a name, number of badges and a collection of pokemon
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name,Pokemon pokemon){
        this.name = name;
        this.pokemons = new ArrayList<>();
        pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons(){
        return this.pokemons;
    }

    public  void addBadge(){
        this.numberOfBadges = ++numberOfBadges;
    }

    public  void setPokemons(List<Pokemon> pokemons){
        this.pokemons = pokemons;
    }

    public int getNumberOfBadges(){
        return this.numberOfBadges;
    }

}

class Pokemon{

    //Pokemon have a name, an element and health, all values are mandatory
    private String name;
    private String element;
    private Long health = 0L;

    public Pokemon(String name,String element,Long health){
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement(){
        return  this.element;
    }

    public  Long getHealth(){
        return  this.health;
    }

    public  void setHealth(Long health){
        this.health = health;
    }
}
