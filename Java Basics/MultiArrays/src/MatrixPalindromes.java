import java.util.Scanner;

public class MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] argum = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(argum[0]);
        int cols = Integer.parseInt(argum[1]);
        String[][] matrix =  new String[rows][cols];


        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[0].length; col++) {
                //Genegaring palindromes
                StringBuilder sb = new StringBuilder();
                sb.append(alphabet[row]);
                sb.append(alphabet[row + col]);
                sb.append(alphabet[row]);
                matrix[row][col] = String.valueOf(sb);
            }
            
        }
      PrintMatrix(matrix);
    }

    private static void PrintMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
