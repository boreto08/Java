import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NMS {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            List<String> words = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            while(true){
                String input = br.readLine();
                if (input.equals("---NMS SEND---")){
                    break;
                }
                words.add(input);
            }

            String delimeter = br.readLine();



            for (int i = 0; i < words.size(); i++) {

                if (i != 0){
                    String ch1 = String.valueOf(words.get(i - 1).charAt(words.get(i - 1).length() - 1));
                    String ch2 = String.valueOf(words.get(i).charAt(0));
                    if (ch1.compareToIgnoreCase(ch2) <= 0){
                           result.append(ch1);
                    }else {
                        result.append(ch1);
                        result.append(delimeter);

                    }
                }
                String currentWord = words.get(i).trim();

                for (int j = 0; j < currentWord.length() - 1; j++) {

                    String ch1 = String.valueOf(currentWord.charAt(j));
                    String ch2 = String.valueOf(currentWord.charAt(j + 1));


                    if (ch1.compareToIgnoreCase(ch2) <= 0){
                        result.append(ch1);

                    }
                    else {
                        result.append(ch1);
                        result.append(delimeter);
                    }
                }
            }

            String lastWord = words.get(words.size() -1);
            String ch1 = String.valueOf(lastWord.charAt(lastWord.length() - 2));
            String ch2 = String.valueOf(lastWord.charAt(lastWord.length() - 1));

            if (ch1.compareToIgnoreCase(ch2) <= 0){
                   result.append(ch2);
            }
            else {
                   result.append(delimeter);
                   result.append(ch2);
            }




        System.out.println(result.toString());





    }

}
