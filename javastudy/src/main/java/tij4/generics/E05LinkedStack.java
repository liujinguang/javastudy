package tij4.generics;

class LinkedStatck<T> {
	private static class Node<T> {
		T item;
		Node<T> next;
		
		public Node() {
			item = null;
			next = null;
		}
		
		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
		
		public boolean end() {
			return item == null && next == null;
		}
	}
	
	private Node<T> top = new Node();
	
	public void push(T item) {
		top = new Node<T>(item, top);
	}
	
	public T pop() {
		T result = top.item;
		if (!top.end()) {
			top = top.next;
		}
		
		return result;
	}
}

public class E05LinkedStack {

	public static void main(String[] args) {
		LinkedStack<String> lss = new LinkedStack<String>();
		for (String s: "Phasers or stun!".split(" ")) {
			lss.push(s);
		}
		
		String s;
		while ((s = lss.pop()) != null) {
			System.out.println(s);
		}

	}

}
