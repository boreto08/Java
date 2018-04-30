import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\boreto\\Desktop\\input.txt";
        String pathOut = "C:\\Users\\boreto\\Desktop\\out.txt";

        try(InputStream in = new FileInputStream(path);
            OutputStream out = new FileOutputStream(pathOut)){

            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++)
                        out.write(digits.charAt(i));
                }
            }
    }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
