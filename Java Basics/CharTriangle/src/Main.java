import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int num = input.nextInt();

        for (int i = 0; i <= num ; i++) {
            for (char j = 'a'; j < 'a' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        char startChar = (char)((int)'a' + num);


        for (int i = 0; i < num -1 ; i++) {
            for (int j = num - i - 1, ch = 'a' ; j > 0  ; j--,ch++)
            {
                System.out.print((char) ch + " ");
            }
            System.out.println();
        }

    }
}

