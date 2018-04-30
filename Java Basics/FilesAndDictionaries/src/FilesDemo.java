import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FilesDemo {

    public static void main(String[] args)  {

        String path = "C:\\Users\\boreto\\Desktop\\input.txt";

        try(InputStream in = new FileInputStream(path)){
            int oneByte  = in.read();
            while (oneByte >= 0){
                System.out.printf("%s ",Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
