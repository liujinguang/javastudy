package corejava.v2ch01.ObjectStreamTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class ObjectStreamTest {
	public static void main(String[] args) {
		Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
		carl.setSecretary(harry);
		Manager tony = new Manager("Tony Tester", 4000, 1990, 3, 15);
		tony.setSecretary(harry);

		Employee[] staff = new Employee[3];

		staff[0] = carl;
		staff[1] = harry;
		staff[2] = tony;

		try {
			// save all employee records to the file employee.dat
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"));
			out.writeObject(staff);
			out.close();

			// retrieve all records into a new array
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"));
			Employee[] newStaff = (Employee[]) in.readObject();
			in.close();

			// raise secretary's salary
			newStaff[1].raiseSalary(10);

			// print all newly read employee records
			for (Employee e : newStaff) {
				System.out.println(e);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Employee implements Serializable {
	public Employee() {
	}

	public Employee(String n, double s, int year, int month, int day) {
		name = n;
		salary = s;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hireDay = calendar.getTime();
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override
	public String toString() {
		return getClass().getName() + "[name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}

	private Date hireDay;
	private double salary;
	private String name;
}

class Manager extends Employee {
	public Manager(String n, double s, int year, int month, int day) {
		super(n, s, year, month, day);
		secretary = null;
	}

	public Employee getSecretary() {
		return secretary;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}

	@Override
	public String toString() {
		return super.toString() + "[secretary=" + secretary + "]";
	}

	private Employee secretary;
}
