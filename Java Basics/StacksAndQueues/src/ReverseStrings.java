import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] text = scanner.nextLine().toCharArray();
        ArrayDeque<Character> stackText = new ArrayDeque<>();

        for (int i = 0; i < text.length; i++) {
            stackText.push(text[i]);
        }
        while (!stackText.isEmpty()){
            System.out.print(stackText.pop());
        }
    }
}
