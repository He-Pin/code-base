package com.pekall.codebase.nio;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public class ByteBufReader implements BufferReader{
    private final ByteBuf byteBuf;

    public ByteBufReader(ByteBuf byteBuf) {
        this.byteBuf = byteBuf;
    }

    @Override
    public boolean getBoolean() {
        return byteBuf.getBoolean(byteBuf.readerIndex());
    }

    @Override
    public byte getByte() {
        return byteBuf.getByte(byteBuf.readerIndex());
    }

    @Override
    public char getChar() {
        return byteBuf.getChar(byteBuf.readerIndex());
    }

    @Override
    public short getUnsignedByte() {
        return byteBuf.getUnsignedByte(byteBuf.readerIndex());
    }

    @Override
    public short getShort() {
        return byteBuf.getShort(byteBuf.readerIndex());
    }

    @Override
    public int getUnsignedShort() {
        return byteBuf.getUnsignedShort(byteBuf.readerIndex());
    }

    @Override
    public int getMedium() {
        return byteBuf.getMedium(byteBuf.readerIndex());
    }

    @Override
    public int getUnsignedMedium() {
        return byteBuf.getUnsignedMedium(byteBuf.readerIndex());
    }

    @Override
    public int getInt() {
        return byteBuf.getInt(byteBuf.readerIndex());
    }

    @Override
    public long getUnsignedInt() {
        return byteBuf.getUnsignedInt(byteBuf.readerIndex());
    }

    @Override
    public long getLong() {
        return byteBuf.getLong(byteBuf.readerIndex());
    }

    @Override
    public float getFloat() {
        return byteBuf.getFloat(byteBuf.readerIndex());
    }

    @Override
    public double getDouble() {
        return byteBuf.getDouble(byteBuf.readerIndex());
    }

    @Override
    public BufferReader getBytes(ByteBuffer dst) {
        byteBuf.getBytes(byteBuf.readerIndex(),dst);
        return this;
    }

    @Override
    public BufferReader getBytes(ByteBuffer dst, int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        if (dst.remaining() > length) {
            byte[] tmpBuf = new byte[length];
            byteBuf.getBytes(byteBuf.readerIndex(), tmpBuf);
            dst.put(tmpBuf);
        } else {
            byteBuf.getBytes(byteBuf.readerIndex(),dst);
        }
        return this;
    }

    @Override
    public BufferReader getBytes(byte[] dst) {
        byteBuf.getBytes(byteBuf.readerIndex(),dst);
        return this;
    }

    @Override
    public BufferReader getBytes(byte[] dst, int length) {
        byteBuf.getBytes(byteBuf.readerIndex(),dst,0,length);
        return this;
    }

    @Override
    public BufferReader getBytes(byte[] dst, int dstIndex, int length) {
        byteBuf.getBytes(byteBuf.readerIndex(),dst,dstIndex,length);
        return this;
    }

    @Override
    public BufferReader getBytes(OutputStream dst) throws IOException {
        byteBuf.getBytes(byteBuf.readerIndex(),dst,byteBuf.readableBytes());
        return this;
    }

    @Override
    public BufferReader getBytes(OutputStream dst, int length) throws IOException {
        byteBuf.getBytes(byteBuf.readerIndex(),dst,length);
        return this;
    }

    @Override
    public boolean readBoolean() {
        return byteBuf.readBoolean();
    }

    @Override
    public byte readByte() {
        return byteBuf.readByte();
    }

    @Override
    public char readChar() {
        return byteBuf.readChar();
    }

    @Override
    public short readUnsignedByte() {
        return byteBuf.readUnsignedByte();
    }

    @Override
    public short readShort() {
        return byteBuf.readShort();
    }

    @Override
    public int readUnsignedShort() {
        return byteBuf.readUnsignedShort();
    }

    @Override
    public int readMedium() {
        return byteBuf.readMedium();
    }

    @Override
    public int readUnsignedMedium() {
        return byteBuf.readUnsignedMedium();
    }

    @Override
    public int readInt() {
        return byteBuf.readInt();
    }

    @Override
    public long readUnsignedInt() {
        return byteBuf.readUnsignedInt();
    }

    @Override
    public long readLong() {
        return byteBuf.readLong();
    }

    @Override
    public float readFloat() {
        return byteBuf.readFloat();
    }

    @Override
    public double readDouble() {
        return byteBuf.readDouble();
    }

    @Override
    public ByteBuffer readBytes(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        ByteBuffer buffer = ByteBuffer.allocate(length);
        byteBuf.readBytes(buffer);
        return buffer;
    }

    @Override
    public BufferReader readBytes(ByteBuffer dst) {
        byteBuf.readBytes(dst);
        return this;
    }

    @Override
    public BufferReader readBytes(ByteBuffer dst, int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        if (dst.remaining() > length) {
            byte[] tmpBuf = new byte[length];
            byteBuf.readBytes(tmpBuf);
            dst.put(tmpBuf);
        } else {
            byteBuf.readBytes(dst);
        }
        byteBuf.readBytes(dst);
        return this;
    }

    @Override
    public BufferReader readBytes(byte[] dst) {
        byteBuf.readBytes(dst);
        return this;
    }

    @Override
    public BufferReader readBytes(byte[] dst, int length) {
        byteBuf.readBytes(dst,0,length);
        return this;
    }

    @Override
    public BufferReader readBytes(byte[] dst, int dstIndex, int length) {
        byteBuf.readBytes(dst,dstIndex,length);
        return this;
    }

    @Override
    public BufferReader readBytes(OutputStream dst) throws IOException {
        byteBuf.readBytes(dst,byteBuf.readableBytes());
        return this;
    }

    @Override
    public BufferReader readBytes(OutputStream dst, int length) throws IOException {
        byteBuf.readBytes(dst,length);
        return this;
    }
}
