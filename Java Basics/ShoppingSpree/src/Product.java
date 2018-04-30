
public class Product {
    private String name;
    private double price;

    public  Product(String name, double price){
        this.setName(name);
        this.setPrice(price);
    }

    public  String getName(){
        return  this.name;
    }

    private void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        }else {
            System.out.println("Name cannot be empty");
            return;
        }

    }

    private void setPrice(double price) {
        boolean negativeMoney = false;
        if (price >= 0 ){
            this.price = price;
        }else {
            System.out.println("Money cannot be negative");
              return;
        }

    }

    public double getPrice(){
        return this.price;
    }

}
