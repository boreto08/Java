import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr  = br.readLine().split("[,\\s+]+");


        int sum = Arrays.stream(arr).mapToInt(Integer::parseInt).sum();

        System.out.printf("Count = %d\n",arr.length);
        System.out.printf("Sum = %d",sum);



    }
}
