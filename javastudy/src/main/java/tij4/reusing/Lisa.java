package tij4.reusing;

public class Lisa extends Bart {
    @Override
    void doh(Milhouse m) {
        System.out.println("doh(Milhouse)1;");
        super.doh(m);
    }
    
    public static void main(String[] args) {
        Lisa l = new Lisa();
        l.doh(new Milhouse());
    }
}
