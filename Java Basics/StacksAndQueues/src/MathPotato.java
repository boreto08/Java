import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;


public class MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> kids = new ArrayDeque<>();
        String[] kidsArr = br.readLine().split(" ");
        int num = Integer.parseInt(br.readLine()) ;

        if (kidsArr.length == 1) {
            System.out.printf("Last is %s",kidsArr[0]);
            return;
        }

//        for (String kid : kidsArr) {
//            kids.add(kid);
//        }

        Collections.addAll(kids,kidsArr);

            int cycle = 1;
            while (kids.size() > 1){
                for (int i = 1; i < num; i++) {
                    String currentKid = kids.poll();
                    kids.add(currentKid);
                }

                if (isPrime(cycle)) {
                    System.out.println("Prime " + kids.peek());
                }
                else {
                    System.out.println("Removed " + kids.poll());
                }

                cycle++;

            }

        System.out.printf("Last is %s",kids.poll());
    }

    private static boolean isPrime(int num) {
        if (num <= 1 ){
            return false;
        }
        boolean prime = true;
        int divider = 2;
        int maxDivider = (int)Math.sqrt(num);
        while (divider <= maxDivider)
        {
            if (num % divider == 0)
            {
                prime = false;
                break;
            }
            divider++;
        }
        return  prime;
    }


}
