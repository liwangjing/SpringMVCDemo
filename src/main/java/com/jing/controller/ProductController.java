package com.jing.controller;

import com.jing.domain.Product;
import com.jing.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jing on 2017/2/16.
 */
@Controller
public class ProductController {
    protected final Log logger = LogFactory.getLog(getClass());

//    @Autowired
//    private ApplicationContext context;

    @Autowired
    private ProductManager productManager;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ModelAndView handleProductRequest() {
        String now = (new Date()).toString();
        logger.info("returning view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("product", "model", myModel);
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
