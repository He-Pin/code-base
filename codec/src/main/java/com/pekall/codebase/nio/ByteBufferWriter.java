package com.pekall.codebase.nio;

import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public class ByteBufferWriter implements BufferWriter {
    private final ByteBuffer buffer;

    public ByteBufferWriter(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    @Override
    public BufferWriter setBoolean(int index, int value) {
        return null;
    }

    @Override
    public BufferWriter setByte(int index, int value) {
        return null;
    }

    @Override
    public BufferWriter setChar(int index, int value) {
        return null;
    }

    @Override
    public BufferWriter setShort(int index, int value) {
        return null;
    }

    @Override
    public BufferWriter setMedium(int index, int value) {
        return null;
    }

    @Override
    public BufferWriter setInt(int index, int value) {
        return null;
    }

    @Override
    public BufferWriter setLong(int index, long value) {
        return null;
    }

    @Override
    public BufferWriter setFloat(int index, float value) {
        return null;
    }

    @Override
    public BufferWriter setDouble(int index, double value) {
        return null;
    }

    @Override
    public BufferWriter setBytes(int index, byte[] bytes) {
        return null;
    }

    @Override
    public BufferWriter writeBoolean(boolean value) {
        return null;
    }

    @Override
    public BufferWriter writeByte(int value) {
        return null;
    }

    @Override
    public BufferWriter writeChar(int value) {
        return null;
    }

    @Override
    public BufferWriter writeShort(int value) {
        return null;
    }

    @Override
    public BufferWriter writeMedium(int value) {
        return null;
    }

    @Override
    public BufferWriter writeInt(int value) {
        return null;
    }

    @Override
    public BufferWriter writeLong(long value) {
        return null;
    }

    @Override
    public BufferWriter writeFloat(float value) {
        return null;
    }

    @Override
    public BufferWriter writeDouble(float value) {
        return null;
    }

    @Override
    public BufferWriter writeBytes(ByteBuffer src) {
        return null;
    }

    @Override
    public BufferWriter writeBytes(ByteBuffer src, int length) {
        return null;
    }

    @Override
    public BufferWriter writeBytes(ByteBuffer src, int index, int length) {
        return null;
    }

    @Override
    public BufferWriter writeBytes(byte[] src) {
        return null;
    }

    @Override
    public BufferWriter writeBytes(byte[] src, int length) {
        return null;
    }

    @Override
    public BufferWriter writeBytes(byte[] src, int index, int length) {
        return null;
    }

    @Override
    public BufferWriter writeBytes(InputStream src, int length) {
        return null;
    }
}
