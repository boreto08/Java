import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");

        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[row][col];

        fillMatrix(matrix,reader);

        while(true){
            String input = reader.readLine();
            if (input.equals("END")){
                break;
            }
            String[] tokens = input.split(" ");
            if (tokens.length != 5){
                System.out.println("Invalid input!");
                continue;
            }

            int e1Row = Integer.parseInt(tokens[1]);
            int e1Col = Integer.parseInt(tokens[2]);

            int e2Row = Integer.parseInt(tokens[3]);
            int e2Col = Integer.parseInt(tokens[4]);

            if (!tokens[0].equals("swap")
                    || e1Row >= matrix.length || e2Row >= matrix.length
                    || e1Col >= matrix[0].length || e2Col >= matrix[0].length
                    || e1Row < 0 || e1Col < 0 || e2Row < 0 || e2Col <0){
                System.out.println("Invalid input!");
                continue;
            }

            String buffer = matrix[e1Row][e1Col];
            matrix[e1Row][e1Col] = matrix[e2Row][e2Col];
            matrix[e2Row][e2Col] = buffer;
            
            printMatrix(matrix);
        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            List<String> currentRow = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                currentRow.add(matrix[i][j]);
            }
            System.out.println(currentRow.toString().replace("]","").replace("[","").replace(", "," "));
        }
    }

    private static void fillMatrix(String[][] matrix,BufferedReader reader) throws IOException {

        for (int i = 0; i <matrix.length ; i++) {
            String[] elemnts = reader.readLine().split(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = elemnts[j];
            }
        }
    }

}
