import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Citizen {

    private String name;
    private String birthday;



    public Citizen(String name,String birthday) {
        this.setName(name);
        this.setBirthday(birthday);
    }

    public String getBirthday() {
        return this.birthday;
    }

    private void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private void setName(String name) {
        this.name = name;
    }


    public boolean isMatched(String year){
        Pattern pattern = Pattern.compile(String.format("\\/%s$",year));
        Matcher matcher = pattern.matcher(birthday);
        return matcher.find();
    }

}
