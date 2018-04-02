package dubbo.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2018/4/2.
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] { "application-dubbo.xml" });
        context.start();
        System.out.println("输入任意按键退出 ~ ");
        System.in.read();
        context.close();
    }
}
