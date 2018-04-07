package test.mybatis;

import ee.bean.Test;

/**
 * Created by ping.wu on 2018/4/6.
 */
public interface TestMapper1 {
    void insertTest(Test test);
//    Test getUser(Integer id);
    Test getUser(Test test);
}
