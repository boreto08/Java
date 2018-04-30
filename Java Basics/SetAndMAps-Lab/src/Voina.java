import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> playerOneCards = new LinkedHashSet<>();
        Set<Integer> playerTwoCards = new LinkedHashSet<>();

        playerOneCards  = Arrays.stream(sc.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        playerTwoCards  = Arrays.stream(sc.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int cycles = 50;
        for (int i = 0; i < cycles ; i++) {

            if (playerOneCards.isEmpty() || playerTwoCards.isEmpty()){
                break;
            }

            int topNumPlayerOne = playerOneCards.iterator().next();
            playerOneCards.remove(topNumPlayerOne);

            int topNumPlayerTwo = playerTwoCards.iterator().next();
            playerTwoCards.remove(topNumPlayerTwo);

            if (topNumPlayerOne > topNumPlayerTwo){
                  playerOneCards.add(topNumPlayerOne);
                  playerOneCards.add(topNumPlayerTwo);

            }else if(topNumPlayerOne < topNumPlayerTwo) {
                playerTwoCards.add(topNumPlayerOne);
                playerTwoCards.add(topNumPlayerTwo);

            }else{
                continue;
            }
        }

        if (playerOneCards.size() > playerTwoCards.size()){
            System.out.println("First player win!");
        }else if(playerOneCards.size() < playerTwoCards.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }


    }
}
