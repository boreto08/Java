import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main
{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queueFlowers = new ArrayDeque<>();
        Deque<Integer> stackBuckets = new ArrayDeque<>();
        List<String> secondNature = new ArrayList<>();

       Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .forEach(e -> queueFlowers.offer(e));

        Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .forEach(e -> stackBuckets.push(e));

        int leftWater = 0;
        while (!queueFlowers.isEmpty() && !stackBuckets.isEmpty()){

            int flowerValue = queueFlowers.remove();
            int bucketValue = stackBuckets.pop();

            if (bucketValue > flowerValue){

                leftWater = bucketValue - flowerValue;
                int totalWater = stackBuckets.pop() + leftWater;
                stackBuckets.push(totalWater);

            }else if(bucketValue == flowerValue){
                secondNature.add(String.valueOf(flowerValue));
            }
            else  if(bucketValue < flowerValue){
                boolean hasDone = false;
                while (bucketValue < flowerValue && !stackBuckets.isEmpty()) {
                    bucketValue += stackBuckets.pop();
                    if (bucketValue > flowerValue) {
                        //TODO check if the leftover water needs to go to another bucket
                        leftWater = bucketValue - flowerValue;
                        hasDone =true;
                        break;
                    } else if (bucketValue == flowerValue) {
                        secondNature.add(String.valueOf(flowerValue));
                        hasDone = true;
                        break;
                    }
                }
                if (!hasDone){
                    queueFlowers.addFirst(flowerValue - bucketValue);
                }

            }
        }
        
        if (stackBuckets.isEmpty()){
            for (Integer flower : queueFlowers) {
                System.out.print(flower + " ");
            }
            System.out.println();
        }
        else {
            for (Integer stackBucket : stackBuckets) {
                System.out.print(stackBucket + " ");
            }
            System.out.println();
        }

        if (secondNature.isEmpty()){
            System.out.println("None");
        }
        else {
            secondNature.stream().map(Integer::parseInt)
                    .forEach(e -> System.out.print(e + " "));
        }

    }

}
