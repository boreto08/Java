import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsFirstLastName {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = new ArrayList<>();

        while(true){
            String input = br.readLine();
            if (input.equals("END")){
                break;
            }
            names.add(input);
        }

        names.stream()
                .filter(p -> {
                    String[] fullName = p.split(" ");
                    String firstName = fullName[0];
                    String lastName = fullName[1];
                    int result = firstName.compareTo(lastName);
                    if ( result < 0){
                        return true;
                    }
                    else {
                         return false;
                    }
                })
                .forEach(System.out::println);


    }

}
