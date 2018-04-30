import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTransformer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbText = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("burp")) {
                break;
            }
            sbText.append(input);
        }

        String strText = String.valueOf(sbText).replaceAll("\\s+", " ");
        Pattern pattern = Pattern.compile("([$%&'])(?<text>[^$%&']+)\\1");
        Matcher matcher = pattern.matcher(strText);
        
        while (matcher.find()){

            String specialSymbol = matcher.group(1);
            String text = matcher.group("text");
            Integer weightSymbol = getWeight(specialSymbol);

            StringBuilder sb  = new StringBuilder();

            for (int i = 0; i < text.length(); i++) {

                Integer currCh = (int)text.charAt(i);
                Character result;
                if (i % 2 == 0){
                     result = (char)(currCh + weightSymbol);
                }else {
                    result = (char)(currCh - weightSymbol);
                }
                sb.append(result);
            }
            System.out.print(sb + " ");

        }

    }

    private static Integer getWeight(String specialSymbol) {
        Integer result = 0;
        switch (specialSymbol){
            case "$": result = 1;
            break;
            case "%": result = 2;
            break;
            case "&": result = 3;
            break;
            case "'": result = 4;
            break;
        }
        return  result;
    }

}
