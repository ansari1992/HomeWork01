package com.pb.vasylenko.hw14;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class EchoClient implements Serializable {
    private static final long serialVersionUID = 1L;
    private static String serverName;
    public static final String DEFAULT_SERVER_NAME = "localhost";
    private static int portNum;

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    public EchoClient(String serverName, int portNum) {
        EchoClient.serverName = serverName;
        EchoClient.portNum = portNum;
    }


    public synchronized void runClient() {
        try {
            Socket connection = new Socket(InetAddress.getByName(serverName), portNum);
            ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(connection.getInputStream());

            String message;
            do {
                System.out.print("input> ");
                message = keyboard.readLine();

                if (message != null) {
                    output.writeObject(message);
                    output.flush();
                    message = (String) input.readObject();
                    System.out.println(message);
                }
            } while (message != null);
            input.close();
            output.close();
            connection.close();
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }


    public static void main(String[] args) {
        switch (args.length) {
            case 2:
                (new EchoClient(args[0], Integer.parseInt(args[1]))).runClient();
                break;
            case 1:
                (new EchoClient(DEFAULT_SERVER_NAME, Integer.parseInt(args[0]))).runClient();
                break;
            default:
                (new EchoClient(DEFAULT_SERVER_NAME, EchoServer.DEFAULT_PORT)).runClient();
        }
    }
}