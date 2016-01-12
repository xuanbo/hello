package com.hello.controller;

import com.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xuan on 16-1-12.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "admin/index";
    }
}
