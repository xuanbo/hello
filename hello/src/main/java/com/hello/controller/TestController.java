package com.hello.controller;

import com.hello.service.UserServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
     * 测试freeMarker
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/listByFreemarker", method = RequestMethod.GET)
    public String listByFreemarker(@RequestParam(required = false, defaultValue = "1") int current,
            @RequestParam(required = false, defaultValue = "10") int size,
                                   ModelMap modelMap){
        modelMap.addAttribute("message","用户列表测试");
        modelMap.addAttribute("users", userServicer.getByPage(current, size));
        return "test/userList";
    }
    
}
