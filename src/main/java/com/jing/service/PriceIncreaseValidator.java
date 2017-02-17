package com.jing.service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.io.IOException;

/**
 * Created by jing on 2017/2/16.
 */
public class PriceIncreaseValidator implements Validator {
    private int DEFAULT_MIN_PERCENTAGE = 10;
    private int DEFAULT_MAX_PERCENTAGE = 50;
    private int minPercentage = DEFAULT_MIN_PERCENTAGE;
    private int maxPercentage = DEFAULT_MAX_PERCENTAGE;

    protected final Log logger = LogFactory.getLog(getClass());


    @Override
    public boolean supports(Class<?> aClass) {
        return PriceIncrease.class.equals(aClass);
    }

    //control when user click the "execute"
    @Override
    public void validate(Object o, Errors errors) {
        logger.info("in the validate method of PriceIncreaseValidator");

        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage((Integer) o);
        logger.info("get an object is : " + priceIncrease );

        if (priceIncrease == null) { // if no value has been entered
            logger.info("percentage is null");
            errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
        } else {
            logger.info("Validating with " + priceIncrease + ": " + priceIncrease.getPercentage());
            if (priceIncrease.getPercentage() > maxPercentage) {
                logger.info("percentage is too large");
                errors.rejectValue("percentage", "error.too-high", new Object[] {new Integer(maxPercentage)}, "Value too high.");
            }
            if (priceIncrease.getPercentage() <= minPercentage) {
                logger.info("percentage is too small");
                errors.rejectValue("percentage", "error.too-low", new Object[] {new Integer(minPercentage)}, "Value toot low.");
            }
        }
    }

    public void setMinPercentage(int i) {
        this.minPercentage = i;
    }

    public int getMinPercentage() {
        return minPercentage;
    }

    public void setMaxPercentage(int i) {
        this.maxPercentage = i;
    }

    public int getMaxPercentage() {
        return maxPercentage;
    }
}
