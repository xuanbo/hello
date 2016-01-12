package com.hello.service.impl;

import com.hello.entity.User;
import com.hello.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuan on 2015/12/26.
 */
@Service("userService")
public class UserServiceImpl  extends BaseServiceImpl <User, Integer> implements UserService {

    public boolean isFindPasswordByName(String name, String password) {
        List<User> users = super.getByName(name);
        if(users.size() == 0){
            return false;
        }else if(users.get(0).getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
