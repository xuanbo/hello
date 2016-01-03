package com.hello.controller;

import com.hello.security.CustomUserDetailsService;
import com.hello.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuan on 2015/12/31.
 */
@Controller
public class LoginController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("customUserDetailsService")
    private CustomUserDetailsService customUserDetailsService;

    /**
     * 登录页面
     * @param error
     * @param logout
     * @return
     */
    @RequestMapping(value = "/login**", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout){
        ModelAndView modelAndView = new ModelAndView();
        if (error != null){
            modelAndView.addObject("msg", "用户名不存在或密码错误");
        }
        if (logout != null) {
            modelAndView.addObject("msg", "你已经成功注销");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }


    /**
     * 登陆验证
     * @param jsonObject
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Map<String, String> login(@RequestBody JSONObject jsonObject, HttpSession session){
        Map<String, String> map = new HashMap<String, String>();
        String name = jsonObject.getString("name");
        String password = jsonObject.getString("password");
        if (userService.isFindPasswordByName(name, password)){
            /**
             * spring security 将权限及用户信息存入securityContext
             */
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(jsonObject.getString("name"));
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, userDetails.getPassword(), userDetails.getAuthorities());
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);
            session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

            map.put("flag", "true");
            map.put("msg", "登录成功");
        }else{
            map.put("flag", "false");
            map.put("msg", "用户名不存在或密码错误");
        }
        return map;
    }
}
