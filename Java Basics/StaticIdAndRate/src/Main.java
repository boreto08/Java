import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
//        •	Create
//        •	Deposit {Id} {Amount}
//        •	SetInterest {Interest}
//        •	GetInterest {ID} {Years}
//        •	End


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (true) {
            String input = br.readLine();
            if (input.equals("End")) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    executeCreate(accounts);
                    break;
                case "Deposit":
                    executeDeposit(tokens, accounts);
                    break;
                case "SetInterest":
                    executeSetIntrest(tokens);
                    break;
                case "GetInterest":
                    executeGetInterest(tokens,accounts);
                    break;
            }
        }
    }

    private static void executeGetInterest(String[] tokens, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(tokens[1]);
        int years = Integer.parseInt(tokens[2]);

        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        }else{
            System.out.println(accounts.get(id).getIntrestRate(years));
        }
    }

    private static void executeSetIntrest(String[] tokens) {
        double intrest = Double.parseDouble(tokens[1]);
        BankAccount.setIntrestRate(intrest);
    }

    private static void executeCreate(HashMap<Integer, BankAccount> accounts) {
        BankAccount acc = new BankAccount();
        accounts.putIfAbsent(acc.getId(), acc);
        System.out.printf("Account %s created\n", acc);
    }

    private static void executeDeposit(String[] tokens, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(tokens[1]);
        double money = Double.parseDouble(tokens[2]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            accounts.get(id).deposit(money);
            try{
                int wholeNum = (int)money;
                System.out.printf("Deposited %d to %s\n",wholeNum,accounts.get(id).toString());
            }catch (Exception e ){
                System.out.printf("Deposited %.2f to %s\n",money,accounts.get(id).toString());
            }
        }
    }

}
