package com.vegadelalyra.SpringBootMVCDemo;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(public * com.vegadelalyra.SpringBootMVCDemo.AlienController.getAliens())")
    public void logBefore() {
        LOGGER.info("getAliens method called from aspect!");
    }

    @AfterReturning("execution(public * com.vegadelalyra.SpringBootMVCDemo.AlienController.getAliens())")
    public void logAfter() {
        LOGGER.info("getAliens method executed;");
    }

    @AfterThrowing("execution(public * com.vegadelalyra.SpringBootMVCDemo.AlienController.getAliens())")
    public void logException() {
        LOGGER.error("getAliens method FAILED! ALIENS ARE GONE.;");
    }
}
