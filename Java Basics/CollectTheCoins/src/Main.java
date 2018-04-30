import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int FIELD_ROWS = 4;
    static final char COIN = '$';

    static char[][] field;
    static int startRow = 0;
    static int startCol = 0;
    static int walls = 0;
    static int coins = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        field = new char[FIELD_ROWS][];
        fillFiled(field,reader);

        char[] moves = reader.readLine().toCharArray();
        doMoves(moves);

        System.out.printf("Coins = %d\n",coins);
        System.out.printf("Walls = %d",walls);
    }

    private static void doMoves(char[] moves) {

        for (char move : moves) {
            switch (move){
                case '>':
                    moveRight();
                    break;
                case '<':
                    moveLeft();
                    break;
                case '^':
                    moveUp();
                    break;
                case 'V':
                    moveDown();
                    break;
            }
        }
    }

    private static void moveDown() {
        try{
            int currentRow = startRow + 1;//Move up
            int currentCol = startCol;

            if(field[currentRow][currentCol] == COIN ){
                coins++;
            }
            startRow = currentRow;
            startCol = currentCol;

        }catch(IndexOutOfBoundsException e){
            walls++;
        }
    }

    private static void moveUp() {
        try{
            int currentRow = startRow - 1;//Move up
            int currentCol = startCol;

            if(field[currentRow][currentCol] == COIN ){
                coins++;
            }
            startRow = currentRow;
            startCol = currentCol;

        }catch(IndexOutOfBoundsException e){
            walls++;
        }
    }

    private static void moveLeft() {
        try{
            int currentRow = startRow;
            int currentCol = startCol - 1;//Move left

            if(field[currentRow][currentCol] == COIN ){
                coins++;
            }
            startRow = currentRow;
            startCol = currentCol;

        }catch(IndexOutOfBoundsException e){
            walls++;
        }
    }

    private static void moveRight() {
        try{
            int currentRow = startRow;
            int currentCol = startCol + 1;//Move right

          if(field[currentRow][currentCol] == COIN ){
              coins++;
          }
          startRow = currentRow;
          startCol = currentCol;

        }catch(IndexOutOfBoundsException e){
            walls++;
        }
    }

    public static void fillFiled(char[][] field , BufferedReader reader) throws IOException {

        for (int row = 0; row < FIELD_ROWS ; row++) {
            char[] chArray = reader.readLine().toCharArray();
            field[row] = new char[chArray.length];
            for (int col = 0; col < chArray.length; col++) {
                field[row][col] = chArray[col];
            }
        }

    }

}
