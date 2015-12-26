package com.hello.controller;

import com.hello.service.UserServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by xuan on 2015/12/26.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    @Qualifier("userService")
    private UserServicer userServicer;


    /**
     *测试freeMarker
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/listByFreemarker", method = RequestMethod.GET)
    public String listByFreemarker(ModelMap modelMap){
        modelMap.addAttribute("users", userServicer.getAll());
        return "test/userList";
    }
}
