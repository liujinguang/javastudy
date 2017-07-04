package tij4.interfaces.classprocessor2;

import tij4.interfaces.filters.Bandpass;
import tij4.interfaces.filters.Filter;
import tij4.interfaces.filters.HighPass;
import tij4.interfaces.filters.LowPass;
import tij4.interfaces.filters.Waveform;
//本例子中使用了适配器设计模式。适配器中的代码将接受你所有的接口
//并产生你需要的接口
public class FilterAdapter implements Processor {
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    public String name() {
        return filter.name();
    }

    public Waveform process(Object input) {
        return filter.process((Waveform)input);
    }
    
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)), w);
        Apply.process(new FilterAdapter(new HighPass(2.0)), w);
        Apply.process(new FilterAdapter(new Bandpass(3.0, 4.0)), w);
    }

    private Filter filter;
}
