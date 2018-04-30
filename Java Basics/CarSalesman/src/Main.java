import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String,Engine> mapModelEngine = new HashMap<>();
        
        int numOfEngines = Integer.parseInt(scan.readLine());
        for (int i = 0; i < numOfEngines; i++) {
            String[] tokens = scan.readLine().split("\\s+");
            
            String model = tokens[0];
            String power = tokens[1];
            int displacement = 0;
            String efficiency = "";
            
            Engine engine;
            if (tokens.length == 3){
                  try {
                    int num = Integer.parseInt(tokens[2]);
                    displacement = num;
                    engine = new Engine(model,power,displacement);
                  }catch (Exception e){
                      efficiency = tokens[2];
                      engine = new Engine(model,power,efficiency);
                  }
            }else if(tokens.length == 2) {
                 engine = new Engine(model,power);
            }else {
                displacement = Integer.parseInt(tokens[2]);
                efficiency = tokens[3];
                engine = new Engine(model,power,displacement,efficiency);
            }
            mapModelEngine.putIfAbsent(model,engine);
        }
        
        int numOfCars = Integer.parseInt(scan.readLine());
        for (int i = 0; i < numOfCars; i++) {
            String[] tokens = scan.readLine().split("\\s+");
            String carModel = tokens[0];
            Engine carEngine = mapModelEngine.get(tokens[1]);
            int weight = -1;
            String color;
            Car car;
            if (tokens.length == 2){
                  car = new Car(carModel,carEngine);
            }else if(tokens.length == 3){
                try {
                    weight = Integer.parseInt(tokens[2]);
                    car = new Car(carModel,carEngine,weight);
                }catch(Exception ex){
                    color = tokens[2];
                    car = new Car(carModel,carEngine,color);
                }
            }else {
                weight = Integer.parseInt(tokens[2]);
                color = tokens[3];
                car = new Car(carModel,carEngine,weight,color);
            }
            System.out.println(car.toString());
        }
    }
}

class Car {
//     A Car has a model, engine,
//    weight and color. An Engine has model, power,
//    displacement and efficiency. A Car’s weight and color and its
//    Engine’s displacements and efficiency are optional

    private String model;
    private Engine engine;
    private int weight = -1;
    private String color = "n/a";

    public Car(String model,Engine engine){
        this.setModel(model);
        this.setEngine(engine);
    }
    public Car(String model,Engine engine,int weight){
        this(model,engine);
         this.setWeight(weight);
    }
    public Car(String model,Engine engine,String color){
        this(model,engine);
        this.setColor(color);
    }
    public Car(String model,Engine engine,int weight,String color){
        this(model,engine,weight);
        this.setColor(color);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        String result;
        String model = this.getModel() + ":\n";
        String engine = this.getEngine().toString();
        String weight = String.format("  Weight: %s\n",this.getWeight() == -1? "n/a":String.valueOf(this.getWeight()));
        String color = String.format("  Color: %s",this.getColor());
        return  result = model + engine + weight + color;
    }
}

class Engine {

    private String model;
    private String power;
    private int displacement = -1;
    private String efficiency = "n/a";

    public Engine(String model,String power){
        this.setModel(model);
        this.setPower(power);
    }
    public Engine(String model,String power,int displacement){
        this(model,power);
        this.setDisplacement(displacement);
    }
    public Engine(String model,String power,String efficiency){
        this(model,power);
        this.setEfficiency(efficiency);
    }
    public Engine(String model,String power,int displacement,String efficiency){
        this(model,power);
        this.setDisplacement(displacement);
        this.setEfficiency(efficiency);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString(){
        String result;
        String model = String.format("  %s:\n",this.getModel());
        String power = String.format("    Power: %s\n",this.getPower());
        String displacement = String.format("    Displacement: %s\n",this.getDisplacement() == -1? "n/a" : this.getDisplacement());
        String efficincy = String.format("    Efficiency: %s\n",this.getEfficiency());
        return result = model + power + displacement + efficincy;
    }
}
