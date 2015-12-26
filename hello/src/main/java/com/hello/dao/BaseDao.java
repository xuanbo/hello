package com.hello.dao;

import com.hello.model.Page;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by xuan on 2015/12/26.
 */
public interface BaseDao <T, ID extends Serializable> {

    /**
     * 存储对象
     * @param object
     */
    public void save(Object object);

    /**
     * 根据id获取对象
     * @param id
     * @return
     */
    public T get(ID id);

    /**
     * 根据name获取数据记录
     * @param name
     * @return
     */
    public List<T> getByName(String name);

    /**
     * 更新记录
     * @param object
     */
    public void updata(Object object);

    /**
     * 根据id删除记录
     * @param id
     */
    public void delete(ID id);

    /**
     * 根据对象删除记录
     * @param object
     */
    public void delete(Object object);

    /**
     * 获取所有记录
     * @return
     */
    public List<T> getAll();

    /**
     * 获取总的记录数
     * @return
     */
    public Long getCount();

    /**
     * 根据hql语句查询记录条数
     * @param hql
     * @return
     */
    public Long getCount(String hql);

    /**
     * 根据hql语句和参数获取记录条数
     * @param hql
     * @param params
     * @return
     */
    public Long getCount(String hql, Object... params);

    /**
     * 根据hql语句获取记录
     * @param hql
     * @return
     */
    public List<T> getByHql(String hql);

    /**
     * 根据hql语句获取记录
     * @param hql
     * @param params
     * @return
     */
    public List<T> getByHql(String hql, Object... params);

    /**
     * 分页获取记录
     * @param current
     * @param size
     * @return
     */
    public Page<T> getByPage(int current, int size);

    /**
     * 根据hql语句分页获取记录
     * @param hql
     * @param current
     * @param size
     * @return
     */
    public Page<T> getByPage(String hql, int current, int size);

    /**
     * 根据hql语句分页获取记录
     * @param hql
     * @param current
     * @param size
     * @param params
     * @return
     */
    public Page<T> getByPage(String hql, int current, int size, Object... params);

    /**
     * 批量存储记录
     * @param collection
     */
    public void batchSave(Collection<T> collection);

    /**
     * 批量更新记录
     * @param collection
     */
    public void batchUpdate(Collection<T> collection);

    /**
     * 根据id集删除批量删除记录
     * @param ids
     */
    public void batchDelete(ID[] ids);
}
