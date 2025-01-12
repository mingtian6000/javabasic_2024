package org.example.logback.filter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
public class SimpleFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        if (event.getMessage().contains("simple")) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.NEUTRAL; // netrual
        }
    }
}
