import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Pattern regexPatt = Pattern.compile("(,|_)(([a-zA-Z]*)([0-9]))");

        while(true){
            HashMap<String,String> memorizedValues = new HashMap<>();
            String input = br.readLine();
            if (input.equals("Ascend")){
                break;
            }

            Matcher matcher = regexPatt.matcher(input);

            while (matcher.find()){
                String wholeMatch = matcher.group(0);
                if (wholeMatch.length() <= 2){
                    input.replace(wholeMatch,"");
                    continue;
                }
                String startCh =  matcher.group(1);
                String text = matcher.group(3);
                int num = Integer.parseInt(matcher.group(4));


                if (memorizedValues.containsKey(wholeMatch)){
                        text = memorizedValues.get(wholeMatch);
                }

                StringBuilder sbDecoded = new StringBuilder();
                for (int i = 0; i < text.length(); i++) {

                    char currentCh = text.charAt(i);
                    char sum = 'a';
                    if (startCh.equals("_")){
                        sum = (char)(currentCh - num);
                        sbDecoded.append(sum);
                    }else{
                        sum = (char)(currentCh + num);
                        sbDecoded.append(sum);
                    }
                }
                String strDecoded = String.valueOf(sbDecoded);

                memorizedValues.putIfAbsent(wholeMatch,strDecoded);//Check twice

                input = input.replace(wholeMatch,strDecoded);

            }

           Matcher matcherFinal = regexPatt.matcher(input);
            if (matcherFinal.find()){
                String wholeMatch = matcherFinal.group(0);
                String text = matcherFinal.group(3);
                String startCh =  matcherFinal.group(1);
                int num = Integer.parseInt(matcherFinal.group(4));

                StringBuilder sbDecoded = new StringBuilder();
                for (int i = 0; i < text.length(); i++) {

                    char currentCh = text.charAt(i);
                    char sum = 'a';
                    if (startCh.equals("_")){
                        sum = (char)(currentCh - num);
                        sbDecoded.append(sum);
                    }else{
                        sum = (char)(currentCh + num);
                        sbDecoded.append(sum);
                    }
                }
                String strDecoded = String.valueOf(sbDecoded);
                input = input.replace(wholeMatch,strDecoded);
            }

            System.out.println(input);


        }

    }

}
