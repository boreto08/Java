
public class Person extends Citizen {

    private Integer age;

    public Person(String name, String id,Integer age) {
        super(name, id);
        this.setAge(age);
    }

    private void setAge(Integer age) {
        this.age = age;
    }
}
