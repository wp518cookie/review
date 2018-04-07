package test.transaction;

import base.BaseJUnitTest;
import ee.bean.User;
import ee.dao.test.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ping.wu on 2018/4/7.
 */
public class TestTransaction1 extends BaseJUnitTest{
    @Autowired
    private UserDao UserDao;

    @Test
    @Transactional
    public void insertTest1() {
        User user = new User("insertTest1", 18);
        UserDao.insert(user);
    }

    public void insertTest2() {
        String name = "insertTest2";
        String age = "18";
    }
}
