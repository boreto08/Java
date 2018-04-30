import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        double a = Double.parseDouble(nums[0]);
        double b = Double.parseDouble(nums[1]);

        double area = a * b;

        System.out.printf("%.2f",area);
    }
}
