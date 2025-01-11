package org.example.logback.myappender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import org.example.logback.kafka.MessageSystem;

import java.beans.Encoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogAppender extends AppenderBase<ILoggingEvent> {
    private Encoder encoder;

    private Layout<ILoggingEvent> layout;

    private MessageSystem messageSystem;

    public Layout<ILoggingEvent> getLayout() {
        return layout;
    }
    public void setLayout(Layout<ILoggingEvent> layout) {
        this.layout = layout;
    }
    public Encoder getEncoder() {
        return encoder;
    }
    public void setEncoder(Encoder encoder) {
        this.encoder = encoder;
    }
    public MessageSystem getMessageSystem() {
        return messageSystem;
    }
    public void setMessageSystem(MessageSystem messageSystem) {
        this.messageSystem = messageSystem;
    }
    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        messageSystem.send(layout.doLayout(iLoggingEvent));
    }
    @Override
    public void start() {
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()) + " LogAppender started");
        messageSystem.initialize(); // initialize message system, here is kafka
        super.start();
    }

}
