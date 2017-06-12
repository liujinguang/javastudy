package initialization;
/****************** Exercise 01 ****************
* Create a class with an uninitialized
* String reference. Demonstrate that this
* reference is initialized by Java to null.
***********************************************/
public class E01StringRefInitialization {
    private String s;
    
    public static void main(String[] args) {
        E01StringRefInitialization sri = new E01StringRefInitialization();
        System.out.print(sri.s);
    }
}
