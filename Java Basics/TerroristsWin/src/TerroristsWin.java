import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TerroristsWin {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Pattern regexPatt = Pattern.compile("\\|(.*?)\\|");
        Matcher matcher = regexPatt.matcher(input);

        char[] result = null;

        while (matcher.find()) {
            char[] bombValueChArr = matcher.group(1).toCharArray();
            String wholeBomb = matcher.group(0);
            int wholeBombLenght = wholeBomb.length();
            String replaceResult = new String(new char[wholeBombLenght]).replace("\0", ".");

            int lastDigitOfSum = calcLastDigitOfSum(bombValueChArr);

            int startIndexBomb = matcher.start(0);
            int endIndexBomb = matcher.end(0);

            result = input.replace(wholeBomb, replaceResult).toCharArray();

            int rightCount = 0;
            while (rightCount <= lastDigitOfSum && endIndexBomb + rightCount <= result.length - 1) {
                try{
                    result[endIndexBomb + rightCount -1] = '.';
                }catch (Exception e){
                    break;
                }
                rightCount++;
            }

            int  leftCount = 0;
            while( leftCount >= (lastDigitOfSum * -1) && startIndexBomb + leftCount >= 0){
                result[startIndexBomb + leftCount] = '.';
                leftCount--;
            }
            input = String.valueOf(result);
        }

        System.out.println(String.valueOf(result));

    }

    private static int calcLastDigitOfSum(char[] bombChArr) {
        int result = 0;
        for (int i = 0; i < bombChArr.length; i++) {
            result += bombChArr[i];
        }
        result = result % 10;
        return result;
    }

}
