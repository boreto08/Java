public class BankAccount {
    private final static double DEFAULT_INTREST = 0.02;

    private  static  double intrestRate = DEFAULT_INTREST;
    private  static  int bankAccountCount;

    private  int id ;
    private  double balance;

    public BankAccount(){
        this.id = ++bankAccountCount;
    }

    public int getId(){
        return this.id;
    }
    public  static  void setIntrestRate(double intrest){
        intrestRate = intrest;
    }

    public void deposit(double money){
        this.balance +=money;
    }

    public double getIntrestRate(int years){
        return this.balance * years * intrestRate;
    }

    @Override
    public  String toString(){
        return  "ID" + this.id;
    }
}
