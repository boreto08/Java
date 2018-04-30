import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShockWave {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] dimensions  = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        while(true){
            String input = br.readLine();
            if (input.equals("Here We Go")){
                break;
            }

            Integer[] tokens  = Arrays.stream(input.split(" "))
                    .map(Integer::parseInt).toArray(Integer[]::new);

            int startX = tokens[0];
            int startY = tokens[1];

            int endX = tokens[2];
            int endY = tokens[3];

            for (int row = startX; row <= endX ; row++) {
                for (int col = startY; col <= endY ; col++) {
                    matrix[row][col]++;
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
