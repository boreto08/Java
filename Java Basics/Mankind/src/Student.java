
public class Student extends Human {

    private String facultyNum;

    public Student(String firstName, String secName, String facultyNum) {
        super(firstName, secName);
        this.setFacultyNum(facultyNum);
    }

    private String getFacultyNum() {
        return this.facultyNum;
    }

    private void setFacultyNum(String facultyNum) {
        if (facultyNum.length() >= 5 && facultyNum.length() <= 10) {
            this.facultyNum = facultyNum;
            return;
        }
        throw new IllegalArgumentException("Invalid faculty number!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Faculty number: " + this.getFacultyNum());

        return super.toString() + sb.toString();
    }
}
