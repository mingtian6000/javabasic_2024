package demo.queue;

import lombok.*;

@Getter
@Setter
public class Message implements Comparable<Message> {
     Long timestamp;
     String payload;
     String key;
     int level;
     String appName;

    public Message(Long timestamp, String payload, String key, int level, String appName) {
        this.timestamp = timestamp;
        this.payload = payload;
        this.key = key;
        this.level = level;
        this.appName = appName;
    }

    @Override
    public int compareTo(Message o) {
        // here use timestamp to sort, in realworld, you can define multiple business logic
        return this.timestamp.compareTo(o.timestamp);
    }

    @Override
    public String toString() {
        return "Message{" +
                "timestamp=" + timestamp +
                ", payload='" + payload + '\'' +
                ", key='" + key + '\'' +
                ", level=" + level +
                ", appName='" + appName + '\'' +
                '}';
    }
}

