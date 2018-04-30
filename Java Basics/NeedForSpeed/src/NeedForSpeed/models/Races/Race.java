package NeedForSpeed.models.Races;


import NeedForSpeed.models.Cars.Car;

import java.util.LinkedHashMap;

public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private LinkedHashMap<Integer,Car> participants;


    protected Race(int length, String route, int prizePool) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new LinkedHashMap<>();
    }

    protected Race(int length, String route, int prizePool,LinkedHashMap<Integer,Car> participants){
        this(length, route, prizePool);
        this.participants = participants;
    }

    public int countParticipants(){
        return participants.size();
    }

    public LinkedHashMap<Integer,Car> getParticipants(){
        return this.participants;
    }

    public void addParticipant(int id,Car car){
        this.participants.put(id,car);
    }
}
