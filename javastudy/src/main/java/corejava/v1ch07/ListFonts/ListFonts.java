package v1ch07.ListFonts;

import java.awt.GraphicsEnvironment;
import java.util.Locale;

public class ListFonts {

    public ListFonts() {
    }

    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        
        for (String name : fontNames) {
            System.out.println(name);
        }
        
        
        Locale locale = Locale.getDefault();
        System.out.println(locale);
    }

}
