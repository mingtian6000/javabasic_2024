package demo.udp;
import java.io.*;
import java.net.*;
public class UDPClient {
    public static void main(String[] args) {
        try {
            String serverAddress = "127.0.0.1";
            int serverPort = 12345;

            DatagramSocket socket = new DatagramSocket();

            String message = "Hello, server!";
            byte[] sendData = message.getBytes();
            InetAddress serverInetAddress = InetAddress.getByName(serverAddress);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverInetAddress, serverPort);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
