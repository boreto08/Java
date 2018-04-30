import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String[] flowersArray = buffReader.readLine().split("\\s+");
        String[] bucketsArray = buffReader.readLine().split("\\s+");

        LinkedList<Integer> flowers = new LinkedList<>();
        Stack<Integer> buckets = new Stack<>();
        addToCollection(flowersArray, flowers);
        addToCollection(bucketsArray,buckets);

        LinkedList<Integer> secondNatureFlowers = new LinkedList<>();

        while (!flowers.isEmpty() && !buckets.isEmpty()) {
            int currentFlower = flowers.peek();
            int currentBucket = buckets.peek();

            int restOfBucket = currentBucket - currentFlower;

            if (restOfBucket == 0) {
                secondNatureFlowers.add(currentFlower);
                buckets.pop();
            }
            if (restOfBucket > 0 && buckets.size() > 1) {
                buckets.pop();
                int nextBucket= buckets.pop() + restOfBucket;
                buckets.push(nextBucket);
            } else if (restOfBucket > 0 && buckets.size() == 1 && !flowers.isEmpty()) {
                buckets.pop();
                buckets.push(restOfBucket);
            }
            flowers.poll();
            if (restOfBucket < 0) {
                currentFlower -= currentBucket;
                buckets.pop();
                flowers.addFirst(currentFlower);
            }

        }

        printResult(flowers, buckets, secondNatureFlowers);
    }

    private static void printResult(LinkedList<Integer> flowers, Stack<Integer> buckets, LinkedList<Integer>
            secondNatureFlowers) {
        if (flowers.size() == 0) {
            while (!buckets.isEmpty()) {
                System.out.print(buckets.pop() + " ");
            }
        } else {
            for (Integer flower : flowers) {
                System.out.printf("%d ", flower);
            }
        }
        System.out.println();
        System.out.println(secondNatureFlowers.size() > 0 ? String.join(" ", secondNatureFlowers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList())) : "None");
    }

    private static void addToCollection(String[] array, Collection<Integer> collection) {
        for (String item: array) {
            collection.add(Integer.valueOf(item));
        }
    }
}