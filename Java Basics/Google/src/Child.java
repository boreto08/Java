
public class Child {

    private String name;
    private String birthday;

    public  Child(String name, String birthday){
            this.setName(name);
            this.setBirthday(birthday);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getBirthday();
    }
}
