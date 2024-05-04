package demo.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            int serverPort = 12345;
            ServerSocket serverSocket = new ServerSocket(serverPort);

            System.out.println("Server listening on port " + serverPort);

            while (true) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String request = new String(buffer, 0, bytesRead);
                System.out.println("Received request from client: " + request);

                String response = "Hello, client!";
                outputStream.write(response.getBytes());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
