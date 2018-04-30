import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stackNums = new ArrayDeque<>();
        HashSet<Integer> maxNums = new HashSet<>();

        int numOfCommands = Integer.parseInt(br.readLine());

        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i <  numOfCommands; i++) {

            Integer[] tokens = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            int command = tokens[0];
            int element = 0;
            if (command  == 1){
                element = tokens[1];
            }


            switch (command){
                case 1:
                    stackNums.push(element);
                    if (element > maxElement){

                        maxElement = element;
                        maxNums.add(maxElement);
                    }
                    break;
                case 2:
                   int currentElement = stackNums.pop();

                   if (maxNums.contains(currentElement)){
                        maxNums.remove(currentElement);
                        if (maxNums.size() > 0){
                            maxElement = Collections.max(maxNums);
                       }
                       else {
                            maxElement = Integer.MIN_VALUE;
                       }
                   }
                    break;
                case 3 :
                    Integer maxNum = Collections.max(maxNums);
                    System.out.println(maxNum);

            }

        }
    }
}
