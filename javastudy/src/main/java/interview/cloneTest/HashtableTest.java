package interview.cloneTest;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableTest {
	public static void main(String[] args) {
		/*
		 * 向Hashtable传递 StringBuffer对象是只传递了这个StringBuffer对象的引用！每一次向Hashtable表中put
		 * 一次 StringBuffer，并没有生成新的StringBuffer对象，只是在Hashtable表中又放入了一个指向同一
		 * StringBuffer对象的引用而已。对Hashtable表存储的任何一个StringBuffer对象（更确切的说应该是对象的引用）的
		 * 改动，实际上都是对同一个 "StringBuffer"的改动。所以Hashtable并不能真正存储能对象，而只能存储对象的引用。
		 * 也应该知道这条原则对与Hashtable相似的Vector, List, Map, Set等都是一样的。
		 * */
		Hashtable<String, StringBuffer> ht = new Hashtable<String, StringBuffer>();
		StringBuffer sb = new StringBuffer();
		
		sb.append("abc,");
		ht.put("1", sb);
        sb.append("def,");  
        ht.put("2", sb);  
        sb.append("mno,");  
        ht.put("3", sb);  
        sb.append("xyz.");  
        ht.put("4", sb);  
        
        int numObjs = 0;
        Enumeration<StringBuffer> it = ht.elements();
        
        while (it.hasMoreElements()) {
        	System.out.print("get StringBuffer " + (++numObjs) + " from Hashtable: ");
        	System.out.println(it.nextElement());
        }
		
	}
}
