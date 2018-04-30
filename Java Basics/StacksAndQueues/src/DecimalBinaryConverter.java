import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class DecimalBinaryConverter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int  num = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (num == 0) {
            System.out.println(0);
            return;
        }


        while (num > 0){
            int reminder  = num % 2;
            num = num / 2;
            stack.push(reminder);
        }

        while (!stack.isEmpty()){

            System.out.print(stack.pop());
        }
    }
}
