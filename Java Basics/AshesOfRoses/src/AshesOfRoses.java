import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AshesOfRoses {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<String, Long>> regionsRosesMap = new HashMap<>();

        Pattern pattern = Pattern.compile("^Grow <[A-Z][a-z]+> <[a-zA-Z0-9]+> [0-9]+$");

        while (true) {
            String input = br.readLine();
            if (input.equals("Icarus, Ignite!")) {
                break;
            }

            Matcher matcher = pattern.matcher(input);
            if (!matcher.find()) {
                continue;
            }

            String[] inputArr = input.split(" ");

            String region = inputArr[1].replaceAll("[<>]", "");
            String color = inputArr[2].replaceAll("[<>]", "");

            String strValue = inputArr[inputArr.length - 1];

            Long value = Long.parseLong(strValue);

            if (!regionsRosesMap.containsKey(region)) {
                regionsRosesMap.put(region, new HashMap<>());

            }
            if(!regionsRosesMap.get(region).containsKey(color)){
                regionsRosesMap.get(region).put(color,0L);
            }

            value = value + regionsRosesMap.get(region).get(color);
            regionsRosesMap.get(region).put(color,value);
        }

        regionsRosesMap.entrySet().stream().sorted((region1, region2) -> {
            Long sum1 = region1.getValue().values().stream().mapToLong(e -> e).sum();
            Long sum2 = region2.getValue().values().stream().mapToLong(e -> e).sum();

            if (sum1 == sum2) {
                return region1.getKey().compareTo(region2.getKey());
            }
            return Long.compare(sum2, sum1);
        }).forEach(region -> {
                    System.out.println(region.getKey());
                    region.getValue().entrySet().stream().sorted((color1, color2) -> {
                        if (Long.compare(color1.getValue(), color2.getValue()) == 0) {
                            return color1.getKey().compareTo(color2.getKey());
                        }
                        return  Long.compare(color1.getValue(), color2.getValue());
                    }).forEach(color -> System.out.println("*--" + color.getKey() + " | " + color.getValue()));
                }
        );


    }


}
