package blog.java.unsafe;

import sun.misc.Unsafe;

/**
 * Created by Administrator on 2018/1/19.
 */
public class ObjectOffsetTest {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = UnsafeGenerator.getUnsafe();
        Person person = new Person();
        //拿到name的属性的内存偏移量
        long nameOffset = unsafe.objectFieldOffset(Person.class.getDeclaredField("name"));
        unsafe.putObject(person, nameOffset, "hello world");
        System.out.println(person.getName());
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }
}
