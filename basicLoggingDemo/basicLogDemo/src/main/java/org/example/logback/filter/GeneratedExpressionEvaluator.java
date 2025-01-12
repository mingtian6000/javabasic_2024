package org.example.logback.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.boolex.EventEvaluatorBase;

public class GeneratedExpressionEvaluator extends EventEvaluatorBase {
    @Override
    public boolean evaluate(Object o) throws NullPointerException {
        String message = ((ILoggingEvent)o).getMessage();
        return message.contains("billing");
    }
}
