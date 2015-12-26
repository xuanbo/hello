package com.hello.service.impl;

import com.hello.entity.User;
import com.hello.service.UserServicer;
import org.springframework.stereotype.Service;

/**
 * Created by xuan on 2015/12/26.
 */
@Service("userService")
public class UserServiceImpl  extends BaseServiceImpl <User, Integer> implements UserServicer {

}
