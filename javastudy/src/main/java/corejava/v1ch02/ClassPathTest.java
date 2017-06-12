package corejava.v1ch02;

import java.io.File;

public class ClassPathTest {

    public ClassPathTest() {
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader()
                .getResource(""));
        System.out.println(ClassPathTest.class.getClassLoader().getResource(""));
        System.out.println(ClassPathTest.class.getResource("Cay.gif"));
        System.out.println(ClassPathTest.class.getResource("/"));
        System.out.println(ClassLoader.getSystemResource(""));
        System.out.println("6:" + new File("/").getAbsolutePath());  
        
        System.out.println("7:" + System.getProperty("java.home"));
        System.out.println("8:" + System.getProperty("user.home"));
    }
}
