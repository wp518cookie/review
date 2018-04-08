package ee.service.impl;

import ee.bean.User;
import ee.dao.test.UserDao;
import ee.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ping.wu on 2018/4/7.
 */
@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    public UserDao userDao;

    @Transactional(propagation= Propagation.MANDATORY)
    public void insertUser1() {
            User user = new User(3, "insertUser1", 1);
            userDao.insert(user);
    }

    @Transactional(propagation= Propagation.MANDATORY)
    public void insertUser2() {
        User user = new User(4, "insertUser2", 2);
        userDao.insert(user);
    }

    public void transaction1() {
        insertUser1();
        insertUser2();
    }
}
