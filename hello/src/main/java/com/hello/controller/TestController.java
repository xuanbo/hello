package com.hello.controller;

import com.hello.entity.User;
import com.hello.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by xuan on 2015/12/26.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAll());
        return "test/list";
    }

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
        modelMap.addAttribute("users", userService.getByPage(current, size));
        return "test/userList";
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String list(ModelMap modelMap){
//        modelMap.addAttribute("users", userServicer.getByCriteria());
//        return "test/list";
//    }

    /**
     * 测试不定数组查询
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/isFind", method = RequestMethod.GET)
    public @ResponseBody List<User> isFind(@RequestParam String name, @RequestParam String password){
        String hql = "from User u where u.name=? and u.password=?";
        List<User> users = userService.getByHql(hql, name, password);
        return users;
    }


    /**
     * 测试json
     * @param jsonObject
     * @return
     */
    @RequestMapping(value = "/jsonTest", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> jsonTest(@RequestBody JSONObject jsonObject){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", jsonObject);
        return map;
    }

}
