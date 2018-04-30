import java.util.Scanner;

public class SequenceMatrix {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsColsArr = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsColsArr[0]);
        int cols = Integer.parseInt(rowsColsArr[1]);
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix,scanner);

        String[] rowCountElement = checkMatrixRows(matrix);
        String elementRowSequance = rowCountElement[1];
        int lenghtRowSequance = Integer.parseInt(rowCountElement[0]);

        String[] colCountElement = checkMatrixCols(matrix);
        String elementColSequance = colCountElement[1];
        int lenghtColSequance = Integer.parseInt(colCountElement[0]);

        String[] primeDiagonalCountElement = checkMatrixPrimeDiagonal(matrix);
        String elementPrimeDiagonalSequance = primeDiagonalCountElement[1];
        int lenghtPrimeDiagonalSequance = Integer.parseInt(primeDiagonalCountElement[0]);

        String[] secondaryDiagonalCountElement = checkMatrixSecondaryDiagonal(matrix);
        String elementSecondaryDiagonalSequance = secondaryDiagonalCountElement[1];
        int lenghtSecondDiagonalSequance = Integer.parseInt(secondaryDiagonalCountElement[0]);

        if (lenghtRowSequance > lenghtColSequance
                && lenghtRowSequance > lenghtPrimeDiagonalSequance
                && lenghtRowSequance > lenghtSecondDiagonalSequance ){

            for (int i = 0; i < lenghtRowSequance; i++) {
                System.out.print(elementRowSequance + ", ");
            }
        }
        else if (lenghtColSequance > lenghtRowSequance
                && lenghtColSequance > lenghtPrimeDiagonalSequance
                && lenghtColSequance > lenghtSecondDiagonalSequance) {

            for (int i = 0; i < lenghtColSequance; i++) {
                System.out.print(elementColSequance + ", ");
            }

        }
        else if(lenghtPrimeDiagonalSequance > lenghtRowSequance
                && lenghtPrimeDiagonalSequance > lenghtColSequance
                && lenghtPrimeDiagonalSequance > lenghtSecondDiagonalSequance) {

            for (int i = 0; i < lenghtPrimeDiagonalSequance; i++) {
                System.out.print(elementPrimeDiagonalSequance + ", ");
            }

        }
        else {
            for (int i = 0; i < lenghtSecondDiagonalSequance; i++) {
                System.out.print(elementSecondaryDiagonalSequance + ", ");
            }
        }


    }

    @SuppressWarnings("Duplicates")
    private static String[] checkMatrixCols(String[][] matrix) {
        int maxLenght = 0;
        String maxElement = null;
        String[] arguments = new String[2];

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                String element = matrix[row][col];

                boolean isBroken = false;
                int counter = 0;

                for (int j = col; j < col + 1 ; j++) {
                    for (int i = row; i < matrix.length ; i++) {
                        String currentElement = matrix[i][j];

                        if (element.equals(currentElement)){
                            counter++;
                            if (counter >= maxLenght) {
                                maxLenght = counter;
                                maxElement = element;
                            }
                        }
                        else {
                            isBroken = true;
                            break;
                        }

                    }
                    if (isBroken) {
                        break;
                    }
                }
            }
        }
        arguments[0] = String.valueOf(maxLenght) ;
        arguments[1] = maxElement;
        return  arguments;
    }

    @SuppressWarnings("Duplicates")
    private static String[] checkMatrixRows(String[][] matrix) {
        int maxLenght = 0;
        String maxElement = null;
        String[] arguments = new String[2];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                String element = matrix[row][col];

                boolean isBroken = false;
                int counter = 0;

                for (int i = row; i < row + 1 ; i++) {
                    for (int j = col; j < matrix[0].length ; j++) {
                        String currentElement = matrix[i][j];

                        if (element.equals(currentElement)){
                            counter++;
                            if (counter >= maxLenght) {
                                maxLenght = counter;
                                maxElement = element;
                            }
                        }
                        else {
                            isBroken = true;
                            break;
                        }

                    }
                    if (isBroken) {
                        break;
                    }
                }
            }
        }
        arguments[0] = String.valueOf(maxLenght) ;
        arguments[1] = maxElement;
        return  arguments;
    }

    @SuppressWarnings("Duplicates")
    private static String[] checkMatrixPrimeDiagonal(String[][] matrix) {
        int maxLenght = 0;
        String maxElement = null;
        String[] arguments = new String[2];

        String startElement = matrix[0][0];
        int counter = 0 ;
        for (int i = 0; i < matrix.length && i < matrix[0].length ; i++) {
            String currnetElement = matrix[i][i];
            if (startElement.equals(currnetElement)) {
                counter++;
            }
            else{
                break;
            }

        }
        
        arguments[0] = String.valueOf(counter) ;
        arguments[1] = startElement;
        return  arguments;
    }

    private static String[] checkMatrixSecondaryDiagonal(String[][] matrix) {
        int maxLenght = 0;
        String maxElement = null;
        String[] arguments = new String[2];

        String startElement = matrix[0][matrix[0].length - 1];
        int counter = 0 ;
        for (int i = 0; i < matrix.length && i >= 0 ; i++) {
            String currnetElement = matrix[i][matrix[0].length - 1 - i];
            if (startElement.equals(currnetElement)) {
                counter++;
            }
            else{
                break;
            }

        }

        arguments[0] = String.valueOf(counter) ;
        arguments[1] = startElement;
        return  arguments;
    }

    private static void fillMatrix(String [][] matrix,Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String[] strArr = scanner.nextLine().split(" ");
            for (int col = 0; col < strArr.length; col++) {
                matrix[row][col] =  strArr[col];
            }
        }
    }
}
