import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\boreto\\Desktop\\input.txt";
        String pathOut = "C:\\Users\\boreto\\Desktop\\out.txt";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols,'.', ',', '!', '?');

        try(InputStream in = new FileInputStream(path);
            OutputStream out = new FileOutputStream(pathOut)){
            int oneByte  = in.read();
            while (oneByte  >= 0){
                if (!symbols.contains((char)oneByte)){
                    out.write(oneByte);
                }
                oneByte = in.read();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
