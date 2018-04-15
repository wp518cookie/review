package ee.dao.test;

import ee.bean.Product;

import java.util.List;

/**
 * Created by Administrator on 2018/4/11.
 */
public interface ProductMapper {
    void insert(Product product);
    int updateCount(Product product);
    void getTableLock();
    List<Product> getProduct();
}
