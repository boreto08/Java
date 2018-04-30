import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> kids = new ArrayDeque<>();
        String[] kidsArr = br.readLine().split(" ");
        int num = Integer.parseInt(br.readLine()) ;

        if (kidsArr.length == 1) {
            System.out.printf("Last is %s",kidsArr[0]);
            return;
        }

        for (String kid : kidsArr) {
            kids.add(kid);
        }
        int counter = 1;
        while (kids.size() > 1){
            String currentKid = kids.poll();
            if (counter % num == 0) {
                System.out.printf("Removed %s\n",currentKid);
                counter++;
                continue;
            }
            kids.add(currentKid);
            counter++;
        }

        System.out.printf("Last is %s",kids.poll());




    }
}
