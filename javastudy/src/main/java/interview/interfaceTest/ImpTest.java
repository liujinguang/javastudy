package interview.interfaceTest;

interface A {
	int add(final A a);
}

public class ImpTest implements A {

	public int add(A a) {   ///返回值不是 long 类型
		return this.hashCode() + a.hashCode();
	}

}
