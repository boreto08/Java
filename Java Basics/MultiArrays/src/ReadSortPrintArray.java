import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ReadSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] namesArr = new String[num];
        for (int i = 0; i < num; i++) {
            namesArr[i] = scanner.nextLine();
        }
        Arrays.sort(namesArr);

        for (int i = 0; i < namesArr.length; i++) {
            System.out.println(namesArr[i]);
        }

    }
}
