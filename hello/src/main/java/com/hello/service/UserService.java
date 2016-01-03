package com.hello.service;

import com.hello.entity.User;

/**
 * Created by xuan on 2015/12/26.
 */
public interface UserService extends BaseService <User, Integer> {

    /**
     * 验证登陆
     * @param name
     * @param password
     * @return
     */
    public boolean isFindPasswordByName(String name, String password);
}
