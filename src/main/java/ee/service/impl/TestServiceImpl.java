package ee.service.impl;

import ee.bean.Test;
import ee.dao.test.TestDao;
import ee.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
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

    //编程式事务
    public String testMethod1() {
        Test test = new Test("wp", 45);
        Object result = transactionTemplate.execute(new TransactionCallback(){
            public Object doInTransaction(TransactionStatus var1) {
                try {
                    testDao.insert(test);
                    throw new NullPointerException();
                } catch (Exception e) {
                    System.out.println("回滚");
                    var1.setRollbackOnly();
                }
                return null;
            }
        });
        return "bian cheng shi shi wu";
    }

    //声明式事务
    @Transactional(noRollbackFor = {NullPointerException.class})
    public String testMethod2() throws Exception {
        Test test = new Test("robin", 1);
        testDao.insert(test);
        throw new NullPointerException();
//        return "sheng ming shi shi wu";
    }
}
