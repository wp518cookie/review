package dubbo.demo;

/**
 * Created by Administrator on 2018/4/2.
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        System.out.println("init : " + name);
        return "hello " + name;
    }
}
