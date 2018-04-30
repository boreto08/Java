import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Highscore {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, ArrayList<Player>> mapHashMap = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([0-9]+) ([a-zA-Z0-9]+)<->([a-zA-Z0-9]+) ([0-9]+)");

        while (true) {
            String input = br.readLine();
            if (input.equals("osu!")) {
                break;
            }
            Matcher match = pattern.matcher(input);
            if (!match.find()) {
                continue;
            }

            Long firstPlScore = Long.parseLong(match.group(1));
            String firstPlName = match.group(2);

            String secPlName = match.group(3);
            Long secPlScore = Long.parseLong(match.group(4));

            Player player1 = new Player();
            player1.setName(firstPlName);

            Player player2 = new Player();
            player2.setName(secPlName);

            Long diff = 0L;
            if (firstPlScore > secPlScore) {
                diff = firstPlScore - secPlScore;
                player1.addScore(diff);
                player2.subtractScore(diff);
            } else {
                diff = secPlScore - firstPlScore;
                player2.addScore(diff);
                player1.subtractScore(diff);
            }

            player1.getOppNameScoreMap().put(player2.getName(), diff);
            if (!mapHashMap.containsKey(player1.getName())) {
                mapHashMap.put(player1.getName(), new ArrayList<>());
                mapHashMap.get(player1.getName()).add(player1);
            } else {
                mapHashMap.get(player1.getName()).add(player1);
            }

            player2.getOppNameScoreMap().put(player1.getName(), diff);
            if (!mapHashMap.containsKey(player2.getName())) {
                mapHashMap.put(player2.getName(), new ArrayList<>());
                mapHashMap.get(player2.getName()).add(player2);
            } else {
                mapHashMap.get(player2.getName()).add(player2);
            }


        }


    }

}

public class Player {

    private String name;
    private Long score = 0L;
    private LinkedHashMap<String, Long> oppNameScoreMap;


    public Player() {
        oppNameScoreMap = new LinkedHashMap<>();
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashMap<String, Long> getOppNameScoreMap() {
        return oppNameScoreMap;
    }

    public void setOppNameScoreMap(LinkedHashMap<String, Long> oppNameScoreMap) {
        this.oppNameScoreMap = oppNameScoreMap;
    }

    public void addScore(Long diff) {
        this.score = this.score + diff;
    }

    public void subtractScore(Long diff) {
        this.score = this.score - diff;
    }
}
