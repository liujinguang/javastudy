package tij4.interfaces.filters;

public class Filter {
    public String name() {
        return getClass().getName();
    }
    
    public Waveform process(Waveform input) {
        return input;
    }
}
