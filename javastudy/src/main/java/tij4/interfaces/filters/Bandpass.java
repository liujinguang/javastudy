package interfaces.filters;

public class Bandpass extends Filter {
    double lowCutoff, highCutoff;

    public Bandpass(double lowCutoff, double highCutoff) {
        this.lowCutoff = lowCutoff;
        this.highCutoff = highCutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return super.process(input);
    }
}
