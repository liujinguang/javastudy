package interfaces.music4;

import polymorphisim.music.Note;
import static net.mindview.util.Print.*;

abstract class Instrument {
    private int i; // storage allocated for each

    public abstract void play(Note n);

    public String what() {
        return "Instrument";
    }

    public abstract void adjust();
}

class Wind extends Instrument {

    @Override
    public void play(Note n) {
        print("Wind.play() " + n);
    }

    @Override
    public void adjust() {
    }

    @Override
    public String what() {
        return "Wind";
    }

}

class Percussion extends Instrument {

    @Override
    public void play(Note n) {
        print("Percussion.play() " + n);
    }

    @Override
    public void adjust() {

    }

    @Override
    public String what() {
        return "Percussion";
    }
}

class Stringed extends Instrument {

    @Override
    public void play(Note n) {
        print("Stringed.play() " + n);
    }

    @Override
    public void adjust() {

    }

    @Override
    public String what() {
        return "Percussion";
    }
}

class Brass extends Wind {
    @Override
    public void play(Note n) {
        print("Brass.play() " + n);
    }

    @Override
    public void adjust() {
        print("Brass.adjust()");
    }
}

class Woodwind extends Wind {
    @Override
    public void play(Note n) {
        print("Woodwind.play() " + n);
    }

    @Override
    public String what() {
        return "Woodwind";
    }
}

public class Music4 {
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
        Instrument[] orchestra = { 
                new Wind(), 
                new Percussion(),
                new Stringed(), 
                new Brass(), 
                new Woodwind() };

        tuneAll(orchestra);
    }
}
