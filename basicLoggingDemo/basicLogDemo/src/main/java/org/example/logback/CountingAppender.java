package org.example.logback;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
public class CountingAppender extends AppenderBase<ILoggingEvent> {
    static int DEFAULT_LIMIT = 10;
    int counter = 0;
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

        String header = layout.getFileHeader();
        System.out.print(header);
        super.start();
    }
    @Override
    protected void append(ILoggingEvent event) {
        if (counter >= limit) {
            return;
        }
        String eventStr = this.layout.doLayout(event);
        System.out.print(eventStr);
        counter++;
    }
}
