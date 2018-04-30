import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Royalism {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArgs = br.readLine().split(" ");
        List<String> royalists = new ArrayList<>();
        List<String> nonRoyalistsList = new ArrayList<>();

        int sum  = 0;
        int countRoylist = 0;
        int nonRoylist = 0;

        for (int i = 0; i < strArgs.length; i++) {

            char[] currentWord = strArgs[i].toCharArray();
            sum = 0;
            for (int j = 0; j < currentWord.length ; j++) {
                char currentChar = currentWord[j];
                sum += currentChar;
                if (sum > 26){
                    while (sum > 26){
                        sum -= 26;
                    }
                }
            }
            int result = sum;

            int posOfR = (int)'R' - (int)'@';
            if (result == posOfR){
                countRoylist++;
                royalists.add(String.valueOf(currentWord));
            }
            else {
                nonRoylist++;
                nonRoyalistsList.add(String.valueOf(currentWord));
            }
        }

        if (countRoylist < 0 ){
            return;
        }

        if (countRoylist >= nonRoylist){
            System.out.printf("Royalists - %d",countRoylist);
            System.out.println();
            for (int i = 0; i < royalists.size(); i++) {
                System.out.println(royalists.get(i));
            }
            System.out.println("All hail Royal!");
        }
        else {
            for (int i = 0; i < nonRoyalistsList.size(); i++) {
                System.out.println(nonRoyalistsList.get(i));
            }
            System.out.println("Royalism, Declined!");
        }


    }

}
