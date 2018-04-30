import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BasicStackOp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] tokens  = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        int numsToAdd = tokens[0];
        int timesToPop = tokens[1];
        int numToCheck = tokens[2];

//        ArrayDeque<Integer> stackNums = Arrays.stream(br.readLine().split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stackNums = new ArrayDeque<>();

        Integer[] numsArr  = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        for (int i = 0; i < numsArr.length; i++) {
            stackNums.push(numsArr[i]);
        }



        for (int i = 0; i < timesToPop; i++) {
            stackNums.pop();
        }

        if (stackNums.contains(numToCheck)){
            System.out.println(true);
            return;
        }
        Integer min = stackNums.stream().min(Integer::min).get();
        System.out.println(min);






    }
}
