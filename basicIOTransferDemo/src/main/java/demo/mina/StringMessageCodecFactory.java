package demo.mina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.*;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;


public class StringMessageCodecFactory implements ProtocolCodecFactory {
    public ProtocolEncoder getEncoder(IoSession session) {
        return new ProtocolEncoder() {
            @Override
            public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws CharacterCodingException {
                String msg = (String) message;
                IoBuffer buffer = IoBuffer.allocate(msg.length());
                buffer.putString(msg, Charset.forName("UTF-8").newEncoder());
                buffer.flip();
                out.write(buffer);
            }

            @Override
            public void dispose(IoSession session) {
                // No specific actions needed
            }
        };
    }

    public ProtocolDecoder getDecoder(IoSession session) {
        return new ProtocolDecoder() {
            @Override
            public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws CharacterCodingException {
                String msg = in.getString(Charset.forName("UTF-8").newDecoder());
                out.write(msg);
            }

            @Override
            public void dispose(IoSession session) {
                // No specific actions needed
            }

            @Override
            public void finishDecode(IoSession session, ProtocolDecoderOutput out) {
                // No specific actions needed
            }
        };
    }
}