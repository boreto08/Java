import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
public class Earthquake {

    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(scan.readLine());
        ArrayDeque<ArrayDeque<Integer>> store = new ArrayDeque<>();
        ArrayDeque<Integer> result = new ArrayDeque<>();

        for (int i = 0; i < number; i++) {
            Integer[] test = Arrays.stream(scan.readLine().split(" "))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            ArrayDeque<Integer> a = new ArrayDeque<>();
            Collections.addAll(a,test);
            store.addLast(a);
        }

        while (!store.isEmpty()){
            ArrayDeque<Integer> temp = store.pollFirst();
            int wave = temp.pollFirst();
            if (temp.size() > 0){
                int next = temp.pollFirst();
                boolean found = false;
                while (wave >= next){
                    if (temp.size() > 0) {
                        next = temp.pollFirst();
                    } else {
                        result.addLast(wave);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    result.addLast(wave);
                    temp.addFirst(next);
                    store.add(temp);
                }
            } else {
                result.addLast(wave);
            }
        }

        System.out.println(result.size());
        System.out.println(Arrays.toString(result.toArray()).replace("]","").replace("[","").replace(", "," "));
    }

}
