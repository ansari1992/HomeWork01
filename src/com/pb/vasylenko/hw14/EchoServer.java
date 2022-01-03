package com.pb.vasylenko.hw14;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class EchoServer {

    private final int portNum;
    public static final int DEFAULT_PORT = 8080;

    public EchoServer(int portNum) {
        this.portNum = portNum;
    }

    public void runServer() {
        System.out.println("Echo Server started...");
        ServerSocket server = null;
        Socket connection = null;
        try {
            server = new ServerSocket(portNum);
            while (true) {
                connection = server.accept();
                new Thread(new ClientHandler(connection)).start();
            }
        } catch (IOException ex) {
            System.err.println("Error encountered! Port is likely already in use! Exiting program...");
            ex.printStackTrace();
        } finally {
            if (Objects.requireNonNull(connection).isClosed()) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            (new EchoServer(Integer.parseInt(args[0]))).runServer();
        } else {
            (new EchoServer(DEFAULT_PORT)).runServer();
        }
    }
}