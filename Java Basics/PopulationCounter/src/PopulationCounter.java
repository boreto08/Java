import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PopulationCounter {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Country> mapCountries = new LinkedHashMap<>();

        while(true){
            String input = br.readLine().trim();
            if (input.equals("report")){
                break;
            }
            Pattern pattern = Pattern.compile("([a-zA-Z -]+)\\|([a-zA-Z ]+)\\|([0-9]+)");
            Matcher matcher = pattern.matcher(input);

            String city = "";
            String country = "";
            Long population;

            if (!matcher.find()) {
                continue;
            }

            city = matcher.group(1);
            country = matcher.group(2);
            population = Long.parseLong(matcher.group(3));
            Country currentCountry = new Country();
            if (!mapCountries.containsKey(country)) {

                LinkedHashMap<String, Long> mapCurrent = new LinkedHashMap<>();
                mapCurrent.put(city, population);
                currentCountry.setName(country);
                currentCountry.setMapCitiesPopulation(mapCurrent);
                mapCountries.put(country, currentCountry);
            }else {
                currentCountry = mapCountries.get(country);

                if (!currentCountry.getMapCitiesPopulation().containsKey(city)){
                    mapCountries.get(country).addCityAndPopulation(city,population);
                }
            }
        }

        mapCountries.entrySet().stream().sorted((country1,country2) -> {

           Long sumPeople1 =  country1.getValue().countCities();
           Long sumPeople2 =  country2.getValue().countCities();
           
           if (sumPeople1 > sumPeople2){
                 return  -1;
           }else {
                return 1;
           }

        }).forEach(e -> {
            Long totalPopulation = e.getValue().sumPopulation();
            System.out.printf("%s (total population: %d)\n",e.getKey(),totalPopulation);
            e.getValue().getMapCitiesPopulation().entrySet().stream().sorted((city1,city2) -> {
                if (city1.getValue() > city2.getValue()){
                    return  -1;
                }
                else {
                    return  1;
                }
            }).forEach(city -> System.out.printf("=>%s: %d\n",city.getKey(),city.getValue()));

        });


    }

}

class  Country{

    private  String name;
    private LinkedHashMap<String,Long> mapCitiesPopulation;

    public  Country(){
        mapCitiesPopulation = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashMap<String, Long> getMapCitiesPopulation() {
        return mapCitiesPopulation;
    }

    public void setMapCitiesPopulation(LinkedHashMap<String, Long> mapCitiesPopulation) {
        this.mapCitiesPopulation = mapCitiesPopulation;
    }

    public  void addCityAndPopulation(String city, Long population){
        this.mapCitiesPopulation.put(city, population);
    }

    public Long countCities(){
       return this.mapCitiesPopulation.values().stream().mapToLong(num -> Long.parseLong(String.valueOf(num))).sum();
    }

    public  Long sumPopulation(){
        Long result = 0L;

        for (Long people : mapCitiesPopulation.values()) {
            result +=people;
        }
        return result;
    }
}
