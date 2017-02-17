package com.jing.controller;

import com.jing.service.ProductManager;
import com.mchange.v1.identicator.IdHashMap;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jing on 2017/1/30.
 */
@Controller //use annotation to explicitly define this class as Controller that handle request
public class MainController {

    protected final Log logger = LogFactory.getLog(getClass());

    // @RequestMapping 注解， 用于定义一个请求映射
    // value 为请求的url， 值设为“/” 说明这是首页请求
    // method用于指定请求类型。 GET/POST/DELETE ...
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index"; //retrun index: 处理完该请求后返回的界面， 此处请求返回 index.jsp界面
    }

    @RequestMapping(value="/time", method = RequestMethod.GET)
    public ModelAndView handleTimeRequest() {
        String now = (new Date()).toString();
        logger.info("returning view with " + now);

        return new ModelAndView("hello", "now", now);
    }

    // use this method, can not connect this 'now' string to the jsp file
//    @RequestMapping(value="/time", method = RequestMethod.GET)
//    public String handleRequest() {
//        String now = (new Date()).toString();
//        logger.info("returning view with " + now);
//        return "hello";
//    }
}
