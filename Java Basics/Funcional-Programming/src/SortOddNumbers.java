import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] arr  = Arrays.stream(br.readLine().split("[,\\s+]+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

       Integer[] arrEvens = Arrays.stream(arr).filter(n -> n % 2 == 0).toArray(Integer[]::new);

        for (int i = 0; i < arrEvens.length; i++) {
            if (arrEvens.length - 1 == i){
                System.out.print(arrEvens[i]);
            }
            else {
                System.out.print(arrEvens[i] + ", ");
            }
        }

        System.out.println();
        Integer[] sortedEvens = Arrays.stream(arrEvens).sorted().toArray(Integer[]::new);

        for (int i = 0; i < sortedEvens.length; i++) {
            if (sortedEvens.length - 1 == i){
                System.out.print(sortedEvens[i]);
            }
            else {
                System.out.print(sortedEvens[i] + ", ");
            }
        }

    }
}
