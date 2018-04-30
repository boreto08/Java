import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
       List<Citizen> citizens = new ArrayList<>();

        while(true){
            String input = reader.readLine();
            if (input.equals("End")){
                break;
            }

            String[] tokens = input.split(" ");
            String className = tokens[0];
            switch (className){
                case "Pet":
                    Pet pet = new Pet(tokens[1],tokens[2]);
                    citizens.add(pet);
                    break;
                case "Citizen":
                    Person person = new Person(tokens[1],Integer.parseInt(tokens[2]),tokens[3],tokens[4]);
                    citizens.add(person);
                    break;
            }
        }

        String year = reader.readLine();
        for (Citizen citizen : citizens) {
           if (citizen.isMatched(year)){
               System.out.println(citizen.getBirthday());
           }
        }



    }

}
