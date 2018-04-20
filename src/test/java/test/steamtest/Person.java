package test.steamtest;

/**
 * Created by ping.wu on 2018/4/19.
 */
public class Person {
    private String name;
    private Long id;

    public Person() {

    }

    public Person(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.id;
    }
}
