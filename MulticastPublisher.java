package com.distributed.common;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastPublisher {
    private DatagramSocket socket;
    private InetAddress group;
    private byte[] buf;
    int port;
    String ip;

    public MulticastPublisher(String ip, int port){
        this.port = port;
        this.ip = ip;

    }

    public void multicast(String multicastMessage) throws IOException {
        socket = new DatagramSocket();
        group = InetAddress.getByName(ip);
        buf = multicastMessage.getBytes();

        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, group, port);
        socket.send(packet);
        socket.close();
    }
}
