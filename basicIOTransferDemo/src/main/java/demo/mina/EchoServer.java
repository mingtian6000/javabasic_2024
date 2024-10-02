package demo.mina;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
public class EchoServer {
    public static void main(String[] args) throws IOException {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new StringMessageCodecFactory()));
        acceptor.setHandler(new EchoHandler());
        acceptor.bind(new InetSocketAddress(9123));
        System.out.println("Server started on port 9123");
    }

    static class EchoHandler extends IoHandlerAdapter {
        @Override
        public void messageReceived(IoSession session, Object message) {
            String msg = message.toString();
            System.out.println("Received: " + msg);
            session.write("Echo: " + msg); // Echo back to the client
        }

        @Override
        public void exceptionCaught(IoSession session, Throwable cause) {
            cause.printStackTrace();
            session.closeNow(); // Close the session on exception
        }
    }
}
