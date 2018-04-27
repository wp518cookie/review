package se.se8.lamda;

/**
 * Created by ping.wu on 2018/4/23.
 */
public class LamdaTest {
    public static void main(String[] args) {
        String msg = getMsg("Hello, " , (String t)->{return t + "World";});
        System.out.println(msg);
    }

    public static String getMsg(String s, MyFunctionalInterface myFunctionalInterface) {
        return myFunctionalInterface.test1(s);
    }
}
