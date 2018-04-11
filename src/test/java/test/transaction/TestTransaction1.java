package test.transaction;

import base.BaseJUnitTest;
import ee.bean.Product;
import ee.bean.User;
import ee.dao.test.UserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ee.dao.test.ProductMapper;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ping.wu on 2018/4/7.
 */
public class TestTransaction1 extends BaseJUnitTest{
    private Logger logger = LoggerFactory.getLogger(TestTransaction1.class);
    private volatile AtomicInteger successCount = new AtomicInteger(0);
    private volatile AtomicInteger failCount = new AtomicInteger(0);
    @Autowired
    private UserDao UserDao;
    @Autowired
    private ProductMapper productMapper;

    @Test
    @Transactional
    public void insertTest1() {
        User user = new User("insertTest1", 18);
        UserDao.insert(user);
    }

    @Test
    public void testUpdate() throws Exception {
        for (int i = 0; i < 300; i++) {
            new Thread(()-> {
                Product product = new Product();
                product.setId(1);
                if (productMapper.updateCount(product) == 1) {
                    successCount.getAndIncrement();
                } else {
                    failCount.getAndIncrement();
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(10);
        logger.info("----------------success count:" + successCount + "--------");
        logger.info("----------------fail count:" + failCount + "---------");
    }
}
