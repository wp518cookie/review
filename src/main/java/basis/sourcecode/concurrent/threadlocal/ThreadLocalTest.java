package basis.sourcecode.concurrent.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/11/30.
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person("wp", "18");
        ThreadLocal<Person> threadLocal = new ThreadLocal();
        threadLocal.set(person);
        Thread2 thread2 = new Thread2(threadLocal, person);
        new Thread(thread2).start();
        TimeUnit.SECONDS.sleep(1);
        Person person1 = threadLocal.get();
        System.out.println(person1.getName());
        System.out.println(person1.getAge());
    }
}
