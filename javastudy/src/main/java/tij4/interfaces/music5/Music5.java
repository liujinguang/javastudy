package tij4.interfaces.music5;

import static tij4.net.mindview.util.Print.print;

import tij4.polymorphisim.music.Note;

interface Instrument {
	int value = 5; // static final

	void play(Note n); // automatically public

	void adjust();
}

class Wind implements Instrument {

	public void play(Note n) {
		print(this + ".play() " + n);
	}

	public void adjust() {
		print(this + ".adjust()");
	}

	@Override
	public String toString() {
		return "Wind";
	}
}

class Percussion implements Instrument {

	public void play(Note n) {
		print(this + ".play() " + n);
	}

	public void adjust() {
		print(this + ".adjust()");
	}

	@Override
	public String toString() {
		return "Percussion";
	}
}

class Stringed implements Instrument {

	public void play(Note n) {
		print(this + ".play() " + n);
	}

	public void adjust() {
		print(this + ".adjust()");
	}

	@Override
	public String toString() {
		return "Stringed";
	}
}

class Brass extends Wind {
	@Override
	public String toString() {
		return "Brass";
	}
}

class Woodwind extends Wind {
	@Override
	public String toString() {
		return "Woodwind";
	}
}

public class Music5 {
	// don't care about type, so new types
	// added to the system still work right
	static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
			tune(i);
		}
	}

	public static void main(String[] args) {
		// upcasting during addition to the array
		Instrument[] orchestra = { new Wind(), new Percussion(), new Stringed(), new Brass(), new Woodwind() };

		tuneAll(orchestra);
	}
}
