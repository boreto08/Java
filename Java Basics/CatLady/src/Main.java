import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Cat> mapCat = new LinkedHashMap<>();

        while(true){
            String input = scan.readLine();
            if (input.equals("End")){
                break;
            }
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double parameter = Double.parseDouble(tokens[2]);

            switch (breed){
                case "Siamese":
                    Siamese siamese = new Siamese(name,breed,parameter);
                    mapCat.putIfAbsent(name,siamese);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(name,breed,parameter);
                    mapCat.putIfAbsent(name,cymric);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire stExtra = new StreetExtraordinaire(name,breed,parameter);
                    mapCat.putIfAbsent(name,stExtra);
                    break;
            }
        }

        String searchedCat = scan.readLine();

        if (mapCat.containsKey(searchedCat)){
            System.out.println(mapCat.get(searchedCat).toString());
        }

    }

}
