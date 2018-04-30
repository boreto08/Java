package NeedForSpeed.models.Races;

import NeedForSpeed.models.Cars.Car;

import java.util.LinkedHashMap;

/**
 * Created by boreto on 3/12/2017.
 */
public class DragRace extends Race {

    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    public DragRace(int length, String route, int prizePool,LinkedHashMap<Integer,Car> participants) {
        super(length, route, prizePool, participants);
    }
}
