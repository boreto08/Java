import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NatureProphet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] dimensions = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer rows = dimensions[0];
        Integer cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        while (true) {
            String input = br.readLine();
            if (input.equals("Bloom Bloom Plow")) {
                break;
            }

            Integer[] coordinates = Arrays.stream(input.split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            Integer x = coordinates[0];
            Integer y = coordinates[1];

            Integer currentX = x;
            Integer currentY = y;

            if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0) {
                continue;
            }

            matrix[x][y] += 1;

            currentX -= 1;
            while (currentX  >= 0) {
                matrix[currentX][y] += 1;
                currentX--;
            }

            currentX = x;
            currentX += 1;
            while (currentX < matrix.length) {
                matrix[currentX][y] += 1;
                currentX++;
            }

            currentY -= 1;
            while (currentY >= 0){
                matrix[x][currentY] +=1;
                currentY--;
            }

            currentY = y;
            currentY +=1;
            while (currentY < matrix[0].length){
                matrix[x][currentY] +=1;
                currentY++;
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
        System.out.println();
    }

}
