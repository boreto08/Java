import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Plus_Removal {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<List<String>> matrix = new ArrayList<>();

        String commandLine = reader.readLine();

        while (!commandLine.equals("END")) {
            List<String> currentLine = new ArrayList<>();

            for (int i = 0; i < commandLine.length(); i++) {
                currentLine.add(String.valueOf(commandLine.charAt(i)));
            }
            matrix.add(currentLine);

            commandLine = reader.readLine();
        }

        List<int[]> indexes = new ArrayList<>();

        for (int row = 0; row < matrix.size() - 2; row++) {
            for (int col = 1; col < matrix.get(row).size(); col++) {
                String currenElem = matrix.get(row).get(col);
                
                try {
                    
                    if (!"".equals(currenElem)
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 1).get(col - 1).toLowerCase())
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 1).get(col).toLowerCase())
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 1).get(col + 1).toLowerCase())
                            && matrix.get(row).get(col).toLowerCase().equals(matrix.get(row + 2).get(col).toLowerCase())) {

                        indexes.add(new int[]{row,col});
                        indexes.add(new int[]{row + 1,col - 1});
                        indexes.add(new int[]{row + 1, col});
                        indexes.add(new int[]{row + 1, col + 1});
                        indexes.add(new int[]{row + 2, col});
                    }
                    
                }catch (IndexOutOfBoundsException e){
                    
                }
            }
        }

        for (int[] index : indexes) {
            matrix.get(index[0]).set(index[1], "");
        }

        for (List<String> strings : matrix) {
            for (String string : strings) {
                if (!string.isEmpty()) {
                    System.out.print(string);
                }
            }
            System.out.println();
        }



    }

}
