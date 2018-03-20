package basis.framework.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/3/20.
 */
public class SubjectProxy implements InvocationHandler {
    private Object target;

    public SubjectProxy(Subject target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("Method start!");
        try {
            method.invoke(target, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Method end!");
        return null;
    }
}
