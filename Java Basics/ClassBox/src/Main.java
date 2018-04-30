import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        Class boxClass = Box.class;
        Field[] fields = boxClass.getDeclaredFields();
        System.out.println(Arrays.asList(fields)
                .stream()
                .filter(f -> Modifier.isPrivate(f.getModifiers())).count());


        double length = Double.parseDouble(scan.readLine());
        double width = Double.parseDouble(scan.readLine());
        double height = Double.parseDouble(scan.readLine());
        Box box = new Box(length,width,height);
        System.out.printf("Surface Area - %.2f\n",box.calcSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f\n",box.calcLateralArea());
        System.out.printf("Volume - %.2f",box.calcVolume());



    }


}
