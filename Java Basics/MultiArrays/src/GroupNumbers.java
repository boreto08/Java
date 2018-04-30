import java.util.ArrayList;
import java.util.Scanner;

public class GroupNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(",\\s+");

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(0, new ArrayList<>());
        matrix.add(1, new ArrayList<>());
        matrix.add(2, new ArrayList<>());

        for (String num : nums) {
            int currentInt = Integer.parseInt(num);
            matrix.get(Math.abs(currentInt % 3)).add(currentInt);
        }
        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
