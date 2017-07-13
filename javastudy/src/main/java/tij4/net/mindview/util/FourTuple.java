package tij4.net.mindview.util;

public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
	public FourTuple(A a, B b, C c, D d) {
		super(a, b, c);
		fourth = d;
	}
	
	@Override
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
	}
	
	public final D fourth;
}
