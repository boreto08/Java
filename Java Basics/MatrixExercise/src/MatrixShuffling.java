import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] dimensions = null;
        try {
            dimensions = Arrays.stream(br.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);


        }catch (Exception e){
            return;
        }

        Integer rows = dimensions[0];
        Integer cols = dimensions[1];
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix,br);

        while(true){
            String input = br.readLine();
            if (input.equals("END")){
                break;
            }

            if (!input.startsWith("swap")){
                System.out.println("Invalid input!");
                continue;
            }

            String[] tokens = input.split("\\s+");
            if (tokens.length != 5){
                System.out.println("Invalid input!");
                continue;
            }
            int rowFirst = Integer.parseInt(tokens[1]);
            int colFirst = Integer.parseInt(tokens[2]);

            int rowSec = Integer.parseInt(tokens[3]);
            int colSec = Integer.parseInt(tokens[4]);

            //Check for invalid indexes
            if ((rowFirst < 0 || rowFirst > matrix.length - 1)
                    || (colFirst < 0 || colFirst > matrix[0].length -1)
                    || (rowSec < 0 || rowSec > matrix.length - 1)
                    || (colSec < 0 || colSec > matrix[0].length -1)){
                System.out.println("Invalid input!");
                continue;

            }

            //Swap
            String buffer = matrix[rowFirst][colFirst];
            matrix[rowFirst][colFirst] = matrix[rowSec][colSec];
            matrix[rowSec][colSec] = buffer;

            printMatrix(matrix);

        }
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length ; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix,BufferedReader br) throws IOException {

        for (int row = 0; row < matrix.length; row++) {
            String[] strArr = br.readLine().split("\\s+");
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = strArr[col];
            }
        }
    }
}
