import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        TreeMap<String,Double> studentGradesDic = new TreeMap<>();

        for (int i = 0; i < count; i++) {

            String name = br.readLine();
            Double[] grades = Arrays.stream(br.readLine().split(" "))
                    .map(Double::parseDouble).toArray(Double[]::new);

            Double average = 0.0;

            for (Double grade : grades) {
                average+=grade;
            }

            average = average/ grades.length;

            if (!studentGradesDic.containsKey(name)){
                studentGradesDic.put(name,average);
            }

        }

        for (Map.Entry<String, Double> student : studentGradesDic.entrySet()) {

            System.out.printf("%s is graduated with %s\n",student.getKey(),student.getValue());
        }


    }
}
