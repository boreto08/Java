import java.util.Scanner;

public class SquaresMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix,scanner);

        int counterSquares = findEqualSquare(matrix);
        System.out.println(counterSquares);


    }

    private static int findEqualSquare(String[][] matrix) {
        int counter =0;
        for (int row = 0; row < matrix.length -1 ; row++) {
            for (int col = 0; col < matrix[0].length -1 ; col++) {
                if (matrix[row][col].equals(matrix[row][col + 1])
                        && matrix[row][col].equals(matrix[row + 1][col])
                        && matrix[row][col].equals(matrix[row + 1][col + 1])) {
                    counter++;
                }
            }
        }
        return  counter;
        
    }

    private static void fillMatrix(String[][] matrix,Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String[] letters = scanner.nextLine().split(" ");
            for (int col = 0; col < letters.length; col++) {
                matrix[row][col] =  letters[col];
            }
        }
    }
}
