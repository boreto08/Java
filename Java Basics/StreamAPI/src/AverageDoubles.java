import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class AverageDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble result = Arrays.stream(br.readLine().split(" "))
                .filter(n -> !n.isEmpty())
                .mapToDouble(Double::parseDouble)
                .average();

        System.out.println(
                result.isPresent() ? String.format("%.2f",result.getAsDouble()) : "No match");

    }
}
