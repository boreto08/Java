import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.stream.Collectors;

public class CountSameValuesArray {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = sc.readLine().split(" ");


        HashMap<String, Integer> numCount = new HashMap<>();

        for (String number : nums) {
            if (!numCount.containsKey(number)) {
                numCount.put(number, 1);
            } else {
                numCount.put(number, numCount.get(number) + 1);
            }
        }
        for (String key : numCount.keySet()) {
            System.out.println(key + " - " + numCount.get(key) + " times");
        }
    }
}
