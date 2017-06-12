package v1ch05.ArrayList;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<Employee>();
        
        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));
        
        for (Employee e : staff) {
            e.raiseSalary(5);
            System.out.println(e);
        }
    }
}

class Employee {
    public Employee(String name, double salary, int year, int month, int day) {
        super();
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        this.hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name=" + getName() + ",salary=" + getSalary() + ",hireDay="
                + getHireDay();
    }

    private String name;
    private double salary;
    private Date hireDay;
}
