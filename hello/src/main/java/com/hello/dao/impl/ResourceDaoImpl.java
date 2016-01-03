package com.hello.dao.impl;

import com.hello.dao.ResourceDao;
import com.hello.entity.Resource;
import org.springframework.stereotype.Repository;

/**
 * Created by xuan on 16-1-2.
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl <Resource, Integer> implements ResourceDao {
}
