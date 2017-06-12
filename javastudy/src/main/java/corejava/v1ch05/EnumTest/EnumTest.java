package v1ch05.EnumTest;

import java.util.Scanner;

public class EnumTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Eneter a Size(SMALL, MEDIUM, LARGE, EXTRA_LARGE):");
		String input = in.next().toUpperCase();
		Size size = Enum.valueOf(Size.class, input);
		System.out.println("size = " + size);
		System.out.println("Abbreviation=" + size.getAbbreviation());
		if (size == Size.EXTRA_LARGE) {
			System.out.println("Good job -- you paid attention to the ");
		}
	}
}

enum Size {
	SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
	
	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	private String abbreviation;
}