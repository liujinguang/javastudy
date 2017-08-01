package tij4.generics;

import java.util.ArrayList;
import java.util.Collection;

import tij4.generics.coffee.Coffee;
import tij4.generics.coffee.CoffeeGenerator;
import tij4.net.mindview.util.Generator;

public class Generators {
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
		for (int i=0; i<n; i++) {
			coll.add(gen.next());
		}
		
		return coll;
	}
	
	public static void main(String[] args) {
		Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
		for (Coffee c: coffees) {
			System.out.println(c);
		}
		
		Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
		for (int i:fnumbers){
			System.out.print(i + " ");
		}
	}
}
