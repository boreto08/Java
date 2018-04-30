import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int height = Integer.parseInt(scanner.nextLine());
        long[][] triangle = new long[height + 1][];

        for (int row = 0; row < height; row++)
        {
            triangle[row] = new long[row + 1];
        }

        //Calculate
        triangle[0][0] = 1;
        for (int row = 0; row < height - 1; row++) {
            for (int col = 0; col <= row; col++) {
                triangle[row + 1][col] += triangle[row][col];
                triangle[row + 1][col + 1] += triangle[row][col];
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print(triangle[row][col] + " ");
            }
            System.out.println();
        }
    }
}
