package org.example.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;

public class LimitRaterAppender extends AppenderBase<ILoggingEvent> {
    static int DEFAULT_LIMIT = 5;
    int counter = 0;
    long timestamp = System.currentTimeMillis();
    int limit = DEFAULT_LIMIT;
    Layout<ILoggingEvent> layout;
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getLimit() {
        return limit;
    }
    public Layout<ILoggingEvent> getLayout() {
        return layout;
    }
    public void setLayout(Layout<ILoggingEvent> layout) {
        this.layout = layout;
    }

    @Override
    public void start() {
        if (this.layout == null) {
            addError("No layout set for the appender named [" + name + "].");
            return;
        }
        timestamp = System.currentTimeMillis();
        String header = layout.getFileHeader();
        System.out.print(header);
        super.start();
    }


    @Override
    protected void append(ILoggingEvent event) {

        long timestamp_end = event.getTimeStamp();
        if (timestamp_end - timestamp >= 1000) { //1 second
            counter = 0; // reset counter
            timestamp = timestamp_end;
        } else{
            timestamp = timestamp_end;
            counter++;
        }
        if (counter >= limit) {
            return;
        }
        String eventStr = this.layout.doLayout(event);
        System.out.print(eventStr);
    }
}
