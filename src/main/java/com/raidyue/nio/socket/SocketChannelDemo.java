package com.raidyue.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by yuexiaodong on 16/8/21.
 */
public class SocketChannelDemo {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9000));
            String newData = "New String to write to sever...";
            ByteBuffer buf = ByteBuffer.allocate(64);
            buf.clear();
            buf.put(newData.getBytes());
            buf.flip();
            while (buf.hasRemaining()) {
                socketChannel.write(buf);
            }
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
