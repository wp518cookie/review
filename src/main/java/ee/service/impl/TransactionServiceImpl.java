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

    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void insertUser1(User user) {
        insertUser2(user);
        user.setAge(1);
        userDao.insert(user);
        throw new NullPointerException();
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public void insertUser2(User user) {
        user.setAge(2);
        userDao.insert(user);
    }
}
