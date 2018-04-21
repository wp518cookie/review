package ee.service;

/**
 * Created by ping.wu on 2018/4/7.
 */
public interface ITransactionService {
    void insertUser1();
    void insertUser2();
    void transaction1();
    void exclusiveLockTest() throws Exception;
}
