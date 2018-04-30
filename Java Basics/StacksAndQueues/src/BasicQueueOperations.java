import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] tokens = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int numsToAdd = tokens[0];
        int timesToRemove = tokens[1];
        int numToCheck = tokens[2];

        ArrayDeque<Integer> queueNums = new ArrayDeque<>();

        Integer[] nums = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        for (int i = 0; i < numsToAdd; i++) {
            queueNums.offer(nums[i]);
        }

        for (int j = 0; j < timesToRemove ; j++) {
            queueNums.poll();
        }

        if (queueNums.contains(numToCheck)){
            System.out.println(true);
        }
        else {
            if (queueNums.size() > 0){
                int minElement = Collections.min(queueNums);
                System.out.println(minElement);
            }
            else {
                System.out.println(0);
            }

        }

    }
}
