package ee.service.impl;

import ee.bean.Test;
import ee.dao.test.TestDao;
import ee.service.ITestService;
import org.apache.kafka.clients.producer.internals.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Administrator on 2018/3/22.
 */
@Service
public class TestServiceImpl implements ITestService {
    @Autowired
    private TestDao testDao;
    @Autowired
    private TransactionTemplate transactionTemplate;

    public String testMethod1() {
        Test test = new Test("robin", 123);
        Object result = transactionTemplate.execute(new TransactionCallback(){
            public Object doInTransaction(TransactionStatus var1) {
                testDao.insert(test);
                return null;
            }
        });
        return "123";
    }
}
