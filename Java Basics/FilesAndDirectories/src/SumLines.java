import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        //Some tests miss space at end of the line
        String inputPath = ".\\input.txt";
        String outputPath = ".\\output.txt";

        try (BufferedReader in =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileWriter(outputPath))) {

            while (true) {

                String input = in.readLine();

                if (input.equals("")){
                    break;
                }
                int sum = 0;
                char[] chArr = input.toCharArray();
                for (char c : chArr) {
                    sum += c;
                }
                out.println(sum);

            }

        }
        

    }
}
