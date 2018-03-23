package ee.dao.test;

import ee.bean.Test;
import ee.dao.BaseDao;
import ee.dao.MybatisDao;

/**
 * Created by Administrator on 2018/3/23.
 */
@MybatisDao
public interface TestDao extends BaseDao<Test> {

}
