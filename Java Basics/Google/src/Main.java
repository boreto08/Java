import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Person> mapNamePerson = new HashMap<>();

        while (true) {
            String input = scan.readLine();
            if (input.equals("End")) {
                break;
            }

            String[] tokens = input.split(" ");
            String name = tokens[0];
            String typeClass = tokens[1];

            Person person;
            switch (typeClass) {

                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    if (!mapNamePerson.containsKey(name)) {
                        mapNamePerson.put(name, new Person());
                        mapNamePerson.get(name).setName(name);
                        mapNamePerson.get(name).setCompany(company);
                    } else {
                        mapNamePerson.get(name).setCompany(company);
                    }
                    break;
                case "pokemon":
                    String pokemonName = tokens[2].trim();
                    String pokemonType = tokens[3].trim();
                    Pokemon pokemon = new Pokemon(pokemonName + " " + pokemonType);
                    if (!mapNamePerson.containsKey(name)) {
                        mapNamePerson.put(name, new Person());
                        mapNamePerson.get(name).setName(name);
                        mapNamePerson.get(name).getPokemons().add(pokemon);
                    } else {
                        mapNamePerson.get(name).getPokemons().add(pokemon);
                    }
                    break;
                case "car":
                    String carName = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(carName,speed);
                    if (!mapNamePerson.containsKey(name)) {
                        mapNamePerson.put(name, new Person());
                        mapNamePerson.get(name).setName(name);
                        mapNamePerson.get(name).setCar(car);
                    } else {
                        mapNamePerson.get(name).setCar(car);
                    }
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName,parentBirthday);
                    if (!mapNamePerson.containsKey(name)) {
                        mapNamePerson.put(name, new Person());
                        mapNamePerson.get(name).setName(name);
                        mapNamePerson.get(name).getParents().add(parent);
                    } else {
                        mapNamePerson.get(name).getParents().add(parent);
                    }
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName,childBirthday);
                    if (!mapNamePerson.containsKey(name)) {
                        mapNamePerson.put(name, new Person());
                        mapNamePerson.get(name).setName(name);
                        mapNamePerson.get(name).getChildren().add(child);
                    } else {
                        mapNamePerson.get(name).getChildren().add(child);
                    }
                    break;
            }
        }
        String neededName = scan.readLine();

        if (mapNamePerson.containsKey(neededName)){
            mapNamePerson.get(neededName).print();
        }


    }

}
