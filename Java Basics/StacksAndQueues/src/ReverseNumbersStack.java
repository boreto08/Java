import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseNumbersStack {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] nums = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }


    }
}
