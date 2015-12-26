package com.hello.dao.impl;

import com.hello.dao.UserDao;
import com.hello.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by xuan on 2015/12/26.
 */
@Repository("userDao")
public class UserDaoimpl extends BaseDaoImpl <User, Integer> implements UserDao {

}
