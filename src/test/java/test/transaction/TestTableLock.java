package test.transaction;

import base.BaseJUnitTest;
import ee.bean.Product;
import ee.dao.test.ProductMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by ping.wu on 2018/4/13.
 */
public class TestTableLock extends BaseJUnitTest {
    @Autowired
    private ProductMapper productMapper;
    private static Logger log = LoggerFactory.getLogger(TestTableLock.class);

    @Test
    public void testTableLock() throws Exception {
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
               testGetData();
            }).start();
        }
        TimeUnit.SECONDS.sleep(10);
    }

    @Transactional
    public void testGetData() {
        productMapper.getTableLock();
        Product product = new Product();
        product.setId(1);
        productMapper.updateCount(product);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            log.info("thread interrupted!");
        }
        System.out.println("product update success!");
    }
}
