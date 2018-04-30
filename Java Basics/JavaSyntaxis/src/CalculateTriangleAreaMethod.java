import java.util.Scanner;

public class CalculateTriangleAreaMethod {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();

        CalculateTriangleArea(base, height);

    }

    private static void CalculateTriangleArea(double base, double height) {

        double area = (base * height)/2;
        System.out.printf("Area = %.2f",area);
    }
}
