import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        String result = "";
        for (int i = 0; i < num.length(); i++) {
             char ch = num.charAt(i);
            switch (ch){
                case '0':
                    result += "Gee";
                    break;
                case '1':
                    result += "Bro";
                    break;
                case '2':
                    result += "Zuz";
                    break;
                case '3':
                    result += "Ma";
                    break;
                case '4':
                    result += "Duh";
                    break;
                case '5':
                    result += "Yo";
                    break;
                case '6':
                    result += "Dis";
                    break;
                case '7':
                    result += "Hood";
                    break;
                case '8':
                    result += "Jam";
                    break;
                case '9':
                    result += "Mack";
                    break;
            }

        }
        System.out.println(result);
    }
}
