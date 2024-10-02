package demo.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

public class CustomProtocolHandler extends IoHandlerAdapter {
    @Override
    public void messageReceived(IoSession session, Object message) {
        CustomMessage customMessage = (CustomMessage) message;
        System.out.println("Received message: " + customMessage.getBody());

        // Echo the message back
        session.write(new CustomMessage("Echo: " + customMessage.getBody()));
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        cause.printStackTrace();
        session.closeNow(); // Close the session on exception
    }
}
