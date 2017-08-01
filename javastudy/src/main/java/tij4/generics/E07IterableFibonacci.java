package tij4.generics;

import java.util.Iterator;


public class E07IterableFibonacci implements Iterable<Integer> {
	Fibonacci fib = new Fibonacci();
	private int n;
	
	public E07IterableFibonacci(int count) {
		n = count;
	}
	
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			public boolean hasNext() {
				return n > 0;
			}

			public Integer next() {
				n--;
				
				return fib.next();
			}
		};
	}
	
	public static void main(String[] args) {
		for (int i: new E07IterableFibonacci(18)) {
			System.out.print(i + " ");
		}
	}
}
