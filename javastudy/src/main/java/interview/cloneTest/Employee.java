package interview.cloneTest;

/*
 * A class implements the Cloneable interface to indicate to the Object.clone() method that it is legal for that method to 
 * make a field-for-field copy of instances of that class. 
 * Invoking Object's clone method on an instance that does not implement the Cloneable interface results in the
 * exception CloneNotSupportedException being thrown. 
 * By convention, classes that implement this interface should override Object.clone (which is protected) 
 * with a public method. See Object.clone() for details on overriding this method. 
 * */


public class Employee implements Cloneable {
	public Employee(String name, int age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException {
		Employee employee = null;
		
		try {
			employee = (Employee) super.clone();
			employee.address = address.clone();  //对引用类型进行克隆
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return employee;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("姓名:" + name + ", ");
		sb.append("年龄: " +age + ", ");
		sb.append("地址: " + address);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Address address = new Address("China", "Jilin", "Changchun");
		Employee employee1 = new Employee("Zhaosi", 20, address);
		System.out.println("Before clone:");
		System.out.println(employee1);
		
		Employee employee2;
		try {
			employee2 = employee1.clone();
			employee2.getAddress().setCity("Nanjing");
			employee2.getAddress().setProvince("Jinagsu");
			employee2.setName("Zhangsan");
			
			System.out.println("After clone:");
			System.out.println(employee1);
			System.out.println(employee2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String name;
	private int age;
	private Address address;

}
