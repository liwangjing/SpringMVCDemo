package com.jing.aspects;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.PrintStream;

/**
 * Created by jing on 2017/2/24.
 */
@Aspect
public class StorageDummy {

    private PrintStream stream;

    public StorageDummy(PrintStream stream) {
        this.stream = stream;
    }

    protected final Log logger = LogFactory.getLog(getClass());

    @Pointcut("execution(* com.jing.repository.SimpleProductDao.getProducts(..))")
    public void getProducts(){}

    @Before("getProducts()")
    public void openStorage () {
        stream.println("Open Storage, to get Products");
        logger.info("Open Storage, to get Products");
    }

    @AfterReturning("getProducts()")
    public void closeStorage() {
        stream.println("get the Products, close the storage");
        logger.info("get the Products, close the storage");
    }

    // Around is not working right now. it said productManager is not found...
//    @Around("getProducts()")
//    public void greetings(ProceedingJoinPoint joinPoint) {
//        try {
//            stream.println("Hello, welcome to the storage");
//            joinPoint.proceed();
//            stream.println("Thank you for coming, Bye~~ ");
//        } catch (Throwable throwable) {
//            stream.println("??? what's wrong");
//        }
//    }

    @Before("execution(* com.jing.repository.SimpleProductDao.saveProduct(..))")
    public void openStorageDoor() {
        stream.println("open the Storage door to save new product");
        logger.info("open the Storage door to save new product");
    }

    @After("execution(* com.jing.repository.SimpleProductDao.saveProduct(..))")
    public void closeStorageDoor() {
        stream.println("product has been saved, close the storage door");
        logger.info("product has been saved, close the storage door");
    }

}
