import java.util.ArrayList;
import java.util.List;


public class Person {
    private String name;
    private  double money;
    private List<Product> products;
    private boolean isIlegal = false;



    public Person(String name, double money){
        this.setName(name);
        this.setMoney(money);
        products = new ArrayList<>();
    }

    public boolean getIlegal(){
        return  this.isIlegal;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        }else {
            System.out.println("Name cannot be empty");
            isIlegal = true;
        }
    }

    private void setMoney(double money) {
        if (money >= 0 ){
            this.money = money;
        }else {
            System.out.println("Money cannot be negative");
            isIlegal = true;
        }
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }

    public  List<Product> getProducts(){
        return  this.products;
    }

    public boolean isAffordable(Product product){
        double productPrice = product.getPrice();
        if (this.money >= productPrice){
            this.money -= productPrice;
            return  true;
        }
        return  false;
    }
}
