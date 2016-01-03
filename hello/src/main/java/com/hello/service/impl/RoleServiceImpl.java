package com.hello.service.impl;

import com.hello.entity.Role;
import com.hello.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * Created by xuan on 16-1-2.
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl <Role, Integer> implements RoleService {
}
