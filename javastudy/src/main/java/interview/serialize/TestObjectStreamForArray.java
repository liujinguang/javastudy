package interview.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStreamForArray {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int[] numbers = { 1, 2, 3, 4, 5 };
		String[] strings = { "John", "Jim", "Jake" };

		// create an output stream for file array.dat
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat", true));
		
		// write arrays to the object output stream
		output.writeObject(numbers);
		output.writeObject(strings);
		
		//close the stream
		output.close();
		
		//create an input stream for file array.dat
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));
		
		int[] newNumbers = (int[]) input.readObject();
		String[] newStrings = (String[]) input.readObject();
		
		for (int i=0; i < newNumbers.length; i++) {
			System.out.print(newNumbers[i] + " ");
		}
		System.out.println();
		
		for (String s:newStrings) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

}
