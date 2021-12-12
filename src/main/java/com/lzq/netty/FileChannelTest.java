package com.lzq.netty;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("nio-data.txt","rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(48);
            int byteRead = fileChannel.read(buf);
            while(byteRead!=-1) {
                System.out.println("Read" + byteRead);
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                byteRead = fileChannel.read(buf);
            }
            randomAccessFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
