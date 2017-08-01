package tij4.generics;

import static tij4.net.mindview.util.Tuple.*;
import tij4.net.mindview.util.TwoTuple;

public class TupleTest2 {
	static TwoTuple<String, Integer> f() {
		return tuple("hi", 48);
	}
	
	static TwoTuple f2() {
		return tuple("hi", 47);
	}
	
	public static void main(String[] args) {
		TwoTuple<String, Integer> ttsi = f();
		System.out.println(ttsi);
		
		System.out.println(f2());
	}
}
