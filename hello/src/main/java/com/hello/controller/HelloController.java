package com.hello.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	private static Logger logger = Logger.getLogger(HelloController.class);

    /**
     * 欢迎页面
     * @return
     */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}


    /**
     * 访问被拒绝
     * @return
     */
    @RequestMapping(value = "/denies", method = RequestMethod.GET)
    public String denies(){
        return "denies";
    }
}