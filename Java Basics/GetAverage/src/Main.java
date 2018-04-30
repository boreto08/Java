public class Main {

    public static void main(String[] args) {
        double a = 12;
        double b = 13;
        double c = 25;
        double result = GetAverege(a,b,c);
        System.out.printf("%.2f",result);
    }
    public  static  double GetAverege(double a , double b , double c){
        double average = 0.0;
        average = (a + b + c) / 3.0  ;
        return  average;
    }
}
