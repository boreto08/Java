import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class ActivityTracker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,HashMap<String,Integer>> mapUsersTime = new TreeMap<>();

        int lines = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < lines; i++) {

            String[] tokens = br.readLine().split(" ");

            String[] dateTokens = tokens[0].split("/");
            String monthStr  = dateTokens[1];
            int month = Integer.parseInt(monthStr);

            String currentName = tokens[1];
            Integer currentTime = Integer.parseInt(tokens[2]);

            if (!mapUsersTime.containsKey(month)){
               mapUsersTime.put(month,new HashMap<>());
               mapUsersTime.get(month).put(currentName,currentTime);
            }else{
                if (!mapUsersTime.get(month).containsKey(currentName)){
                    mapUsersTime.get(month).put(currentName,currentTime);
                }else{
                    Integer timeBefore = mapUsersTime.get(month).get(currentName);
                    mapUsersTime.get(month).put(currentName,currentTime + timeBefore);
                }
            }
        }

        List<String> result = new ArrayList<>();
        mapUsersTime.entrySet()
                .stream()
                .forEach( x -> {
                    System.out.print(x.getKey() + ": ");

                    x.getValue().entrySet().stream().sorted((user1,user2) -> {
                        Integer timeUser1 = user1.getValue();
                        Integer timeUser2 = user2.getValue();
                        if (user1.getValue() > user2.getValue()){
                            return  -1;
                        }
                        else {
                            return  1;
                        }
                        
                    }).forEach(e -> {
                        String currentElement  = String.format("%s(%d)",e.getKey(),e.getValue()) ;
                        result.add(currentElement);
                    });
                    System.out.println(String.join(", ",result));
                    result.clear();
                });

    }
}

