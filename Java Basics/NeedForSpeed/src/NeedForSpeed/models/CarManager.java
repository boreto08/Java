package NeedForSpeed.models;

import NeedForSpeed.models.Cars.Car;
import NeedForSpeed.models.Cars.PerformanceCar;
import NeedForSpeed.models.Cars.ShowCar;
import NeedForSpeed.models.Races.CasualRace;
import NeedForSpeed.models.Races.DragRace;
import NeedForSpeed.models.Races.DriftRace;
import NeedForSpeed.models.Races.Race;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CarManager {

    private LinkedHashMap<Integer, Car> cars;
    private LinkedHashMap<Integer, Race> races;
    private Garage garage;

    public CarManager(){
        this.cars  = new LinkedHashMap<>();
        this.races  = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model,
                         int yearOfProduction, int horsepower,
                         int acceleration, int suspension, int durability) {

        if (type.equals("Performance")) {
            Car perfCar =
                    new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension,
                            durability);
            cars.put(id, perfCar);
        } else if (type.equals("Show")) {
            Car showCar =
                    new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            cars.put(id, showCar);
        }

    }

    public String check(int id) {
        String result = "";
        if (cars.containsKey(id)){
           result = this.cars.get(id).toString();
        }
        return result;
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        if (type.equals("Casual")){
            Race casualRace = new CasualRace(length,route,prizePool);
            races.put(id,casualRace);
        }else if(type.equals("Drag")){
            Race dragRace = new DragRace(length,route,prizePool);
            races.put(id,dragRace);
        }else if(type.equals("Drift")){
            Race driftRace = new DriftRace(length,route,prizePool);
            races.put(id,driftRace);
        }
    }

    public void participate(int carId, int raceId) {
        if (!this.cars.containsKey(carId) || !this.races.containsKey(raceId)){
            return;
        }
        Car car = this.cars.get(carId);
        if (car.getIsParked()){
            return;
        }
        car.race();
        Race race = this.races.get(raceId);
        race.addParticipant(carId,car);
    }

    public String start(int id) {
        if (this.races.containsKey(id) || this.races.get(id).countParticipants() < 1) {
            return "";
        }
        LinkedHashMap<Integer, Integer> idScoresMap = new LinkedHashMap<>();

        Race race = this.races.get(id);
        int powerScore = 0;

        if (race.getClass().getName().equals("Casual")) {
            for (Map.Entry<Integer, Car> integerCarEntry : race.getParticipants().entrySet()) {
                Car car = integerCarEntry.getValue();
                powerScore = (car.getHorsepower() / car.getAcceleration()) + (car.getDurability() + car.getSuspension());
                idScoresMap.put(integerCarEntry.getKey(), powerScore);
            }
        } else if (race.getClass().getName().equals("Drag")) {
            for (Map.Entry<Integer, Car> integerCarEntry : race.getParticipants().entrySet()) {
                Car car = integerCarEntry.getValue();
                powerScore = (car.getHorsepower() / car.getAcceleration());
                idScoresMap.put(integerCarEntry.getKey(), powerScore);
            }
        } else if (race.getClass().getName().equals("Drift")) {
            for (Map.Entry<Integer, Car> integerCarEntry : race.getParticipants().entrySet()) {

                Car car = integerCarEntry.getValue();
                powerScore = (car.getDurability() + car.getSuspension());
                idScoresMap.put(integerCarEntry.getKey(), powerScore);
            }
        }

       LinkedHashMap<Integer,Integer> finalScores = idScoresMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .limit(3).collect(Collectors.toMap(Map.Entry::getKey,
                       Map.Entry::getValue,
                       (x,y)-> {throw new AssertionError();},
                       LinkedHashMap::new));
        return "";
    }

    public void park(int id) {
        if(!this.cars.containsKey(id) || this.cars.get(id).getIsRacing() ){
            return;
        }
        Car car = this.cars.get(id);
        garage.park(id,car);
    }

    public void unpark(int id) {
        if (!this.garage.getParkedCars().containsKey(id)){
             return;
        }
        Car car = this.garage.getParkedCars().get(id);
        car.park(false);
        this.garage.getParkedCars().remove(car);
    }

    public void tune(int tuneIndex, String addOn) {
        for (Car car : garage.getParkedCars().values()) {

            car.setHP(car.getHorsepower()+ tuneIndex);
            car.setSusp(car.getSuspension() + tuneIndex / 2);

            if (car.getClass().getName().equals("PerformanceCar")){
                 PerformanceCar pc =  (PerformanceCar) car;
                 pc.addAddOns(Arrays.asList(addOn.split(" ")));
            }else {
                  ShowCar sc = (ShowCar)car;
                  sc.addStars(tuneIndex);
            }
        }
    }


}
