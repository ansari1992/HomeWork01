package com.pb.vasylenko.hw14;


import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable {

    private int message;
    private final Socket connection;

    public ClientHandler(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        do {
            if (!this.connection.isClosed())
                handleRequest();
        } while (true);
    }

    public void handleRequest() {
        ObjectOutputStream output;
        ObjectInputStream input;
        try {
            output = new ObjectOutputStream(this.connection.getOutputStream());
            input = new ObjectInputStream(this.connection.getInputStream());
            String message;
            while (!this.connection.isClosed()) {
                do {
                    try {
                        message = (String) input.readObject();
                        System.out.println(this.message + " output> " + message);
                    } catch (EOFException | SocketException e) {
                        message = null;
                    }
                    if (message != null) {
                        output.writeObject(this.message + " fromServer> " + message);
                        output.flush();
                        ++this.message;
                    }
                } while (message != null);
                input.close();
                output.close();
            }
            this.connection.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error encountered! Exiting program...");
            ex.printStackTrace();
        }
    }
}