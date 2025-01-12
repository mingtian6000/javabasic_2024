package org.example.logback.layout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
    public static void main(String[] args ) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Everything goes well");
        for (int i = 0; i < 5; i++) {
            logger.debug("logging statement {}", i); //before reset, only print 4 times
        }
        logger.error("maybe not quite...");
    }
}
