import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String inputPath = ".\\input_04.txt";
        String outputPath = ".\\output_04.txt";
        List<Character> vowels = new ArrayList<>() ;
        List<Character> consonants = new ArrayList<>() ;
        Collections.addAll(vowels, 'a','e', 'i', 'o', 'u');
        Collections.addAll(consonants, 'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z');
        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuation = 0;

        try (BufferedReader in =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileWriter(outputPath))) {

            while (true) {
                String input = in.readLine();
                if (input.equals("")) {
                    break;
                }

                char[] chArr = input.toCharArray();
                for (char ch : chArr ) {

                    if (vowels.contains(ch)){
                        vowelsCount++;
                    }
                    else if(consonants.contains(ch)) {
                        consonantsCount++;
                    }
                    else if (!Character.isDigit(ch) && !Character.isAlphabetic(ch) && !Character.isSpaceChar(ch)){
                        punctuation++;
                    }
                }
            }

            out.printf("Vowels: %s\n",vowelsCount);
            out.printf("Consonants: %s\n",consonantsCount);
            out.printf("Punctuation: %s",punctuation);
        }
    }
}
