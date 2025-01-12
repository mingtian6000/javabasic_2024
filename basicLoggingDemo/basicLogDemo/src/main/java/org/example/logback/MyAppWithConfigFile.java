package org.example.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAppWithConfigFile {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MyAppWithConfigFile.class);
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();

        try {
            JoranConfigurator configurator = new JoranConfigurator();
            lc.reset();
            configurator.setContext(lc);
            configurator.doConfigure(args[0]);
        } catch (JoranException je) {
            StatusPrinter.print(lc.getStatusManager());
        }
        logger.info("Entering application.");
        Bar bar = new Bar();
        bar.doIt();
        logger.debug("produce more logs.");
        logger.info("produce one log entry with billing.");
        logger.info("Exiting application.");

    }

}
class Bar {
    Logger logger = LoggerFactory.getLogger(Bar.class);

    public void doIt() {
        logger.debug("doing my job");
    }
}