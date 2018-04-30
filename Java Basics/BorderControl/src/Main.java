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
            if (tokens.length == 3){
                  Person person = new Person(tokens[0],tokens[2],Integer.parseInt(tokens[1]));
                  citizens.add(person);
            }else{
                Robot robot = new Robot(tokens[0],tokens[1]);
                citizens.add(robot);
            }
        }

        String num = reader.readLine();
        for (Citizen citizen : citizens) {
            if (citizen.isFake(num)){
                System.out.println(citizen.getId());
            }
        }

    }

}
