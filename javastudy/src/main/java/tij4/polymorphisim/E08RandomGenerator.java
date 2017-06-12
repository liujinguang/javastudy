package polymorphisim;

import java.util.Random;

import polymorphisim.shape.*;

/*
 * 
The .class syntax in the array definition produces references to Class objects
for each type of instrument. Class.newInstance( ) creates an object of the
class it is called for, but it can throw exceptions. Here, we create and throw a
RuntimeException for this programming error, so your code doesn't have to
catch such exceptions. You can embed the cause of an error inside a thrown
exception to pass detailed information about the condition to a client
programmer. (We cover exceptions in detail in the chapter Error Handling with
Exceptions.) The benefit of this design is that you can add a new type to the
system by only adding it to the Class array; the rest of the code takes care of
itself.
*/
public class E08RandomGenerator {
	public Shape next() {
		try {
			int idx = Math.abs(gen.nextInt(shapes.length));
			return (Shape) shapes[idx].newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Cannot create", e);
		}
	}

	private Random gen = new Random();
	private Class<?> shapes[] = { Circle.class, Square.class, Triangle.class };

	public static void main(String[] args) {
		E08RandomGenerator generator = new E08RandomGenerator();
		for (int i = 0; i < 20; i++) {
			Shape s = generator.next();
			s.draw();
		}
	}
}
