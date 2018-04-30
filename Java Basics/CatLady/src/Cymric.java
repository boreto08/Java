/**
 * Created by boreto on 2/27/2017.
 */
public class Cymric extends Cat{

    private  double furLenght;

    public Cymric(String name,String breed, double furLenght){
        super(name,breed);
        this.setFurLenght(furLenght);
    }

    public double getFurLenght() {
        return this.furLenght;
    }

    public void setFurLenght(double furLenght) {
        this.furLenght = furLenght;
    }

    @Override
    public String toString(){
        return  String.format("%s %s %.2f",this.getBreed(),this.getName(),this.getFurLenght());
    }
}
