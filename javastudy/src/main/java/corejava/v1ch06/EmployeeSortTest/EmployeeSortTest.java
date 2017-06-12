package v1ch06.EmployeeSortTest;

import java.util.Arrays;

public class EmployeeSortTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry Hacker", 35000, 0);
		staff[1] = new Employee("Carl Cracker", 75000, 0);
		staff[2] = new Employee("Tony Tester", 38000, 0);
		
		Arrays.sort(staff);
		for (Employee e:staff) {
			e.calculateBonus(0.042);
			System.out.println(e);
		}
	}
}

class Employee implements Comparable<Employee> {

	public Employee(String name, double salary, double bonus) {
		super();
		this.name = name;
		this.salary = salary;
		this.bonus = bonus;
	}

	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public void calculateBonus(double byPercent) {
		double bonus = salary * 12 * byPercent;
		this.bonus += bonus;
	}

	public int compareTo(Employee o) {
		if (salary < o.salary) {
			return -1;
		}
		if (salary > o.salary) {
			return 1;
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ",salary=" + salary + ",bonus=" + bonus;
	}

	private String name;
	private double salary;
	private double bonus;
}
