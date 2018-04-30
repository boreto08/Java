
public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private double getWeekSalary() {
        return this.weekSalary;
    }

    private double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }


    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    protected void setSecName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.secName = lastName;
    }


    private double calcMoneyPerHour() {
        return weekSalary / (workHoursPerDay * 7);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

               sb.append(String.format("Week Salary: %.2f", this.getWeekSalary()))
                .append(System.lineSeparator())
                .append(String.format("Hours per day: %.2f", this.getWorkHoursPerDay()))
                .append(System.lineSeparator())
                .append(String.format("Salary per hour: %.2f", this.calcMoneyPerHour()));
        return super.toString() + sb.toString();

    }
}
