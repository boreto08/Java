import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokensStudent = reader.readLine().split("\\s+");
        String firstNameSt = tokensStudent[0];
        String secNameSt = tokensStudent[1];
        String facultyNum = tokensStudent[2];
        Student student = new Student(firstNameSt,secNameSt,facultyNum);

        String[] tokensWorker = reader.readLine().split("\\s+");
        String firstName = tokensWorker[0];
        String secName   = tokensWorker[1];
        double weekSalary  = Double.parseDouble(tokensWorker[2]);
        double workHoursPerDay  = Double.parseDouble(tokensWorker[3]);

        Worker worker = new Worker(firstName,secName,weekSalary,workHoursPerDay);

        System.out.println(student.toString());
        System.out.println();
        System.out.println(worker.toString());

    }

}
