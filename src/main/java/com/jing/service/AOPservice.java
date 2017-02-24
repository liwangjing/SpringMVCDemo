package com.jing.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.PrintStream;

/**
 * Created by jing on 2017/2/23.
 */
public class AOPservice {

    private PrintStream stream;

    public AOPservice(PrintStream stream) {
        this.stream = stream;
    }

    protected final Log logger = LogFactory.getLog(getClass());

    public void before () {
        stream.println("!!!!! Before");
        logger.info("in AOP before method");
    }

    public void after () {
        stream.println("!!!!! After");
        logger.info("in AOP after method");
    }

    public void finish () {
        stream.println("!!!!! Finish");
        logger.info("in AOP finish method");
    }
}
