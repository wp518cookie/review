package ee.dao.test;

import ee.bean.User;
import ee.dao.MybatisDao;

/**
 * Created by ping.wu on 2018/4/7.
 */
@MybatisDao
public interface UserDao {
    void insert(User user);
}
