import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Pattern pattern = Pattern.compile("Rotate(\\((\\d+)\\))");
        Matcher matcher = pattern.matcher(input);
        String[][] result;

        String num;
        int degees = 0;
        if (matcher.find()) {
            num = matcher.group(2);
            degees = Integer.parseInt(num);
        }


        List<List<String>> matrix = new ArrayList<>();
        int maxLenght = Integer.MIN_VALUE;

        while (true) {
            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }
            List<String> matrixRow = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                matrixRow.add(String.valueOf(line.charAt(i)));
            }
            if (matrixRow.size() > maxLenght) {
                maxLenght = matrixRow.size();
            }
            matrix.add(matrixRow);
        }

        degees = degees / 90;
        if (degees % 4 == 0 || degees == 0) {
            printMatrix(matrix);
            return;
        }
        if (degees >= 9) {
            int timesToRotate = degees / 9;
            if (timesToRotate > 4) {
                while (timesToRotate > 4) {
                    timesToRotate /= 4;
                }
            }
            result = rotateToPosition(timesToRotate, matrix, maxLenght);

        }else {
            result = rotateToPosition(degees, matrix, maxLenght);
        }

        printArray(result);

    }

    public static void printMatrix(List<List<String>> matrix) {
        for (List<String> strings : matrix) {
            System.out.println(String.join("", strings));
        }
    }

    public static String[][] rotateToPosition(int position, List<List<String>> matix, int maxLenght) {
        String[][] rotatedMatrix = new String[1][];
        switch (position) {
            case 1:
                rotatedMatrix = rotatePosOne(matix, maxLenght);
                break;
            case 2:
                rotatedMatrix = rotatePosTwo(matix,maxLenght);
                break;
            case 3:
                rotatedMatrix = rotatePosThree(matix,maxLenght);
                break;
        }
        return rotatedMatrix;
    }

    private static String[][] rotatePosOne(List<List<String>> matix, int maxLenght) {
        String[][] rotatedMatrix = new String[maxLenght][matix.size()];
        for (int col = 0; col < matix.size(); col++) {
            List<String> line = matix.get(matix.size() - 1 - col);
            //filling rotated matrix
            for (int rowFilled = 0; rowFilled < line.size(); rowFilled++) {
                rotatedMatrix[rowFilled][col] = line.get(rowFilled);
            }
        }
        return rotatedMatrix;
    }

    private static String[][] rotatePosTwo(List<List<String>> matix,int maxLenght){
        String[][] rotatedMatrix = new String[matix.size()][maxLenght];
        for (int row = 0; row < matix.size(); row++) {
            List<String> currentRow = matix.get(matix.size() - 1 - row);
            for (int col = 0; col < maxLenght; col++) {
                try{
                    rotatedMatrix[row][rotatedMatrix[0].length - 1 - col] = currentRow.get(col);
                }catch(IndexOutOfBoundsException e){
                    rotatedMatrix[row][rotatedMatrix[0].length - 1 - col] = "";
                }
            }
        }
        return rotatedMatrix;
    }

    private static String[][] rotatePosThree(List<List<String>> matix, int maxLenght) {
        String[][] rotatedMatrix = new String[maxLenght][matix.size()];
        for (int col = 0; col < matix.size(); col++) {
            List<String> line = matix.get(matix.size() - 1 - col);
            //filling rotated matrix
            for (int rowFilled = 0; rowFilled < line.size(); rowFilled++) {
                int rows = rotatedMatrix.length - 1 - rowFilled;
                int cols = rotatedMatrix[0].length - 1 - col;
                rotatedMatrix[rows][cols] = line.get(rowFilled);
            }
        }
        return rotatedMatrix;
    }

    private static void printArray(String[][] rotatedMatrix) {
        for (int row = 0; row < rotatedMatrix.length; row++) {
            for (int col = 0; col < rotatedMatrix[0].length; col++) {
                if (rotatedMatrix[row][col] == null) {
                    rotatedMatrix[row][col] = "";
                    System.out.print(rotatedMatrix[row][col]);
                }else{
                    System.out.print(rotatedMatrix[row][col]);
                }
            }
            System.out.println();
        }
    }

}
