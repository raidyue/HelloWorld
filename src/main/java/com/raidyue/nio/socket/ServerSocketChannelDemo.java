package com.raidyue.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by yuexiaodong on 16/8/21.
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) {
        startBlockServer();

    }

    private static void startBlockServer() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(9000));
            System.out.println("server is listening...");
            while (true) {
                SocketChannel channel = serverSocketChannel.accept();
                ByteBuffer buf = ByteBuffer.allocate(64);
                int readRelt = channel.read(buf);
                StringBuilder str = new StringBuilder();
                while (readRelt != -1) {
                    buf.flip();
                    while (buf.hasRemaining()) {
                        str.append((char) buf.get());
                    }
                    buf.clear();
                    readRelt = channel.read(buf);
                }
                System.out.println(str.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
