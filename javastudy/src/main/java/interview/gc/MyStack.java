package interview.gc;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
	private T[] elements;
	private int size = 0;
	private static final int INIT_CAPACITY = 16;
	
	public MyStack() {
		elements = (T[]) new Object[INIT_CAPACITY];
	}
	
    public void push(T elem) {  
        ensureCapacity();  
        elements[size++] = elem;  
    }  
	/*
	* 其中的 pop 却存在内存泄露的问题，当我们用 pop 方法弹出栈中的对象时，
	* 该对象不会被当作垃圾回收，即使使用栈的程序不再引用这些对象，因为栈内部
	* 维护着对这些对象的过期引用（obsolete reference）。在支持垃圾回收的
	* 语言中，内存泄露是很隐蔽的，这种内存泄露其实就是无意识的对象保持。如果一
	* 个对象引用被无意识的保留起来了，那么垃圾回收器不会处理这个对象，也不会处
	* 理该对象引用的其他对象，即使这样的对象只有少数几个，也可能会导致很多的
	* 对象被排除在垃圾回收之外，从而对性能造成重大影响，极端情况下会引发 
	* Disk Paging（物理内存与硬盘的虚拟内存交换数据），甚至造成 
	* OutOfMemoryError。
	*/
    public T pop() {  
        if(size == 0)   
            throw new EmptyStackException();  
        return elements[--size];  
    }  

    private void ensureCapacity() {  
        if(elements.length == size) {  
            elements = Arrays.copyOf(elements, 2 * size + 1);  
        }  
    }  	
}
