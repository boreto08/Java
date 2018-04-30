import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by boreto on 2/9/2017.
 */
public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] arr = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

          Arrays.stream(arr)
                .distinct()
                .filter(n -> n >= 10 && n <= 20)
                .limit(2)
                .forEach(n -> System.out.print(n + " "));



    }
}
