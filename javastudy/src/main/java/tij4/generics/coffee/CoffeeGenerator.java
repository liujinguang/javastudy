package tij4.generics.coffee;

import java.util.Iterator;
import java.util.Random;

import tij4.net.mindview.util.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	public CoffeeGenerator() {
	}

	public CoffeeGenerator(int sz) {
		size = sz;
	}

	// public boolean hasNext() {
	// return false;
	// }

	public Coffee next() {
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class CoffeeIterator implements Iterator<Coffee> {
		private int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public Coffee next() {
			count--;

			return CoffeeGenerator.this.next();
		}

		public void remove() {
			throw new UnsupportedOperationException("Not implemented");
		}

	}

	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}
	
	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		System.out.println("==========================");
		
		for (Coffee c: new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	}

	private Class[] types = { Latte.class, Mocha.class, Cappuccinfo.class, Americano.class, Breve.class };
	private static Random rand = new Random(47);
	private int size = 0;

}
