package NeedForSpeed.models.Races;

import NeedForSpeed.models.Cars.Car;

import java.util.LinkedHashMap;

public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public DriftRace(int length, String route, int prizePool,LinkedHashMap<Integer,Car> participants) {
        super(length, route, prizePool, participants);
    }
}
