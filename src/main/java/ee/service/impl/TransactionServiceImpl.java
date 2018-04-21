package ee.service.impl;

import ee.bean.Product;
import ee.bean.User;
import ee.dao.test.ProductMapper;
import ee.dao.test.UserDao;
import ee.service.ITransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * Created by ping.wu on 2018/4/7.
 */
@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductMapper productMapper;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Transactional(propagation = Propagation.MANDATORY)
    public void insertUser1() {
        User user = new User(3, "insertUser1", 1);
        userDao.insert(user);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void insertUser2() {
        User user = new User(4, "insertUser2", 2);
        userDao.insert(user);
    }

    public void transaction1() {
        insertUser1();
        insertUser2();
    }

    public void exclusiveLockTest() throws Exception {
        for (int i = 0; i < 5; i++) {
            testGetData(i);
        }
    }

    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    public void testGetData(int id) {
        new Thread(() -> {
            Product product = productMapper.getTableLock(1L);
            log.info("Thread :" + id + "get the lock, count=" + product.getId());
            try {
                TimeUnit.SECONDS.sleep(2);
                productMapper.decreCount(product);
            } catch (InterruptedException e) {
                log.info("thread interrupted!");
            }
            System.out.println("product update success!");
        }).start();
    }
}
