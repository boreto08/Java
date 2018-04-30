import java.util.ArrayDeque;
        import java.util.Collections;
        import java.util.Scanner;


public class SimpleCalculator_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack,tokens);

        while (stack.size() > 1){
            int firstValue = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int secondValue = Integer.parseInt(stack.pop());
            String currentResult = "";
            switch (op){
                case "+":
                    currentResult = String.valueOf(firstValue + secondValue);
                    break;
                case "-": currentResult = String.valueOf(firstValue - secondValue);
                    break;
            }
            stack.push(currentResult);
        }
        System.out.println(stack.poll());
    }

}
