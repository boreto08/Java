import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,Car> mapCar = new LinkedHashMap<>();

        int numOfCars = Integer.parseInt(scan.readLine());

        for (int i = 0; i < numOfCars; i++) {

            String[] tokens = scan.readLine().split("\\s+");

            String carName = tokens[0];
            double engineSpeed = Double.parseDouble(tokens[1]);
            double enginePower = Double.parseDouble(tokens[2]);

            double cargoWeight = Double.parseDouble(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight,cargoType);

            Tyre[] tyres = new Tyre[4];
            int skip = 0;
            for (int j = 0; j < 4; j++) {
                double tyrePressure = Double.parseDouble(tokens[5 + skip]);
                double tyreAge = Double.parseDouble(tokens[6 + skip]);
                skip += 2;
                Tyre tyre = new Tyre(tyrePressure,tyreAge);
                tyres[j] = tyre;
            }

            Car car = new Car(carName,engineSpeed,enginePower,cargo,tyres);

            mapCar.put(carName,car);

        }

        String command = scan.readLine();

        switch (command){
            case "fragile":
                mapCar.values().stream()
                        .filter(c -> c.isTherePressureUnderOne()
                                && c.getCargo().getCargoType().equals("fragile"))
                        .forEach(c -> System.out.println(c.getCarModel()));
                break;

            case "flamable":
                mapCar.values().stream()
                        .filter(c -> c.getEnginePower() > 250
                                && c.getCargo().getCargoType().equals("flamable"))
                        .forEach(c -> System.out.println(c.getCarModel()));
                break;
        }



    }

}
