package demo.mina;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.net.InetSocketAddress;

public class CustomProtocolServer {
    public static void main(String[] args) throws Exception {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new CustomProtocolCodecFactory()));
        acceptor.setHandler(new CustomProtocolHandler());
        acceptor.bind(new InetSocketAddress(9123));
        System.out.println("Custom Protocol Server started on port 9123");
    }
}
