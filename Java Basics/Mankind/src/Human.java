
public class Human {
    private String firstName;
    protected String secName;

    protected Human(String firstName, String secName){
        this.setFirstName(firstName);
        this.setSecName(secName);
    }

    protected String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        Character firstCh = firstName.charAt(0);
        if (!Character.isUpperCase(firstCh)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }else if(firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected String getSecName() {
        return this.secName;
    }

    protected void setSecName(String secName) {
        Character firstCh = secName.charAt(0);
        if (!Character.isUpperCase(firstCh)){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }else if(firstName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.secName = secName;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: " + this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: " + this.getSecName())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
