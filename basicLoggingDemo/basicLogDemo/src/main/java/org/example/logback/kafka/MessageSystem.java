package org.example.logback.kafka;

import ch.qos.logback.core.spi.ContextAware;

public interface MessageSystem extends ContextAware {

    public<T> void send(T log);
    public void initialize();
}
