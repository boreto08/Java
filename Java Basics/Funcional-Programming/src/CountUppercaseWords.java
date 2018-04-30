import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] textArr = br.readLine().split(" ");
        List<String> capitalLettWords = new ArrayList<>();
        int counter = 0;

        for (String word : textArr) {
            char firstLetter = word.charAt(0);
            if (Character.isUpperCase(firstLetter)){
                capitalLettWords.add(word);
                counter++;
            }
        }

        System.out.println(counter);

        for (String capitalLettWord : capitalLettWords) {
            System.out.println(capitalLettWord);
        }

    }
}
