import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by boreto on 2/10/2017.
 */
public class StudentsGroup {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,String> nameGroupMap = new HashMap<>();

        while(true){
            String input = br.readLine();
            if (input.equals("END")){
                break;
            }

            String[] tokens = input.split(" ");
            String fullName = tokens[0] + " " + tokens[1];
            String numStr = tokens[2];

            nameGroupMap.putIfAbsent(fullName,numStr);
        }

        nameGroupMap.entrySet()
                .stream()
                .filter(p -> p.getValue()
                .equals("2"))
                .sorted((p1,p2) -> p1.getKey().split(" ")[0].compareTo(p2.getKey().split(" ")[0]))
                .forEach(p -> System.out.println(p.getKey()));
    }

}
