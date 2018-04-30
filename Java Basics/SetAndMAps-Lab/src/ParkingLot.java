import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> numbersSet = new HashSet<>();

        while (true) {
            String input = br.readLine();
            if (input.equals("END")) {
                break;
            }
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String number = tokens[1];
            if (command.equals("IN")) {
                numbersSet.add(number);
            }else {
                numbersSet.remove(number);
            }
        }
        if (!numbersSet.isEmpty()){
            numbersSet.forEach(System.out::println);
        }else {
            System.out.println("Parking Lot is Empty");
        }







    }
}
