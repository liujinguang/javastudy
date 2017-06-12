package v1ch02.Welcome;

public class Welcome {

    public Welcome() {
    }
    
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = "Welcome to Core Java";
        strings[1] = "by Cay Horstman";
        strings[2] = "and Gary Cornell";
        
        for (String s : strings) {
            System.out.println(s);
        }
    }

}
