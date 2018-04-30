import java.util.Scanner;

public class FillMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arguments = scanner.nextLine().split(", ");
        int matrixSize = Integer.parseInt(arguments[0]);
        String pattern = arguments[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        if (pattern.equals("A")) {
            FillPatternA(matrix);
        }else{
            FillPatternB(matrix);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void FillPatternA(int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row <matrix.length ; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }

    private static void FillPatternB(int[][] matrix) {
        int counter = 1;
        boolean isEven = true;
        for (int col = 0; col < matrix[0].length; col++) {
            if (isEven == true) {
                for (int row = 0; row <matrix.length ; row++) {
                    matrix[row][col] = counter;
                    counter++;

                }
                isEven = false;
            }else{
                for (int row =matrix.length-1 ; row >= 0 ; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
                isEven = true;
            }

        }
        }
    }

