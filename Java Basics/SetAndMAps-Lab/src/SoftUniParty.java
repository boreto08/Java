import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> regularSet = new HashSet<>();
        HashSet<String> vipSet = new HashSet<>();

        String input;
        while(true){
            input = sc.readLine();
            if (input.equals("PARTY")){
                break;
            }

            Character firstCh = input.charAt(0);

            if (Character.isDigit(firstCh)){
                vipSet.add(input);
            }else {
                regularSet.add(input);
            }
        }

        while(true){
            input = sc.readLine();
            if (input.equals("END")){
                break;
            }

            Character firstCh = input.charAt(0);

            if (Character.isDigit(firstCh)){

                vipSet.remove(input);
            }else {
                regularSet.remove(input);
            }
        }

        TreeSet<String> sortedGuests = new TreeSet<>();
        sortedGuests.addAll(regularSet);
        sortedGuests.addAll(vipSet);

        System.out.println(sortedGuests.size());
        sortedGuests.forEach(System.out::println);


    }


}
