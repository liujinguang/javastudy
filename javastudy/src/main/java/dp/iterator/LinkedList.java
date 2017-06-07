package dp.iterator;

public class LinkedList implements Collection {
    public void add(Object o) {
        Node n = new Node(o, null);
        if (head == null) {
            head = n;
            tail = n;
        }
        
        tail.setNext(n);
        tail = n;
        size++;
    }
    
    public int size() {
        return size;
    }
    
    public Iterator iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator {

        public Object next() {
            if (currentNode == null) {
                return null;
            }
            
            Node n = currentNode;
            
            currentNode = currentNode.getNext();
            
            return n;
        }

        public boolean hasNext() {
            if (currentNode.getNext() == null) {
                return false;
            } else {
                return true;
            }
        }
        
        private Node currentNode = head;
    }
    
    private Node head = null;
    private Node tail = null;
    private int size = 0;
}
