import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(matrix,scanner);

        int primaryDiagonal = sumPrimaryDiaogonal(matrix);
        int secondaryDiagonal = sumSecondaryDiagonal(matrix);

        int result = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(result);
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int startRow = 0;
        int startCol = matrix[0].length - 1;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum+= matrix[startRow + i][startCol - i];
        }
        return  sum;
    }

    private static int sumPrimaryDiaogonal(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum+= matrix[startRow + i][startCol + i];
        }

        return sum;
    }

    private static void fillMatrix(int[][] matrix,Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String[] nums = scanner.nextLine().split(" ");
            for (int col = 0; col < nums.length; col++) {
                matrix[row][col] =  Integer.parseInt(nums[col]);
            }
        }
    }
}
