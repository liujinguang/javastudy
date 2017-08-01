package tij4.generics;

import tij4.net.mindview.util.BasicGenerator;
import tij4.net.mindview.util.Generator;

public class BasicGeneratorDemo {
	public static void main(String[] args) {
//		Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
		Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
		
		for (int i = 0; i<5;i++) {
			System.out.println(gen.next());
		}
	}
}
