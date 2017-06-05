package tij4.reusing;

public class BlankFinal {
	// blank finals MUST be initialized in the constructor
	public BlankFinal() {
		j = 1; // Initialize blank final
		p = new Poppet(1); // Initialize blank final reference
	}

	public BlankFinal(int x) {
		j = x; // Initialize blank final
		p = new Poppet(x); // Initialize blank final reference
	}

	public static void main(String[] args) {
		new BlankFinal();
		new BlankFinal(47);
	}

	private final int i = 0; // Initialized final
	private final int j; // blank final
	private final Poppet p; // Blank final reference
}

class Poppet {
	public Poppet(int ii) {
		i = ii;
	}

	private int i;
}
