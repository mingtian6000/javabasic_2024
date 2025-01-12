package org.example.logback.appender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args ) {
        Logger logger = LoggerFactory.getLogger(App.class);
        System.out.println( logger.getClass().getName() ); //ch.qos.logback.classic.Logger
        // we need to config logback is using customized appender, so config in default logback-app.xml
        logger.debug("Hello world");
        for (int i = 0; i < 10; i++) {
            logger.debug("logging statement {}", i); //before reset, only print 4 times
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            logger.debug("2nd logging statement {}", i); // after reset,  print 5
        }
        for (int i = 0; i < 12; i++) {
            logger.info(" 3rd logging statement {}", i); // no reset. no print
        }
    }
}
