package se.basis.sourcecode.concurrent.threadlocal;

/**
 * Created by Administrator on 2017/11/30.
 */
public class Thread2 implements Runnable {
    private Person person;
    private ThreadLocal<Person> threadLocal;
    public Thread2(ThreadLocal threadLocal, Person person) {
        this.person = person;
        this.threadLocal = threadLocal;
    }

    public void run() {
        threadLocal.set(person);
        Person person = threadLocal.get();
        person.setName("robin");
        person.setAge("100");
        System.out.println("name:" + person.getName());
        System.out.println("age:" + person.getAge());
    }
}
