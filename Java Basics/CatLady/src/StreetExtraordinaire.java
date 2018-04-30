/**
 * Created by boreto on 2/27/2017.
 */
public class StreetExtraordinaire extends Cat {

    private double meowDecibels;

    public StreetExtraordinaire(String name,String breed, double meowDecibels){
        super(name,breed);
        this.setMeowDecibels(meowDecibels);
    }

    private double getMeowDecibels() {
        return this.meowDecibels;
    }

    private void setMeowDecibels(double meowDecibels) {
        this.meowDecibels = meowDecibels;
    }

    @Override
    public String toString(){
        return String.format("%s %s %d",this.getBreed(),this.getName(),(int)this.getMeowDecibels());
    }
}
