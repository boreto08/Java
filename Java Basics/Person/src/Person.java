
public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age){
        this.setName(name);
        this.setAge(age);
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if (name.length() < 3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }else{
            this.name = name;
        }
    }

    protected int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        if (age < 1){
           throw new IllegalArgumentException("Age must be positive!");
        }else{
            this.age = age;
        }
    }

    public String toString(){
        final  StringBuilder result = new StringBuilder();
        result.append(String.format("Name: %s, Age: %d",this.getName(),this.getAge()));
        return result.toString();
    }
}
