package com.hello.dao.impl;

import com.hello.dao.BaseDao;
import com.hello.model.Page;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by xuan on 2015/12/26.
 */
public class BaseDaoImpl <T, ID extends Serializable> implements BaseDao <T, ID> {

    /**
     * 获取实体类的名字，用于hibernate操作数据库
     * hibernate中hql语句操作数据库是根据实体类进行操作，而不是根据表名进行操作
     */
    private Class<T> entityClass;

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory hibernateSessionFactory;

    public BaseDaoImpl() {
        Type genericType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genericType).getActualTypeArguments();
        entityClass = (Class) params[0];
    }

    protected Session getHibernateSession() {
        return this.hibernateSessionFactory.getCurrentSession();
    }


    public void save(Object object) {
        this.getHibernateSession().save(object);
    }

    public T get(ID id) {
        return (T) this.getHibernateSession().get(entityClass, id);
    }

    public List<T> getByName(String name) {
        String hql = "from " + entityClass.getName() + " t where t.name=?";
        Query query = this.getHibernateSession().createQuery(hql);
        query.setParameter(0, name);
        return query.list();
    }

    public void updata(Object object) {
        this.getHibernateSession().update(object);
    }

    public void delete(ID id) {
        Object object = this.get(id);
        this.delete(object);
    }

    public void delete(Object object) {
        this.getHibernateSession().delete(object);
    }

    public List<T> getAll() {
        String hql = "from " + entityClass.getName();
        Query query = this.getHibernateSession().createQuery(hql);
        return query.list();
    }

    public Long getCount() {
        String hql = "select count(*) from " + entityClass.getName();
        Query query = this.getHibernateSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    public Long getCount(String hql) {
        Query query = this.getHibernateSession().createQuery(hql);
        return (Long) query.uniqueResult();
    }

    public Long getCount(String hql, Object... params) {
        Query query = this.getHibernateSession().createQuery(hql);
        for (int index = 0; index < params.length; index ++){
            query.setParameter(index, params[index]);
        }
        return (Long) query.uniqueResult();
    }

    public List<T> getByHql(String hql) {
        Query query = this.getHibernateSession().createQuery(hql);
        return query.list();
    }

    public List<T> getByHql(String hql, Object... params) {
        if (params == null || params.length == 0){
            return Collections.emptyList();
        }else{
            Query query = this.getHibernateSession().createQuery(hql);
            for (int index = 0; index < params.length; index ++){
                query.setParameter(index, params[index]);
            }
            return query.list();
        }
    }

    public Page<T> getByPage(int current, int size) {
        String hql = "from " + entityClass.getName();
        Query query = this.getHibernateSession().createQuery(hql);
        query.setFirstResult((current - 1) * size);
        query.setMaxResults(size);

        Page<T> page = new Page<T>();
        page.setList(query.list());
        page.setCurrent(current);
        page.setSize(size);
        page.setTotalCount(this.getCount());
        return page;
    }

    public Page<T> getByPage(String hql, int current, int size) {
        Query query = this.getHibernateSession().createQuery(hql);
        query.setFirstResult((current - 1) * size);
        query.setMaxResults(size);

        Page<T> page = new Page<T>();
        page.setList(query.list());
        page.setCurrent(current);
        page.setSize(size);
        page.setTotalCount(this.getCount(hql));
        return page;
    }

    public Page<T> getByPage(String hql, int current, int size, Object... params) {
        if (params == null || params.length == 0) return null;
        else{
            Query query = this.getHibernateSession().createQuery(hql);
            for (int index = 0; index < params.length; index ++){
                query.setParameter(index, params[index]);
            }

            Page<T> page = new Page<T>();
            page.setList(query.list());
            page.setCurrent(current);
            page.setSize(size);
            page.setTotalCount(this.getCount(hql, params));
            return page;
        }
    }

    public void batchSave(Collection<T> collection) {
        for (T object : collection){
            this.save(object);
        }
    }

    public void batchUpdate(Collection<T> collection) {
        for (T object : collection){
            this.updata(object);
        }
    }

    public void batchDelete(ID[] ids) {
        for (int index = 0; index < ids.length; index ++){
            this.delete(ids[index]);
        }
    }
}
