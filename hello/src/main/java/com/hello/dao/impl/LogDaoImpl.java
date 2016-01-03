package com.hello.dao.impl;

import com.hello.dao.LogDao;
import com.hello.entity.Log;
import org.springframework.stereotype.Repository;

/**
 * Created by xuan on 2015/12/31.
 */
@Repository("logDao")
public class LogDaoImpl extends BaseDaoImpl <Log, Integer> implements LogDao {

}
