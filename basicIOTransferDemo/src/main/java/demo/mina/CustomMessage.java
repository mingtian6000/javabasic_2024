package demo.mina;

import java.nio.charset.StandardCharsets;

public class CustomMessage {
    private final String body;

    public CustomMessage(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public byte[] getBytes() {
        return body.getBytes(StandardCharsets.UTF_8);
    }

    public int getLength() {
        return getBytes().length;
    }
}
