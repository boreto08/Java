import java.util.Scanner;

public class readInput {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String word1 = console.next("\\w+");
        String word2 = console.next("\\w+");

        int num1 = console.nextInt();
        int num2 = console.nextInt();
        int num3 = console.nextInt();

        int sum = num1 + num2 + num3;
        console.nextLine();
        String  word3 = console.nextLine();

        System.out.println( word1 + " " + word2 + " " + word3 + " " + sum);
    }

}
