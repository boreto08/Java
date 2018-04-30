import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Citizen {

    private String name;
    private String id;

    public Citizen(String name, String id) {
        this.setName(name);
        this.setId(id);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public boolean isFake(String num){
        Pattern pattern = Pattern.compile(String.format("%s$",num));
        Matcher matcher = pattern.matcher(this.getId());
        if (matcher.find()){
            return true;
        }else{
            return false;
        }
    }
}
