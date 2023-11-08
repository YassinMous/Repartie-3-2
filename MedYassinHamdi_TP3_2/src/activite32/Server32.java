package activite32;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server32 extends Thread {
    int ord = 0; 
    ServerSocket ss; 
    public static void main(String[] args) throws IOException {
        new Server32().start(); // Start the server thread.
    }

    public void run() {
        try (ServerSocket ss = new ServerSocket(1234);) {
            while (true) {
                Socket s = ss.accept(); // Accepter client.
                new ClientProcess(s, ord++).start(); // Creation un thread pour chaque client 
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}