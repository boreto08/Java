import java.util.Scanner;

public class MaximumSum2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rowsColsArr = scanner.nextLine().split(",\\s+");
        int rows = Integer.parseInt(rowsColsArr[0]);
        int cols = Integer.parseInt(rowsColsArr[1]);
        int[][] matrix = new int[rows][cols];
        FillMatrix(matrix,rows,cols,scanner);

        CalcMax2x2(matrix);
    }

    private static void CalcMax2x2(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int currentSum = matrix[row][col]
                                + matrix[row][col + 1]
                                + matrix[row + 1][col]
                                + matrix[row + 1][col + 1];
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.printf("%d %d\n",matrix[maxRow][maxCol],matrix[maxRow][maxCol + 1]);
        System.out.printf("%d %d\n",matrix[maxRow + 1][maxCol],matrix[maxRow + 1][maxCol + 1]);
        System.out.println(maxSum);
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
