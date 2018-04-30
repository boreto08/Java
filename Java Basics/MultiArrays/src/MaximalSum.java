import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] rowsColsArr = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsColsArr[0]);
        int cols = Integer.parseInt(rowsColsArr[1]);
        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix,scanner);

        int[] argumets = findMaxSum(matrix);

        System.out.printf("Sum = %d\n",argumets[0]);

        printSumMatrix(matrix,argumets[1],argumets[2]);
        
    }

    private static int[] findMaxSum(int[][] matrix) {
        int maxSum = 0;
        int maxRow = 0;
        int maxCol = 0;
        int[] args = new int[3];

        for (int row = 0; row < matrix.length -2; row++) {
            for (int col = 0; col < matrix[0].length -2 ; col++) {
                int currentSum = 0;
                currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        args[0] = maxSum;
        args[1] = maxRow;
        args[2] = maxCol;
        return args;
    }

    private static void fillMatrix(int[][] matrix,Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String[] nums = scanner.nextLine().split(" ");
            for (int col = 0; col < nums.length; col++) {
                matrix[row][col] =  Integer.parseInt(nums[col]);
            }
        }
    }

    private static void printSumMatrix(int [][] matrix,int startRow,int startCol) {
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3 ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
