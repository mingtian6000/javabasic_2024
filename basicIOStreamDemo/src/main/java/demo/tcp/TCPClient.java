package demo.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            String serverAddress = "127.0.0.1";
            int serverPort = 12345;

            Socket socket = new Socket(serverAddress, serverPort);

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            String message = "Hello, server!";
            outputStream.write(message.getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Server response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
