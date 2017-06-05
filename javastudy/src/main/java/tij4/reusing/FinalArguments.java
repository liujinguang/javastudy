package tij4.reusing;
//using "final" with method arguments

public class FinalArguments {
	void with(final Gizmo g) {
//		g = new Gizmo(); //illegal -- g is final
	}
	
	void without(Gizmo g) {
		g= new Gizmo();  //OK, g not final
		g.Spin();
	}
	
//	void f (final int i) {i++;}  // can't change
	
	//you can only read from a final primitive
	int g(final int i) {
		return i+1;
	}
	
	public static void main(String[] args) {
		FinalArguments bf = new FinalArguments();
		bf.without(null);
		bf.with(null);
	}
}

class Gizmo {
	public void Spin() {
	}
}
