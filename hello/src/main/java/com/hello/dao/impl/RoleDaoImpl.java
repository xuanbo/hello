package com.hello.dao.impl;

import com.hello.dao.RoleDao;
import com.hello.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by xuan on 16-1-2.
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl <Role, Integer> implements RoleDao {
}
