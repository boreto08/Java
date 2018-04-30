import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Car> mapCars = new LinkedHashMap<>();

        int numCars = Integer.parseInt(scan.readLine());

        for (int i = 0; i < numCars; i++) {

            String[] tokens = scan.readLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);

            mapCars.putIfAbsent(model, car);
        }

        while (true) {
            String input = scan.readLine();
            if (input.equals("End")) {
                break;
            }
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String model = tokens[1];
            double kmToTravel = Double.parseDouble(tokens[2]);

            if (!command.equals("Drive") || !mapCars.containsKey(model)) {
                continue;
            }

            if (!mapCars.get(model).canItDrive(kmToTravel)){
                System.out.println("Insufficient fuel for the drive");
            }

        }

        mapCars.values().stream().forEach(c -> {
            String model = c.getModel();
            double fuelAmount = c.getFuelAmount();
            double distanceTraveled = c.getDistanceTraveled();
            System.out.printf("%s %.2f %s\n",model,fuelAmount,(int)distanceTraveled);
        });

    }

}
