package ee.web_xml;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by ping.wu on 2018/4/6.
 */
public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener init");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("listener destroy");
    }
}
