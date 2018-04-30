
public class Box {
    private double width;
    private double height;
    private double lenght;

    public  Box(double lenght, double width, double height){
        this.setLenght(lenght);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    private void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double calcSurfaceArea(){
        return (2 * this.lenght * this.width) + (2 * this.lenght * this.height) + (2 * this.width * this.height);
    }

    public double calcVolume(){
        return this.height * this.width * this.lenght;
    }

    public double calcLateralArea(){
        return  (2 * this.lenght * this.height) + (2 * this.width * this.height);
    }
}
