package com.pekall.codebase.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public interface BufferReader {

    boolean getBoolean();

    byte getByte();

    char getChar();

    short getUnsignedByte();

    short getShort();

    int getUnsignedShort();

    int getMedium();

    int getUnsignedMedium();

    int getInt();

    long getUnsignedInt();

    long getLong();

    float getFloat();

    double getDouble();

    BufferReader getBytes(ByteBuffer dst);

    BufferReader getBytes(ByteBuffer dst, int length);

    BufferReader getBytes(byte[] dst);

    BufferReader getBytes(byte[] dst, int length);

    BufferReader getBytes(byte[] dst, int dstIndex, int length);

    BufferReader getBytes(OutputStream dst) throws IOException;

    BufferReader getBytes(OutputStream dst, int length) throws IOException;

    boolean readBoolean();

    byte readByte();

    char readChar();

    short readUnsignedByte();

    short readShort();

    int readUnsignedShort();

    int readMedium();

    int readUnsignedMedium();

    int readInt();

    long readUnsignedInt();

    long readLong();

    float readFloat();

    double readDouble();

    ByteBuffer readBytes(int length);

    BufferReader readBytes(ByteBuffer dst);

    BufferReader readBytes(ByteBuffer dst, int length);

    BufferReader readBytes(byte[] dst);

    BufferReader readBytes(byte[] dst,int length);

    BufferReader readBytes(byte[] dst, int dstIndex, int length);

    BufferReader readBytes(OutputStream dst) throws IOException;

    BufferReader readBytes(OutputStream dst, int length) throws IOException;

}
