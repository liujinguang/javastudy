package interview.linkedList;

/**
 * Java program to find middle element of linked list in one pass. In order to
 * find middle element of linked list we need to find length first but since we
 * can only traverse linked list one time, we will use two pointers one which we
 * will increment on each iteration while other which will be incremented every
 * second iteration. so when first pointer will point to the end of linked list,
 * second will be pointing to the middle element of linked list
 * 
 * @author
 */

public class LinkedListTest {
	public static void main(String[] args) {
		// creating LinkedList with 5 elements including head
		// LinkedList linkedList = new LinkedList();
		// linkedList.add(new LinkedList.Node("101"));
		// linkedList.add(new LinkedList.Node("201"));
		// linkedList.add(new LinkedList.Node("301"));
		// linkedList.add(new LinkedList.Node("401"));
		//// System.out.println("Linked List : " + linkedList);
		// if (linkedList.isCyclic()) {
		// System.out.println("Linked List is cyclic as it contains cycles or
		// loop");
		// } else {
		// System.out.println("LinkedList is not cyclic, no loop or cycle
		// found");
		// }

		// creating LinkedList with 5 elements including head
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("101"));
		LinkedList.Node cycle = new LinkedList.Node("201");
		linkedList.add(cycle);
		linkedList.add(new LinkedList.Node("301"));
		linkedList.add(new LinkedList.Node("401"));
		linkedList.add(cycle);

		// d in case
		// of cyclic linked list, it will
		// throw OutOfMemoryError
		// //System.out.println("Linked List
		// : " + linkedList);
		if (linkedList.isCyclic()) {
			System.out.println("Linked List is cyclic as it contains cycles or loop");
		} else {
			System.out.println("LinkedList is not cyclic, no loop or cycle found");
		}

	}

	public void findMiddleElement() {
		// creating LinkedList with 5 elements including head
		LinkedList list = new LinkedList();

		list.add(new LinkedList.Node("1"));
		list.add(new LinkedList.Node("2"));
		list.add(new LinkedList.Node("3"));
		list.add(new LinkedList.Node("4"));
		list.add(new LinkedList.Node("5"));

		LinkedList.Node head = list.head();

		// finding middle element of LinkedList in a single pass
		LinkedList.Node current = head;
		LinkedList.Node middle = head;
		int length = 0;

		while (current.next() != null) {
			length++;

			if (length % 2 == 0) {
				middle = middle.next();
			}

			current = current.next();
		}
		length++;

		System.out.println("length of LinkedList: " + length);
		System.out.println("length of LinkedList: " + list.length());
		System.out.println("length of LinkedList: " + list.length(list.head()));
		System.out.println("middle element of LinkedList : " + middle);
	}
}

class LinkedList {
	private Node head;
	private Node tail;

	/**
	 * Constructs an empty list
	 */
	public LinkedList() {
		head = null;
		tail = null;
	}

	public Node head() {
		return head;
	}

	public void add(Node node) {
		if (head == null) {
			head = node;
			tail = node;

			return;
		}

		tail.next = node;
		tail = node;
	}

	public int length() {
		int count = 0;
		Node current = head;

		while (current != null) {
			count++;
			current = current.next();
		}

		return count;
	}

	public int length(Node current) {
		if (current == null) {
			return 0;
		}

		return 1 + length(current.next());
	}

	/*
	 * If singly LinkedList contains Cycle then following would be true slow and
	 * fast will point to same node i.e. they meet. On the other hand if fast
	 * will point to null or next node of fast will point to null then
	 * LinkedList does not contains cycle.
	 */
	public boolean isCyclic() {
		Node fast = head;
		Node slow = head;

		while (fast != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;

			// if fast and slow are meeting then LinkList is cyclic
			if (fast == slow) {
				return true;
			}
		}

		return false;
	}

	public static class Node {
		private Node next;
		private String data;

		public Node(String data) {
			this.data = data;
		}

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public String toString() {
			return this.data;
		}
	}
}