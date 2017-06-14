package interview.keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
//import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *  使用transient关键字不序列化某个变量. 注意读取的时候，读取数据的顺序一定要
 *  和存放数据的顺序保持一致
 *  序列化的实现：将需要被序列化的类实现 Serializable 接口，该接口没有需要实
 *  现的方法， implements Serializable 只是为了标注该对象是可被序列化的，
 *  然后使用一个输出流(如：FileOutputStream)来构造一个ObjectOutputStream
 *  (对象流)对象，接着，使用ObjectOutputStream对象的writeObject(Object obj)
 *  方法就可以将参数为obj的对象写出(即保存其状态)，要恢复的话则用输入流。
 * */

class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8490186179449464048L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String name;
	private transient String password;

}

public class TransientTest {
	public static void main(String[] args) {
		User user = new User();
		user.setName("Alexia");
		user.setPassword("123456");
		
		System.out.println("Read before Seriable:");
		System.out.println("username: " + user.getName());
		System.out.println("password: " + user.getPassword());
		
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("user.dat"));
			output.writeObject(user);
			output.flush();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("user.dat"));
			User newUser = (User) input.readObject();
			input.close();
			
			System.out.println("After before Seriable:");
			System.out.println("username: " + newUser.getName());
			System.out.println("password: " + newUser.getPassword());			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
}
