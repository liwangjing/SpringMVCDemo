package com.jing.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by jing on 2017/2/16.
 */
public class PriceIncrease {
    protected final Log logger = LogFactory.getLog(getClass());

    private int percentage;

    public void setPercentage(int i) {
        percentage = i;
        logger.info("percentage set to : " + i);
    }

    public int getPercentage() {
        return percentage;
    }
}
