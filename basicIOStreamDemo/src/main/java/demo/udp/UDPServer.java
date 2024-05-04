package demo.udp;
import java.io.*;
import java.net.*;
public class UDPServer {
    public static void main(String[] args) {
        try {
            int serverPort = 12345;

            DatagramSocket socket = new DatagramSocket(serverPort);

            System.out.println("Server listening on port " + serverPort);

            while (true) {

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String request = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received request from client: " + request);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String response= "Hello, client!";
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
