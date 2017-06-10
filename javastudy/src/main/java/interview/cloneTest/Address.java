package interview.cloneTest;

public class Address implements Cloneable {
	private String state;
	private String province;
	private String city;

	public Address(String state, String province, String city) {
		super();
		this.state = state;
		this.province = province;
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("国家: " + state + ", ");
		sb.append("省：" + province + ", ");
		sb.append("市" + city);
		
		return sb.toString();
	}
	
	/*
	 * 所谓浅克隆就是说被克隆的对象各个域都是基本类型，而不存在引用类型。如有存在引用类型的域，则需要进行深克隆。深克隆就是在重载clone（）方法中，
	 * 要对其引用类型的域也进行克隆。
	 * */
	
	@Override
	public Address clone() throws CloneNotSupportedException {
		Address address = null;
		
		try {
			address = (Address) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return address;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
