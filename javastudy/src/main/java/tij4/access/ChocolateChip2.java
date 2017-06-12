package access;

import access.cookie2.Cookie;

public class ChocolateChip2 extends Cookie {
	public ChocolateChip2() {
		System.out.println("ChocolateChip2 constructor");
	}

	public void chomp() {
		bite(); /// protected method
	}

	public static void main(String[] args) {
		ChocolateChip x = new ChocolateChip();
		x.chomp();
	}
}
