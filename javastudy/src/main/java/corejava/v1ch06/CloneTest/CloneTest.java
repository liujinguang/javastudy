package v1ch06.CloneTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class CloneTest {
	public static void main(String[] args) {
		try {
			Employee original = new Employee("John Q. Public", 50000);
			original.setHireDay(2000, 1, 1);

			Employee copied = original.clone();
			copied.raiseSalary(10);
			copied.setHireDay(2002, 12, 1);
			System.out.println("original=" + original);
			System.out.println("copied=" + copied);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

class Employee implements Cloneable {
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
		hireDay = new Date();
	}

	@Override
	public Employee clone() throws CloneNotSupportedException {
		Employee cloned = (Employee) super.clone();

		cloned.hireDay = (Date) hireDay.clone();
		return cloned;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public void setHireDay(int year, int month, int day) {
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

		hireDay.setTime(newHireDay.getTime());
	}

	@Override
	public String toString() {
		return "Employee[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
	}

	private String name;
	private double salary;
	private Date hireDay;
}
