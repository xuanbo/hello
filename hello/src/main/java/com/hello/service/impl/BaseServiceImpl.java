package com.hello.service.impl;

import com.hello.dao.BaseDao;
import com.hello.model.Page;
import com.hello.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by xuan on 2015/12/26.
 */
public class BaseServiceImpl <T, ID extends Serializable> implements BaseService <T, ID>{

    @Autowired
    protected BaseDao <T, ID> baseDao;


    public void save(Object object) {
        baseDao.save(object);
    }

    public T get(ID id) {
        return baseDao.get(id);
    }

    public List<T> getByName(String name) {
        return baseDao.getByName(name);
    }

    public void updata(Object object) {
        baseDao.updata(object);
    }

    public void delete(ID id) {
        baseDao.delete(id);
    }

    public void delete(Object object) {
        baseDao.delete(object);
    }

    public List<T> getAll() {
        return baseDao.getAll();
    }

    public Long getCount() {
        return baseDao.getCount();
    }

    public Long getCount(String hql) {
        return baseDao.getCount(hql);
    }

    public Long getCount(String hql, Object... params) {
        return baseDao.getCount(hql, params);
    }

    public List<T> getByHql(String hql) {
        return baseDao.getByHql(hql);
    }

    public List<T> getByHql(String hql, Object... params) {
        return baseDao.getByHql(hql, params);
    }

    public Page<T> getByPage(int current, int size) {
        return baseDao.getByPage(current, size);
    }

    public Page<T> getByPage(String hql, int current, int size) {
        return baseDao.getByPage(hql, current, size);
    }

    public Page<T> getByPage(String hql, int current, int size, Object... params) {
        return baseDao.getByPage(hql, current, size, params);
    }

    public void batchSave(Collection<T> collection) {
        baseDao.batchSave(collection);
    }

    public void batchUpdate(Collection<T> collection) {
        baseDao.batchUpdate(collection);
    }

    public void batchDelete(ID[] ids) {
        baseDao.batchDelete(ids);
    }
}
