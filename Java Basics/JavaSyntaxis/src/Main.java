
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        double b = console.nextDouble();
        double c = console.nextDouble();
        String aToBinary = Integer.toString(a,2);
        String binary = String.format("%010d", Integer.parseInt(aToBinary));

        System.out.printf("%-10X|%s|%10.2f|%-10.3f|",a,binary,b,c);
    }
}
