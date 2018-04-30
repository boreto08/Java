import java.io.*;
import java.math.BigInteger;

public class SumBytes {
    public static void main(String[] args) throws IOException {


        BigInteger sum = new BigInteger("0");

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

                char[] chArr = input.toCharArray();
                for (char c : chArr) {
                    int a = (int) c;
                    sum = sum.add(new BigInteger(String.valueOf(a)));
                }

            }
            out.println(sum);
        }

    }
}