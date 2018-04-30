import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chArrInput = input.toCharArray();

        ArrayDeque<Integer> tokens = new ArrayDeque<>();

        for (int index = 0; index < chArrInput.length; index++) {
            if (chArrInput[index] == '(') {
                tokens.push(index);
            }
            else if(chArrInput[index] == ')'){
                int startIndex = tokens.pop();
                String result = input.substring(startIndex,index + 1);
                System.out.println(result);
            }
        }

    }
}
