public class Ferrari implements Driveable,Breakable,Gasable {
    private String name = "488-Spider";
    private String driverName;

    public Ferrari(String driverName){
        this.driverName = driverName;
    }


    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getDriver() {
        return this.driverName;
    }

    @Override
    public String pushBreaks() {
        return "Brakes!";
    }

    @Override
    public String toString(){
        return String.format("488-Spider/%s/%s/%s",this.pushBreaks(),this.gas(),this.getDriver());
    }
}
