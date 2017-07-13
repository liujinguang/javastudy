package tij4.generics;

interface Selector<T> {
	boolean end();

	T current();

	void next();
}

class Sequence<T> {
	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(T x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}

	private class SequenceSelector<T> implements Selector<T> {

		public boolean end() {
			return i == items.length;
		}

		@SuppressWarnings("unchecked")
		public T current() {
			return (T) items[i];
		}

		public void next() {
			if (i < items.length) {
				i++;
			}
		}

		private int i = 0;
	}

	public Selector<T> selector() {
		return new SequenceSelector<T>();
	}

	private int next;
	private Object[] items;
}

public class E04GenericSequence {
	public static void main(String[] args) {
		Sequence<String> sequence = new Sequence<String>(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(Integer.toString(i));
		}
		
		Selector<String> selector = sequence.selector();
		while (!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
