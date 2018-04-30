package NeedForSpeed.models.Races;

import NeedForSpeed.models.Cars.Car;

import java.util.LinkedHashMap;

public class CasualRace extends Race{


    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public CasualRace(int length, String route, int prizePool, LinkedHashMap<Integer,Car> participants) {
        super(length, route, prizePool, participants);
    }
}
