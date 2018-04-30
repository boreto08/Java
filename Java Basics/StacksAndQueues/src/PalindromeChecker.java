import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class PalindromeChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        if (ch.length == 1){
            System.out.println(true);
            return;
        }
        if (ch.length == 2){
            if (ch[0] != ch[1]) {
                System.out.println(false);
            }
            else {
                System.out.println(true);
            }
            return;
        }

//        if (ch.length % 2 == 0){
//            System.out.println(false);
//            return;
//        }

        ArrayDeque<Character> charQueue = new ArrayDeque<>();

        for (int i = 0; i < ch.length; i++) {
            charQueue.add(ch[i]);
        }
         boolean isPalindrome = true;
        while (charQueue.size() >= 3){
            char currentFirst = charQueue.pollFirst();
            char currentLast = charQueue.pollLast();
            if (currentFirst != currentLast ){
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);



    }
}
