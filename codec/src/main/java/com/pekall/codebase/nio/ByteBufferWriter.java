package com.pekall.codebase.nio;

import java.io.IOException;
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
    public BufferWriter setBoolean(int index, boolean value) {
        buffer.mark();
        buffer.put(index, (byte) (value?1:0));
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setByte(int index, byte value) {
        buffer.mark();
        buffer.put(index, value);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setChar(int index, char value) {
        buffer.mark();
        buffer.putChar(index, value);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setShort(int index, short value) {
        buffer.mark();
        buffer.putShort(index, value);
        buffer.reset();
        return null;
    }

    @Override
    public BufferWriter setMedium(int index, int value) {
        buffer.mark();
        buffer.put(index, (byte) (value >>> 16));
        buffer.put(index, (byte) (value>>>8));
        buffer.put(index, (byte) value);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setInt(int index, int value) {
        buffer.mark();
        buffer.putInt(index, value);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setLong(int index, long value) {
        buffer.mark();
        buffer.putLong(index,value);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setFloat(int index, float value) {
        buffer.mark();
        buffer.putFloat(index,value);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setDouble(int index, double value) {
        buffer.mark();
        buffer.putDouble(index, value);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter setBytes(int index, byte[] bytes) {
        buffer.mark();
        buffer.position(index);
        buffer.put(bytes);
        buffer.reset();
        return this;
    }

    @Override
    public BufferWriter writeBoolean(boolean value) {
        buffer.put((byte) (value ? 1 : 0));
        return this;
    }

    @Override
    public BufferWriter writeByte(byte value) {
        buffer.put(value);
        return this;
    }

    @Override
    public BufferWriter writeChar(char value) {
        buffer.putChar(value);
        return this;
    }

    @Override
    public BufferWriter writeShort(short value) {
        buffer.putShort(value);
        return this;
    }

    @Override
    public BufferWriter writeMedium(int value) {
        buffer.put((byte) (value>>>16));
        buffer.put((byte) (value>>>8));
        buffer.put((byte) value);
        return this;
    }

    @Override
    public BufferWriter writeInt(int value) {
        buffer.putInt(value);
        return this;
    }

    @Override
    public BufferWriter writeLong(long value) {
        buffer.putLong(value);
        return this;
    }

    @Override
    public BufferWriter writeFloat(float value) {
        buffer.putFloat(value);
        return this;
    }

    @Override
    public BufferWriter writeDouble(float value) {
        buffer.putDouble(value);
        return this;
    }

    @Override
    public BufferWriter writeBytes(ByteBuffer src) {
        buffer.put(src);
        return this;
    }

    @Override
    public BufferWriter writeBytes(ByteBuffer src, int length) {
        if (length < 0 || src == null){
            return this;
        }
        byte[] tmp = new byte[length];
        src.get(tmp);
        buffer.put(tmp);
        return this;
    }

    @Override
    public BufferWriter writeBytes(byte[] src) {
        if (src == null) {
            return this;
        }
        buffer.put(src);
        return this;
    }

    @Override
    public BufferWriter writeBytes(byte[] src, int length) {
        if (src == null || length < 0) {
            return this;
        }
        buffer.put(src, 0, src.length);
        return this;
    }

    @Override
    public BufferWriter writeBytes(InputStream src, int length) throws IOException {
        if (src == null || length < 0){
            return this;
        }
        for (int i = 0; i < length && buffer.hasRemaining(); i++) {
            int value = src.read();
            if (value == -1 ){
                return this;
            }
            buffer.put((byte) value);
        }
        return this;
    }

    private void checkIndex(int index){
        if (buffer.capacity() < index){
            throw new IndexOutOfBoundsException(String.format(
                    "index(%d) exceeds capacity(%d): %s", index,buffer.capacity(),this));
        }
    }
}
