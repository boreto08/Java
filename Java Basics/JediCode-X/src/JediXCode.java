import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediXCode {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int lines = Integer.parseInt(br.readLine());

        for (int i = 0; i < lines; i++) {
            String currentLine  = br.readLine();
            sb.append(currentLine);
        }

        String text = String.valueOf(sb);

        String patttern1 = br.readLine();
        String patttern2 = br.readLine();

        Integer[] indexes  = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        String regexPattern1 = String.format("%s([a-zA-Z]{%d}(?![a-zA-Z]))",patttern1,patttern1.length());
        String regexPattern2 = String.format("%s([a-zA-Z0-9]{%d}(?![a-zA-Z0-9]))",patttern2,patttern2.length());

        Pattern finishedPattern1 = Pattern.compile(regexPattern1);
        Pattern finishedPattern2 = Pattern.compile(regexPattern2);

        Matcher matcher1 = finishedPattern1.matcher(text);
        Matcher matcher2 = finishedPattern2.matcher(text);

        List<String> names = new ArrayList<>();
        List<String> messages = new ArrayList<>();

        while (matcher1.find()) {

            String currentName = matcher1.group(1);
            names.add(currentName);
        }

        while (matcher2.find()) {

            String currentName = matcher2.group(1);
            messages.add(currentName);
        }

        int lenght = names.size();
        //check it twice
//        if (names.size() < messages.size()) {
//            lenght = names.size();
//        }
//        else {
//            lenght = messages.size();
//        }

        for (int i = 0; i < lenght; i++) {

            int messageNum  = indexes[i] - 1;
            String name = names.get(i);
            boolean noIndexFound = false;
            while (messageNum > messages.size() - 1){
                try {
                    messageNum = indexes[i + 1] - 1;
                }catch (Exception e ){
                    noIndexFound  = true;
                    break;
                }

            }
            if (noIndexFound){
                   continue;
            }

            String currMessage = messages.get(messageNum);

            String result = String.format("%s - %s",name,currMessage);
            System.out.println(result);

        }
    }

}
