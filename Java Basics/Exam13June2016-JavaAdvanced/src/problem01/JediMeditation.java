package problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JediMeditation {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(br.readLine());

        List<String> masters = new ArrayList<>();
        List<String> knights = new ArrayList<>();
        List<String> padawans = new ArrayList<>();
        List<String> tAndSList = new ArrayList<>();

        int  countYodas = 0;

        for (int i = 0; i < lines ; i++) {

            String input = br.readLine();

            if(input.contains("y")){
                countYodas++;
            }

            String[] inputArr = input.split(" ");

            for (String jedi : inputArr) {

                if (jedi.startsWith("m")){
                    masters.add(jedi);
                }
                else if(jedi.startsWith("k")){
                    knights.add(jedi);
                }
                else if(jedi.startsWith("p")){
                    padawans.add(jedi);
                }
                else if(jedi.startsWith("s") || jedi.startsWith("t")){
                    tAndSList.add(jedi);
                }
            }
        }

        if (countYodas > 0){

            printWithYoda(masters, knights, padawans, tAndSList);

        }
        else {

            printNoYoda(masters, knights, padawans, tAndSList);

        }
        

    }

    private static void printWithYoda(List<String> masters, List<String> knights, List<String> padawans, List<String> tAndSList) {
        for (String master : masters) {
            System.out.print(master + " ");
        }
        for (String knight : knights) {
            System.out.print(knight + " ");
        }
        for (String p : tAndSList) {
            System.out.print(p + " ");
        }

        for (int i = 0; i < padawans.size() ; i++) {
            if (i == padawans.size() - 1){
                System.out.print(padawans.get(i));
            }
            else {
                System.out.print(padawans.get(i) + " ");
            }
        }
    }

    private static void printNoYoda(List<String> masters, List<String> knights, List<String> padawans, List<String> tAndSList) {
        for (String p : tAndSList) {
            System.out.print(p + " ");
        }

        for (String master : masters) {
            System.out.print(master + " ");
        }
        for (String knight : knights) {
            System.out.print(knight + " ");
        }

        for (int i = 0; i < padawans.size() ; i++) {
            if (i == padawans.size() - 1){
                System.out.print(padawans.get(i));
            }
            else {
                System.out.print(padawans.get(i) + " ");
            }
        }
    }
}
