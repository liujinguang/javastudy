package interview.cloneTest;

public class StrClone implements Cloneable {

	@Override
	public StrClone clone() throws CloneNotSupportedException {
		StrClone o = null;
		try {
			o = (StrClone) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			
			throw(e);
		}
		
		return o;
	}
	
	public static void main(String[] args) {
		StrClone c1 = new StrClone();  
        c1.str = new String("initializeStr");  
        c1.strBuff = new StringBuffer("initializeStrBuff");  
        System.out.println("before clone,c1.str = " + c1.str);  
        System.out.println("before clone,c1.strBuff = " + c1.strBuff);  
  
        StrClone c2;
		try {
			c2 = (StrClone) c1.clone();
	        c2.str = c2.str.substring(0, 5);  
	        c2.strBuff = c2.strBuff.append(" change strBuff clone");  
	        System.out.println("=================================");  
	        System.out.println("after clone,c1.str = " + c1.str);  
	        System.out.println("after clone,c1.strBuff = " + c1.strBuff);  
	        System.out.println("=================================");  
	        System.out.println("after clone,c2.str = " + c2.str);  
	        System.out.println("after clone,c2.strBuff = " + c2.strBuff);  			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}
	
	public String str;
	public StringBuffer strBuff;
}
