import java.io.*;


public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String inputPath = ".\\input.txt";
        String outputPath = ".\\output.txt";

        try (BufferedReader in =
                     new BufferedReader(new FileReader(inputPath));
             PrintWriter out =
                     new PrintWriter(new FileWriter(outputPath))) {

            while (true) {
                String input = in.readLine();
                if (input.equals("")) {
                    break;
                }

                out.println(input.toUpperCase());
            }
        }
    }
}
