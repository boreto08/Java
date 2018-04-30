
public class Siamese extends Cat{

    private double earSize;

    public Siamese(String name,String breed,double earSize){
        super(name,breed);
        this.setEarSize(earSize);

    }

    private double getEarSize() {
        return this.earSize;
    }

    private void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    @Override
    public String toString(){
        return  String.format("%s %s %d",this.getBreed(),this.getName(),(int)this.getEarSize());
    }
}
