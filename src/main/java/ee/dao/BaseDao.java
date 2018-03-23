package ee.dao;

import java.util.List;

/**
 * Created by Administrator on 2016/10/19.
 */
public interface BaseDao<T> {
//    /**
//     * 获取单条数据
//     *
//     * @param id
//     * @return
//     */
//    public T get(String id);
//
//    /**
//     * 获取单条数据
//     *
//     * @param entity
//     * @return
//     */
//    public T get(T entity);
//
//    /**
//     * 查询数据列表
//     *
//     * @param eneity
//     * @return
//     */
//    public List<T> findList(T eneity);
//
//    /**
//     * 获得所有数据
//     *
//     * @return
//     */
//    public List<T> findAllList();

    /**
     * 插入
     * @param entity
     * @return
     */
    public int insert(T entity);

//    /**
//     * 更新
//     * @param entity
//     * @return
//     */
//    public int update(T entity);
//
//    /**
//     * 删除
//     * @param entity
//     * @return
//     */
//    public int delete(T entity);
}
