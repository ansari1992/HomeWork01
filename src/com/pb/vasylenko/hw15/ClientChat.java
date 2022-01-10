package com.pb.vasylenko.hw15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Objects;

public class ClientChat extends JFrame implements ActionListener {
    static Socket socket;
    JPanel panel;
    JTextField textField;
    JTextArea textArea;
    JButton button;

    public ClientChat() throws IOException {
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
        button.addActionListener(this);
        socket = new Socket(InetAddress.getLocalHost(), 8080);
        textArea.setText("Connected to Server");
        this.setTitle("Client");
        while (true) {
            try {
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                String string = dis.readUTF();
                textArea.setText(textArea.getText() + '\n' + "Server:" + string);
            } catch (Exception e1) {
                textArea.setText(textArea.getText() + '\n' + "Message sending fail:Network Error");
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
            textArea.setText(textArea.getText() + '\n' + "User:" + textField.getText());
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(textField.getText());
            } catch (Exception exception) {
                textArea.setText(textArea.getText() + '\n' + "Message sending fail:Network Error");
                try {
                    Thread.sleep(3000);
                    System.exit(0);
                } catch (InterruptedException exception1) {
                    textArea.setText(textArea.getText() + '\n' + exception1.getLocalizedMessage());
                }
            }
            textField.setText("");
        }
    }

    public static void main(String[] args) throws IOException {
        new ClientChat();
    }
}
