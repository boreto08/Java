import java.util.Scanner;

public class AverageThreeNumbers {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double num1 = console.nextDouble();
        double num2 = console.nextDouble();
        double num3 = console.nextDouble();

        double average = (num1 + num2 + num3) / 3;
        System.out.printf("%.2f",average);
    }
}
