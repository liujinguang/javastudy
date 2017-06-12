package v1ch05.PersonTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class PersonTest {

    public static void main(String[] args) {
        Person[] people = new Person[2];
        
        // fill the people array with Student and Employee objects
        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        // print out names and descriptions of all Person objects
        for (Person p : people)
           System.out.println(p.getName() + ", " + p.getDescription());
    }
}

abstract class Person {
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();

    private String name;
}

class Employee extends Person {
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        this.hireDay = calendar.getTime();
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return String.format("an employee with salary of %.2f", salary);
    }
    
    public double getSalary()
    {
       return salary;
    }

    public Date getHireDay()
    {
       return hireDay;
    }
    
    public void raiseSalary(double byPercent)
    {
       double raise = salary * byPercent / 100;
       salary += raise;
    }

    private double salary;
    private Date hireDay;
}

class Student extends Person {

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
    
    private String major;
}
