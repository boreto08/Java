import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class CalculateSequenceQueue {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        Deque<Long> queueNums = new ArrayDeque<>();
        queueNums.add(n);

        for (int i = 0; i < 50; i++) {
            Long element = queueNums.poll();

            System.out.printf("%d ",element);

            long s2 = element + 1;
            long s3 = (2*element) + 1;
            long s4 = element + 2;

            queueNums.add(s2);
            queueNums.add(s3);
            queueNums.add(s4);
        }



    }
}
