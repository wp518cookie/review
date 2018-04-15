package test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import se.basis.framework.spring.aop.Subject;
import se.basis.framework.spring.aop.Subject1;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ping.wu on 2018/4/6.
 */
public class TestMapperMain {
    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            ee.bean.Test test = new ee.bean.Test("tom", new Integer(5));
            testMapper.insertTest(test);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            ee.bean.Test test = testMapper.getUser(7);
            System.out.println("name: " + test.getName() + "|age: " + test.getAge());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getTest1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            ee.bean.Test param = new ee.bean.Test("tom", 7);
            ee.bean.Test test = testMapper.getUser(param);
            System.out.println("name: " + test.getName() + "|age: " + test.getAge());
        } finally {
            sqlSession.close();
        }
    }
}
