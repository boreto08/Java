
public class Person extends Citizen {

    private Integer age;
    private String id;


    public Person(String name,Integer age,String id,String birthday) {
        super(name,birthday);
        this.setAge(age);
        this.setId(id);
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private void setId(String id) {
        this.id = id;
    }
}
