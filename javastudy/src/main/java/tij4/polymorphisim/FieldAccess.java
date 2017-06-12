package polymorphisim;

//direct field access is determined at compile time

class Super {
	public int getField() {
		return field;
	}

	public int field = 0;
}

class Sub extends Super {
	public int getSuperField() {
		return super.field;
	}

	public int getField() {
		return field;
	}

	public int field = 1;
}

public class FieldAccess {
	public static void main(String[] args) {
		Super sup = new Sub(); // upcast
		System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());

		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField()
				+ ", sub.getSuperField() = " + sub.getSuperField());
	}
}
