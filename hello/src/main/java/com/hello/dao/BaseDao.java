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
     * 保存实体
     * @param object
     */
    public void save(Object object);

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    public T get(ID id);

    /**
     * 根据name属性获取记录集合
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
     * 根据实体删除记录
     * @param object
     */
    public void delete(Object object);

    /**
     * 获取所有的记录集
     * @return
     */
    public List<T> getAll();

    /**
     * 获取记录数目
     * @return
     */
    public Long getCount();

    /**
     * 根据hql获取记录数目
     * @param hql
     * @return
     */
    public Long getCount(String hql);

    /**
     * 根据hql和属性获取数目
     * @param hql
     * @param params
     * @return
     */
    public Long getCount(String hql, Object... params);

    /**
     * 根据hql获取记录集
     * @param hql
     * @return
     */
    public List<T> getByHql(String hql);

    /**
     * 根据hql和参数获取记录集
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
     * 根据hql分页获取记录
     * @param hql
     * @param current
     * @param size
     * @return
     */
    public Page<T> getByPage(String hql, int current, int size);

    /**
     * 根据hql和参数分页获取记录
     * @param hql
     * @param current
     * @param size
     * @param params
     * @return
     */
    public Page<T> getByPage(String hql, int current, int size, Object... params);

    /**
     * 批量保存
     * @param collection
     */
    public void batchSave(Collection<T> collection);

    /**
     * 批量更新
     * @param collection
     */
    public void batchUpdate(Collection<T> collection);

    /**
     * 根据id集批量删除记录
     * @param ids
     */
    public void batchDelete(ID[] ids);
}
