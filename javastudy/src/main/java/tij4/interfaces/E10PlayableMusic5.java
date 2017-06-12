package interfaces;

/****************** Exercise 10 ******************
* Add a Playable to Modify Music5.java, and move
* the play() declaration from Instrument to
* Playable. Include Playable in the implements
* list to add it to the derived classes.
* Change tune() so it takes a Playable instead
* of an Instrument.
***********************************************/

import static net.mindview.util.Print.print;

import polymorphisim.music.Note;

interface Playable {
    void play(Note n); // automatically public
}

interface Instrument {
    int value = 5; // static final

    void adjust();
}

class Wind implements Instrument, Playable {

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

class Percussion implements Instrument, Playable {

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

class Stringed implements Instrument, Playable {

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

public class E10PlayableMusic5 {
    // don't care about type, so new types
    // added to the system still work right
    static void tune(Playable i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playable[] e) {
        for (Playable i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        // upcasting during addition to the array
        Playable[] orchestra = { new Wind(), new Percussion(), new Stringed(),
                new Brass(), new Woodwind() };

        tuneAll(orchestra);
    }
}
