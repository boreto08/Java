import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Person> namePersonMap = new TreeMap<>();
        
        int lines = Integer.parseInt(scan.readLine());

        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.readLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (!namePersonMap.containsKey(name)){
                Person person = new Person();
                person.setName(name);
                person.setAge(age);
                namePersonMap.put(name,person);
            }else {
               namePersonMap.get(name).setName(name);
               namePersonMap.get(name).setAge(age);
            }
        }

        namePersonMap.entrySet().stream()
                .filter(p -> p.getValue().getAge() > 30)
                .forEach(x -> {
                    String name = x.getValue().getName();
                    int age = x.getValue().getAge();
                    System.out.printf("%s - %d\n",name,age);
                });

    }

}

class Person {

    private String name;
    private Integer age;

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }
}
