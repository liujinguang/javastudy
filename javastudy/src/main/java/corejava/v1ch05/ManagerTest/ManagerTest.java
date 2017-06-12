package v1ch05.ManagerTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        
        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
        
        for (Employee e: staff) {
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
        hireDay = calendar.getTime();
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
        return getClass().getName() + " name=" + getName() + ",salary=" + getSalary() + ",hireDay="
                + getHireDay();
    }

    private String name;
    private double salary;
    private Date hireDay;
}

class Manager extends Employee {

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);

        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();

        return baseSalary + bonus;
    }

    private double bonus;
}
