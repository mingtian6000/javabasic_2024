package org.example.logback.filter;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.filter.EvaluatorFilter;
import ch.qos.logback.classic.boolex.OnMarkerEvaluator;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class BasicFilter {

    public static void main(String[] args) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setContext(loggerContext);
        consoleAppender.setName("CONSOLE");

        OnMarkerEvaluator evaluator = new OnMarkerEvaluator();
        evaluator.setContext(loggerContext);
        evaluator.addMarker("IMPORTANT");
        evaluator.start();

        EvaluatorFilter evaluatorFilter = new EvaluatorFilter();
        evaluatorFilter.setContext(loggerContext);
        evaluatorFilter.setEvaluator(evaluator);
        evaluatorFilter.setOnMatch(FilterReply.ACCEPT);
        evaluatorFilter.setOnMismatch(FilterReply.DENY);
        evaluatorFilter.start();

        consoleAppender.addFilter(evaluatorFilter);
        consoleAppender.start();

        Logger logger = (Logger) LoggerFactory.getLogger(BasicFilter.class);
        logger.addAppender(consoleAppender);
        logger.setLevel(Level.INFO);
        logger.info("This is a normal log message"); // why it is printed?
        logger.info(MarkerFactory.getMarker("IMPORTANT"), "This is an important log message");
    }
}
