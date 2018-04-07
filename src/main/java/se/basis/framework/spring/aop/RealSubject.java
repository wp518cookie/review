package se.basis.framework.spring.aop;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/3/20.
 */
public class RealSubject extends HashMap implements Subject, Subject1  {
    public void doSomething() {
        System.out.println("Hello World!");
    }
    public void doSomething1() {
        System.out.println("Hello World1!");
    }
}
