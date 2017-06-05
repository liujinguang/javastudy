package sword4offer.task01;


public class SingletonTest {
	public static class Singleton {
		/*
		 * 单利模式，线程安全
		 */
		public static volatile Singleton instance = new Singleton();
		
		private Singleton() {
			
		}
		
		public static Singleton getInstance() {
			return instance;
		}
	}
	
	/*
	 * 单例模式，线程不安全
	 * */
	public static class Singleton2 {
		public static Singleton2 instance = null;
		
		private Singleton2() {
			
		}
		
		public static Singleton2 getInstance() {
			if (instance == null) {
				instance = new Singleton2();
			}
			
			return instance;
		}
	}
	
	
	public static class Singleton3 {
		public static Singleton3 instance = null;
		
		private Singleton3() {
			
		}
		
		public static synchronized Singleton3 getInstance() {
			if (instance == null) {
				instance = new Singleton3();
			}
			
			return instance;
		}
	}
	
	public static class Singleton5 {
		public static Singleton5 instance = null;
		
		private Singleton5() {
			
		}
		
		public static Singleton5 getInstance() {
			if (instance == null) {
				synchronized(Singleton5.class) {
					if (instance == null) {
						instance = new Singleton5();
					}
				}
			}
			
			return instance;
		}
	}
	
	
	public static class Singleton4 {
		public static Singleton4 instance = null;
		
		static {
			instance = new Singleton4();
			System.out.println("BBB");
		}
		
		private Singleton4() {
			
		}
		
		public static Singleton4 getInstance() {
			return instance;
		}
	}
	
	public static class Singleton6 {
		private final static class SingletonHolder {
			public static final Singleton6 instance = new Singleton6();
			static  {
				System.out.println("aaa");
			}
		}
		
		private Singleton6() {
		}
		
		public static Singleton6 getInstance() {
			return SingletonHolder.instance;
		}
	}
	
	public enum Singleton7 {
		INSTANCE;
		
		public void whateverMethod() {
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance() == Singleton.getInstance());
		System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
		System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
		System.out.println(Singleton6.getInstance() == Singleton6.getInstance());
	}
}
