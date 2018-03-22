package se.test;

/**
 * Created by ping.wu on 2018/2/14.
 */
public class TestInitial {
    static {
        System.out.println("i'm initialing");
    }
    public static void main(String[] args) throws Exception {
        Class testInitial = Class.forName("se.test.TestInitial");
        Class testInitial2 = String.class.getClassLoader().loadClass("java.lang.String");
    }
}
