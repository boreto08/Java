import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Earthquake {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0 ) {
            return;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> currentSizes = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            ArrayDeque<Integer> tokenesQueue = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
            int currntSize = 0;

            int currentSeicmicity = tokenesQueue.remove();

            while (!tokenesQueue.isEmpty()) {
                int currentWave = tokenesQueue.peek();
                if (currentSeicmicity < currentWave) {
                    count++;
                    result.add(currentSeicmicity);
                    break;
                } else {
                    tokenesQueue.remove();
                }
            }

            if (tokenesQueue.isEmpty()) {
                currntSize = 1;
                currentSizes.add(currntSize);
                queue.add(currentSeicmicity);
            }else{
                currntSize = tokenesQueue.size();
                currentSizes.add(currntSize);
                while (!tokenesQueue.isEmpty()) {
                    int currE = tokenesQueue.remove();
                    queue.add(currE);
                }
            }


        }


        while(!queue.isEmpty()){

            int currentSeismicity  = queue.remove();
            int sizeAfterRemoval = currentSizes.peek();
            int size = currentSizes.remove();

            if (size == 1){
                 result.add(currentSeismicity);
                 //currentSizes.remove();
                 count++;
                 continue;
            }
            boolean hasEntered = false;
            for (int i = 0; i < size - 1; i++) {

                int currWave = queue.peek();
                if (currentSeismicity >= currWave){
                    sizeAfterRemoval--;
                    queue.remove();
                }else {
                     hasEntered = true;
                     result.add(currentSeismicity);
                     sizeAfterRemoval--;
                     count++;
                     break;
                }
            }

            if (!hasEntered){
//                queue.add(currentSeismicity);
//                sizeAfterRemoval = 1;
//                currentSizes.add(sizeAfterRemoval);
//                continue;
                result.add(currentSeismicity);
                count++;
                continue;
            }

            currentSizes.add(sizeAfterRemoval);
            for (int i = 0; i < sizeAfterRemoval; i++) {
                int currE = queue.remove();
                queue.add(currE);
            }

        }


        System.out.println(count);
        for (int i = 0; i < result.size() ; i++) {

                System.out.print(result.get(i) + " ");


        }

    }


}


