import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsColsArr = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(rowsColsArr[0]);
        int cols = Integer.parseInt(rowsColsArr[1]);
        int[][] matrix = new int[rows][cols];

        FillMatrix(matrix,rows,cols,scanner);
        int sum = 0 ;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum );
    }


    private static void FillMatrix(int[][] matrix, int rows, int cols,Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {
            String[] numsStrArr = sc.nextLine().split(",\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = Integer.parseInt(numsStrArr[col]);
            }
        }
    }

}
