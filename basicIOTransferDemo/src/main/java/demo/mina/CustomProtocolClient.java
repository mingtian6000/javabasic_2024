package demo.mina;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

public class CustomProtocolClient {
    public static void main(String[] args) {
        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CustomProtocolCodecFactory()));
        connector.setHandler(new ClientHandler());

        ConnectFuture future = connector.connect(new InetSocketAddress("localhost", 9123));
        future.awaitUninterruptibly(); // Wait for the connection to be established
        IoSession session = future.getSession();

        session.write(new CustomMessage("Hello, Server!"));
        session.getCloseFuture().awaitUninterruptibly(); // Wait for the session to close
        connector.dispose(); // Clean up resources
    }

    static class ClientHandler extends IoHandlerAdapter {
        @Override
        public void messageReceived(IoSession session, Object message) {
            CustomMessage customMessage = (CustomMessage) message;
            System.out.println("Received from server: " + customMessage.getBody());
        }

        @Override
        public void exceptionCaught(IoSession session, Throwable cause) {
            cause.printStackTrace();
            session.closeNow(); // Close the session on exception
        }
    }
}