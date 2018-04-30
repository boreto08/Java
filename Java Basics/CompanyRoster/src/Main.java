import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(scan.readLine());

        HashMap<String,Double> departmantMoneyMap = new HashMap<>();
        HashMap<String, TreeSet<Employee>> departEmployeeMap = new HashMap<>();

        for (int i = 0; i < lines; i++) {
            String[] tokens = scan.readLine().split(" ");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            String email = "";
            int age = 0;

            if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
            } else if (tokens.length == 5) {
                try {
                    age = Integer.parseInt(tokens[4]);
                } catch (Exception e) {
                    email = tokens[4];
                }
            }
            Employee employee;
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (email.equals("") && tokens.length == 5) {
                employee = new Employee(name, salary, position, department, age);
            } else if (tokens.length == 5 && !email.equals("")) {
                employee = new Employee(name, salary, position, department, email);
            } else {
                employee = new Employee(name, salary, position, department, email, age);
            }
            


            if (!departEmployeeMap.containsKey(department)) {
                TreeSet<Employee> list = new TreeSet<>();
                departEmployeeMap.put(department, list);
                departEmployeeMap.get(department).add(employee);

                departmantMoneyMap.put(department,salary);
            }else {
                departEmployeeMap.get(department).add(employee);

                double totalValue = departmantMoneyMap.get(department) + salary;
                departmantMoneyMap.put(department,totalValue);
            }
        }

        Map.Entry<String, TreeSet<Employee>> best =
                departEmployeeMap.entrySet().stream().sorted((e1, e2) ->
                Double.compare(departmantMoneyMap.get(e2.getKey()), departmantMoneyMap.get(e1.getKey())))
                .findFirst().get();
        System.out.printf("Highest Average Salary: %s\n",best.getKey());
        for (Employee employee : best.getValue()) {
            System.out.println(employee);
        }

    }

}

class Employee implements Comparable<Employee>{
//    Define a class Employee that holds the following
//    information: -------name, salary, position, department, email and age.----------
//    The name, salary, position and department are mandatory while the rest are optional.

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name, double salary, String position, String department) {
        this.setName(name);
        this.setSalary(salary);
        this.setPosition(position);
        this.setDepartment(department);
    }

    public Employee(String name, double salary, String position,
                    String department, String email, int age) {
        this(name, salary, position, department);
        this.setEmail(email);
        this.setAge(age);
    }

    public Employee(String name, double salary, String position,
                    String department, String email) {
        this(name, salary, position, department);
        this.setEmail(email);
    }

    public Employee(String name, double salary, String position,
                    String department, int age) {
        this(name, salary, position, department);
        this.setAge(age);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return  String.format("%s %.2f %s %d",this.getName(),
                this.getSalary(),this.getEmail(),this.getAge());
    }

    @Override
    public int compareTo(Employee employee1) {
       return  Double.compare(employee1.getSalary(),this.getSalary());
    }
}
