import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        double quntity = Double.parseDouble(console.nextLine());
        double pricePerKg = 1.20;
        BigDecimal marka = new BigDecimal("4210500000000");
        BigDecimal priceInLeva = new BigDecimal(pricePerKg * quntity);

        BigDecimal totalPrice = priceInLeva.multiply(marka);

        System.out.printf("%.2f marks",totalPrice);




    }
}
