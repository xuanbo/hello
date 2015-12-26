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
     * �洢����
     * @param object
     */
    public void save(Object object);

    /**
     * ����id��ȡ����
     * @param id
     * @return
     */
    public T get(ID id);

    /**
     * ����name��ȡ���ݼ�¼
     * @param name
     * @return
     */
    public List<T> getByName(String name);

    /**
     * ���¼�¼
     * @param object
     */
    public void updata(Object object);

    /**
     * ����idɾ����¼
     * @param id
     */
    public void delete(ID id);

    /**
     * ���ݶ���ɾ����¼
     * @param object
     */
    public void delete(Object object);

    /**
     * ��ȡ���м�¼
     * @return
     */
    public List<T> getAll();

    /**
     * ��ȡ�ܵļ�¼��
     * @return
     */
    public Long getCount();

    /**
     * ����hql����ѯ��¼����
     * @param hql
     * @return
     */
    public Long getCount(String hql);

    /**
     * ����hql���Ͳ�����ȡ��¼����
     * @param hql
     * @param params
     * @return
     */
    public Long getCount(String hql, Object... params);

    /**
     * ����hql����ȡ��¼
     * @param hql
     * @return
     */
    public List<T> getByHql(String hql);

    /**
     * ����hql����ȡ��¼
     * @param hql
     * @param params
     * @return
     */
    public List<T> getByHql(String hql, Object... params);

    /**
     * ��ҳ��ȡ��¼
     * @param current
     * @param size
     * @return
     */
    public Page<T> getByPage(int current, int size);

    /**
     * ����hql����ҳ��ȡ��¼
     * @param hql
     * @param current
     * @param size
     * @return
     */
    public Page<T> getByPage(String hql, int current, int size);

    /**
     * ����hql����ҳ��ȡ��¼
     * @param hql
     * @param current
     * @param size
     * @param params
     * @return
     */
    public Page<T> getByPage(String hql, int current, int size, Object... params);

    /**
     * �����洢��¼
     * @param collection
     */
    public void batchSave(Collection<T> collection);

    /**
     * �������¼�¼
     * @param collection
     */
    public void batchUpdate(Collection<T> collection);

    /**
     * ����id��ɾ������ɾ����¼
     * @param ids
     */
    public void batchDelete(ID[] ids);
}
