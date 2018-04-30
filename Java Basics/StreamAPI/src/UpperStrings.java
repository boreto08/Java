import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperStrings {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.stream(br.readLine().split(" "))
                .map(w -> w.toUpperCase())
                .forEach(w -> System.out.print(w + " "));

    }
}
