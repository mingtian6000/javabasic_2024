package demo.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.*;

import java.nio.charset.StandardCharsets;


public class CustomProtocolCodecFactory implements ProtocolCodecFactory {
    public ProtocolEncoder getEncoder(IoSession session) {
        return new ProtocolEncoder() {
            @Override
            public void encode(IoSession session, Object message, ProtocolEncoderOutput out) {
                CustomMessage customMessage = (CustomMessage) message;
                byte[] bodyBytes = customMessage.getBytes();
                IoBuffer buffer = IoBuffer.allocate(4 + bodyBytes.length);
                buffer.putInt(bodyBytes.length); // Header: length of the body
                buffer.put(bodyBytes);           // Body
                buffer.flip();
                out.write(buffer);
            }

            @Override
            public void dispose(IoSession session) {
                // Clean up resources if needed
            }
        };
    }

    public ProtocolDecoder getDecoder(IoSession session) {
        return new ProtocolDecoder() {
            @Override
            public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) {
                while (in.remaining() >= 4) {
                    in.mark(); // Mark the current position
                    int length = in.getInt(); // Read the length
                    if (in.remaining() < length) {
                        in.reset(); // Reset to the marked position
                        return; // Wait for more data
                    }
                    byte[] bodyBytes = new byte[length];
                    in.get(bodyBytes); // Read the body
                    String body = new String(bodyBytes, StandardCharsets.UTF_8);
                    out.write(new CustomMessage(body)); // Output the message
                }
            }

            @Override
            public void dispose(IoSession session) {
                // Clean up resources if needed
            }

            @Override
            public void finishDecode(IoSession session, ProtocolDecoderOutput out) {
                // No action required
            }
        };
    }
}
