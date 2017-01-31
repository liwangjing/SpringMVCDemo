package com.jing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jing on 2017/1/30.
 */
@Controller //use 注解to explicitly define this class as Controller that handle request
public class MainController {

    // @RequestMapping 注解， 用于定义一个请求映射
    // value 为请求的url， 值设为“/” 说明这是首页请求
    // method用于指定请求类型。 GET/POST/DELETE ...
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index"; //retrun index: 处理完该请求后返回的界面， 此处请求返回 index.jsp界面
    }
}
