package NeedForSpeed.models;

import NeedForSpeed.models.Cars.Car;

import java.util.LinkedHashMap;

public class Garage {

    private LinkedHashMap<Integer,Car> parkedCars;

    public Garage(){
        parkedCars = new LinkedHashMap<Integer, Car>();
    }

    public Garage(LinkedHashMap<Integer, Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void park(int id, Car car){
        this.parkedCars.put(id,car);
    }

    public LinkedHashMap<Integer,Car> getParkedCars(){
        return this.parkedCars;
    }

    @Override
    public String toString(){
        StringBuilder sbParking = new StringBuilder();
        for (Car car : parkedCars.values()) {
            sbParking.append(car.toString());
        }

        return  sbParking.toString();
    }


}
