import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable,Browseable {



    public Smartphone(){

    }


    @Override
    public String call(String number) {
        Pattern pattern = Pattern.compile("^([0-9]+)$");
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            return String.format("Calling... %s", number);
        }else{
            return "Invalid number!";
        }
    }

    @Override
    public String browse(String url) {
        Pattern pattern = Pattern.compile("^([^0-9]+)$");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()){
            return String.format("Browsing: %s!",url);
        }else {
            return "Invalid URL!";
        }
    }

    @Override
    public String toString(){
        return "";
    }



}
