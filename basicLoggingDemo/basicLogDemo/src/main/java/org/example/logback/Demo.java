package org.example.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Demo.class);

        logger.debug("Hello world");
        logger.info("this is the message produced to kafka log topic");
        logger.info("more test...");
        logger.debug("Hello world simple");
    }

}
