package dp.iterator;

public class ArrayList implements Collection {
    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length + STEPS];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }
    
    public int size() {
        return index;
    }
    
    public Iterator iterator() {
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator implements Iterator {

        public Object next() {
            return objects[currentIndex++];
        }

        public boolean hasNext() {
            if (currentIndex >= index) {
                return false;
            }
            else {
                return true;
            }
        }
        
        private int currentIndex = 0;
    }
    
    Object[] objects = new Object[STEPS];
    int index = 0;
    private static final int STEPS = 10;
}
