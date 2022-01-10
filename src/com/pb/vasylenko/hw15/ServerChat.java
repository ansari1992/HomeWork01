package com.pb.vasylenko.hw15;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class ServerChat extends JFrame implements ActionListener {
    static ServerSocket server;
    static Socket socket;
    JPanel panel;
    JTextField textField;
    JTextArea textArea;
    JButton button;

    public ServerChat() throws IOException {

        panel = new JPanel();
        textField = new JTextField();
        textArea = new JTextArea();
        button = new JButton("Send");
        this.setSize(500, 500);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        this.add(panel);
        textArea.setBounds(20, 20, 450, 360);
        panel.add(textArea);
        textField.setBounds(20, 400, 340, 30);
        panel.add(textField);
        button.setBounds(375, 400, 95, 30);
        panel.add(button);
        this.setTitle("Server");
        button.addActionListener(this);
        server = new ServerSocket(8080, 1, InetAddress.getLocalHost());
        textArea.setText("Waiting for Client");
        textArea.setText(textArea.getText() + '\n' + " Found");
        while (true) {
            try {
                socket = server.accept();
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String string = dis.readUTF();
                textArea.setText(textArea.getText() + '\n' + "Client:" + string);
            } catch (Exception e1) {
                textArea.setText(textArea.getText() + '\n' + e1.getLocalizedMessage());
                try {
                    Thread.sleep(3000);
                    System.exit(0);
                } catch (InterruptedException e) {
                    textArea.setText(textArea.getText() + '\n' + e.getLocalizedMessage());
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == button) && (!Objects.equals(textField.getText(), ""))) {
            textArea.setText(textArea.getText() + '\n' + "Server:" + textField.getText());
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(textField.getText());
            } catch (Exception e1) {
                try {
                    Thread.sleep(3000);
                    System.exit(0);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            textField.setText("");
        }
    }

    public static void main(String[] args) throws IOException {
        new ServerChat();
    }
}