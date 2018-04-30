import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.asList(br.readLine().split(" "));
        List<String> chars = Arrays.asList( br.readLine().toLowerCase().split(" "));

        List<String> neededNames = names.stream()
                .filter(n -> chars.contains(String.valueOf(n.toLowerCase().charAt(0))))
                .sorted()
                .collect(Collectors.toList());

      Optional<String> finalName = neededNames.stream().findFirst();

      if (finalName.isPresent()){
          System.out.println(finalName.get());
      }
      else {
          System.out.println("No match");
      }


    }
}
