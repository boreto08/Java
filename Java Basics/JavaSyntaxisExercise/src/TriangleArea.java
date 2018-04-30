import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int area = 0;
        boolean exists =  checkIfTriangleExists(x1,y1,x2,y2,x3,y3);
        if (exists == false){
            System.out.println(0);
        }else {
            area = ((x1-x3)*(y2-y1)-(x1-x2)*(y3-y1))/ 2;

            System.out.println( Math.abs(area));
        }

    }

    private static boolean checkIfTriangleExists(int x1, int y1, int x2, int y2, int x3, int y3) {
        boolean exists = true;
        if ((y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2)) {
            exists = false ;
        }
        return exists;

    }

}
