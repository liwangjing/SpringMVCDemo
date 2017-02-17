package com.jing.controller;


import com.jing.service.PriceIncrease;
import com.jing.service.PriceIncreaseValidator;
import com.jing.service.ProductManager;
import com.sun.media.jfxmedia.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jing on 2017/2/16.
 */
@Controller
@RequestMapping("/priceincrease")
public class PriceIncreaseFormController {

    protected final Log logger = LogFactory.getLog(getClass());
    private PriceIncreaseValidator priceIncreaseValidator = new PriceIncreaseValidator();

    @Autowired  // in order to use autowired, need to declare the bean in XX-servlet.xml
    private ApplicationContext context;
    private ProductManager manager;

    @RequestMapping(method= RequestMethod.POST)
    public String onSubmit(@ModelAttribute("priceIncrease")PriceIncrease priceIncrease,
                                 BindingResult result) {
        logger.info("POST request in class PriceIncreaseController");

        int percentage = priceIncrease.getPercentage();
        logger.info("get the increased percentage is: " + percentage);

        priceIncreaseValidator.validate(percentage, result);

        if (result.hasErrors()) {
            logger.info("got a error about the percentage");
            return "priceincrease";
        }
        if (manager == null) {
            manager = (ProductManager) context.getBean("productManager");
        }

        logger.info("update the percentage for product manager");
        manager.increasePrice(percentage);

        // Validator has succeeded.
        // Perform necessary actions and return to success page.
        logger.info("go to the /product page after the update");
        return "redirect:product.htm";
    }

    @RequestMapping(method=RequestMethod.GET)
    public Object initializeForm(ModelMap model) {
        // Perform and Model / Form initialization
        logger.info("in the GET request of /priceincrease");
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);

        return priceIncrease;
    }

    public ProductManager getProductManager() {
        return this.manager;
    }

    public void setProductManager(ProductManager manager) {
        this.manager = manager;
    }

    // Other getters and setters an needed.
}



