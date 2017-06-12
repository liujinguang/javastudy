package polymorphisim.music3;

import static net.mindview.util.Print.*;

import polymorphisim.music.Note;

class Instrument {
	void play(Note n) {
		print("Instrument.play() " + n);
	}

	String what() {
		return "Instrument";
	}

	@Override
	public String toString() {
		return "Instrument";
	}

	void adjust() {
		print("Adjusting Instrument");
	}
}

class Wind extends Instrument {
	@Override
	void play(Note n) {
		print("Wind.play() " + n);
	}

	@Override
	String what() {
		return "Wind";
	}

	@Override
	public String toString() {
		return "Wind";
	}

	@Override
	void adjust() {
		print("Adjusting Wind");
	}
}

class Percussion extends Instrument {
	@Override
	void play(Note n) {
		print("Percussion.play() " + n);
	}

	@Override
	String what() {
		return "Percussion";
	}

	@Override
	public String toString() {
		return "Percusssion";
	}

	@Override
	void adjust() {
		print("Adjusting Percussion");
	}
}

class Stringed extends Instrument {
	@Override
	void play(Note n) {
		print("Stringed.play() " + n);
	}

	@Override
	String what() {
		return "Stringed";
	}

	@Override
	public String toString() {
		return "Stringed";
	}

	@Override
	void adjust() {
		print("Adjusting Stringed");
	}
}

class Brass extends Wind {
	@Override
	void play(Note n) {
		print("Brass.play() " + n);
	}

	@Override
	public String toString() {
		return "Brass";
	}

	@Override
	void adjust() {
		print("Brass Stringed");
	}
}

class Woodwind extends Wind {
	@Override
	void play(Note n) {
		print("Woodwind.play() " + n);
	}

	@Override
	public String toString() {
		return "Woodwind";
	}

	@Override
	String what() {
		return "Woodwind";
	}
}

public class Music3 {
	// Doesn't care about type, so new types
	// added to the system still work right
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	public static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}

	public static void main(String[] args) {
		// upcasting during addition to the array
		Instrument[] orchestra = { new Instrument(), new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };

		tuneAll(orchestra);

		print("============================");
		for (Instrument i : orchestra) {
			System.out.println(i);
			// print(orchestra);
		}
	}

}
