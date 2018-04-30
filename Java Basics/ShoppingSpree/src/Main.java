import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String,Person> mapPerson = new LinkedHashMap<>();
        LinkedHashMap<String,Product> mapProduct = new LinkedHashMap<>();

        String[] persons = scan.readLine().split(";");
        for (String person : persons) {
            String[] tokens = person.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);
            Person currPerson = new Person(name,money);
            if (currPerson.getIlegal()){
                return;
            }

            mapPerson.putIfAbsent(name,currPerson);
        }

        String[] products = scan.readLine().split(";");
        for (String product : products) {
            String[] tokens = product.split("=");
            String productName = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            Product currProduct = new Product(productName,price);

            mapProduct.putIfAbsent(productName,currProduct);
        }

        while(true){
            String input = scan.readLine();
            if (input.equals("END")){
                break;
            }
            String[] tokens = input.split(" ");
            String namePerson = tokens[0];
            String nameProduct = tokens[1];

            if (!mapPerson.containsKey(namePerson) || !mapProduct.containsKey(nameProduct)){
                  continue;
            }

            if (mapPerson.get(namePerson).isAffordable(mapProduct.get(nameProduct))){
                mapPerson.get(namePerson).getProducts().add(mapProduct.get(nameProduct));
                System.out.printf("%s bought %s\n",namePerson,nameProduct);
            }else {
                System.out.printf("%s can't afford %s\n",namePerson,nameProduct);
            }
        }

        mapPerson.values().stream().forEach(p -> {
            System.out.print(p.getName() + " - ");
            if (p.getProducts().size() == 0){
                System.out.println("Nothing bought");
            }else {
               List<String> productsNames =
                       p.getProducts().stream().map(x -> x.getName()).collect(Collectors.toList());
                String joined = String.join(", ",productsNames);
                System.out.println(joined);
            }
        });


    }

}
