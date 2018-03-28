package ee.service;

import ee.bean.Test;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/3/22.
 */
public interface ITestService {
    String testMethod1();
    String testMethod2() throws Exception;
    String testMethod3(Test test, HttpServletRequest req);
    String testMethod4();
}
