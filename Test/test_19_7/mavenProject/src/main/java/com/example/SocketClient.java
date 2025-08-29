package com.example;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

import Test.test_19_7.mavenProject.src.main.java.com.example.ChatServer;

public class SocketClient {
    ChatServer chatServer;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String clientIp;
    String chatName;
    
    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();
            receive();
        } catch (IOException e) {

        }
    }

    public void receive() {
        chatServer.threadPool.execute(() -> {
            try {
                while(true) {
                    String receiveJSON = dis.readUTF();

                    JSONObject jsonObject = new JSONObject(receiveJSON);
                    String command = jsonObject.getString("command");

                    switch (command) {
                        case "incoming":
                            this.chatName = jsonObject.getString("data");
                            chatServer.sendToAll(this, "들어오셨습니다.");
                            chatServer.addSocketClient(this);
                            break;
                        
                        case: "message":
                            String message = jsonObject.getSting("data");
                            chatServer.sendToAll(this, message);
                            break;
                    }
                }
            } catch (IOException e) {
                chatServer.sendToAll(this, "나가셨습니다");
                chatServer.removeSocket(this);
            } 
        });
    }
}
