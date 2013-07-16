package com.pekall.codebase.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public class ByteBufferReader implements BufferReader{
    private final ByteBuffer buffer;

    public ByteBufferReader(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    @Override
    public boolean getBoolean() {
        checkAvailable(1);
        buffer.mark();
        boolean result = buffer.get() != 0;
        buffer.reset();
        return result;
    }

    @Override
    public byte getByte() {
        checkAvailable(1);
        buffer.mark();
        byte result = buffer.get();
        buffer.reset();
        return result;
    }

    @Override
    public char getChar() {
        checkAvailable(2);
        buffer.mark();
        char result = buffer.getChar();
        buffer.reset();
        return result;
    }

    @Override
    public short getUnsignedByte() {
        checkAvailable(1);
        buffer.mark();
        short result = (short)(buffer.get()&0xFF);
        buffer.reset();
        return result;
    }

    @Override
    public short getShort() {
        checkAvailable(2);
        buffer.mark();
        short result = buffer.getShort();
        buffer.reset();
        return result;
    }

    @Override
    public int getUnsignedShort() {
        checkAvailable(2);
        buffer.mark();
        int result = buffer.getShort()&0xFFFF;
        buffer.reset();
        return result;
    }

    @Override
    public int getMedium() {
        int value = getUnsignedMedium();
        if ((value & 0x800000) != 0) {
            value |= 0xff000000;
        }
        return value;
    }

    @Override
    public int getUnsignedMedium() {
        checkAvailable(3);
        buffer.mark();
        int result = (buffer.get() & 0xFF) << 16 |
                (buffer.get() & 0xFF) << 8 |
                (buffer.get() & 0xFF);
        buffer.reset();
        return result;
    }

    @Override
    public int getInt() {
        checkAvailable(4);
        buffer.mark();
        int result = buffer.getInt();
        buffer.reset();
        return result;
    }

    @Override
    public long getUnsignedInt() {
        checkAvailable(4);
        buffer.mark();
        long result = buffer.getInt() & 0xFFFFFFFFL;
        buffer.reset();
        return result;
    }

    @Override
    public long getLong() {
        checkAvailable(8);
        buffer.mark();
        long result = buffer.getLong();
        buffer.reset();
        return result;
    }

    @Override
    public float getFloat() {
        checkAvailable(4);
        buffer.mark();
        float result = buffer.getFloat();
        buffer.reset();
        return result;
    }

    @Override
    public double getDouble() {
        checkAvailable(8);
        buffer.mark();
        double result = buffer.getDouble();
        buffer.reset();
        return result;
    }

    @Override
    public BufferReader getBytes(ByteBuffer dst) {
        if (dst == null
                || !dst.hasRemaining()
                || !buffer.hasRemaining()){
            return this;
        }
        buffer.mark();
        dst.put(buffer);
        buffer.reset();
        return this;
    }

    @Override
    public BufferReader getBytes(ByteBuffer dst, int length) {
        if (dst == null
                || !dst.hasRemaining()
                || !buffer.hasRemaining()
                || !(buffer.remaining() < length)){
            return this;
        }
        buffer.mark();
        byte[] tmpBuf = new byte[length];
        buffer.get(tmpBuf);
        dst.put(tmpBuf);
        buffer.reset();
        return this;
    }

    @Override
    public BufferReader getBytes(byte[] dst) {
        if(dst == null
                || !buffer.hasRemaining()
                || dst.length == 0) {
            return this;
        }
        buffer.mark();
        buffer.get(dst);
        buffer.reset();
        return this;
    }

    @Override
    public BufferReader getBytes(byte[] dst, int length) {
        if(dst == null
                || !buffer.hasRemaining()
                || buffer.remaining() < length
                || dst.length < length
                || dst.length == 0) {
            return this;
        }
        buffer.mark();
        buffer.get(dst, 0, length);
        buffer.reset();
        return this;
    }

    @Override
    public BufferReader getBytes(byte[] dst, int dstIndex, int length) {
        if(dst == null
                || !buffer.hasRemaining()
                || buffer.remaining() < length
                || dst.length < length
                || dstIndex <0
                || dstIndex > dst.length
                || dst.length == 0) {
            return this;
        }
        buffer.mark();
        buffer.get(dst,dstIndex,length);
        buffer.reset();
        return this;
    }

    @Override
    public BufferReader getBytes(OutputStream dst) throws IOException {
        if(dst == null
                || !buffer.hasRemaining()){
            return this;
        }
        buffer.mark();
        byte[] tmpBuf = new byte[buffer.remaining()];
        buffer.get(tmpBuf);
        dst.write(tmpBuf);
        buffer.reset();
        return this;
    }

    @Override
    public BufferReader getBytes(OutputStream dst, int length) throws IOException {
        if(dst == null
                || length <= 0
                || !buffer.hasRemaining()
                || buffer.remaining() < length) {
        return this;
        }
        buffer.mark();
        byte[] tmpBuf = new byte[length];
        buffer.get(tmpBuf);
        dst.write(tmpBuf);
        buffer.reset();
        return this;
    }

    @Override
    public boolean readBoolean() {
        checkAvailable(1);
        return buffer.get() != 0;
    }

    @Override
    public byte readByte() {
        checkAvailable(1);
        return buffer.get();
    }

    @Override
    public char readChar() {
        checkAvailable(2);
        return (char)buffer.getShort();
    }

    @Override
    public short readUnsignedByte() {
        checkAvailable(1);
        return (short)(buffer.get()&0xFF);
    }

    @Override
    public short readShort() {
        checkAvailable(2);
        return buffer.getShort();
    }

    @Override
    public int readUnsignedShort() {
        checkAvailable(2);
        return buffer.getShort() & 0xFFFF;
    }

    @Override
    public int readMedium() {
        int value = getUnsignedMedium();
        if ((value & 0x800000) != 0) {
            value |= 0xff000000;
        }
        return value;
    }

    @Override
    public int readUnsignedMedium() {
        return (buffer.get() & 0xFF) << 16 |
                (buffer.get() & 0xFF) << 8 |
                (buffer.get() & 0xFF);
    }

    @Override
    public int readInt() {
        return buffer.getInt();
    }

    @Override
    public long readUnsignedInt() {
        return buffer.getInt() & 0xFFFFFFFFL;
    }

    @Override
    public long readLong() {
        return buffer.getLong();
    }

    @Override
    public float readFloat() {
        return buffer.getFloat();
    }

    @Override
    public double readDouble() {
        return buffer.getDouble();
    }

    @Override
    public ByteBuffer readBytes(int length) {
        if (!buffer.hasRemaining()
                || length <= 0){
            return null;
        }
        ByteBuffer result = ByteBuffer.allocate(length);
        result.put(buffer);
        return result;
    }

    @Override
    public BufferReader readBytes(ByteBuffer dst) {
        if (dst == null
                || !dst.hasRemaining()
                || !buffer.hasRemaining()){
            return this;
        }
        dst.put(buffer);
        return this;
    }

    @Override
    public BufferReader readBytes(ByteBuffer dst, int length) {
        if (dst == null
                || !dst.hasRemaining()
                || !buffer.hasRemaining()
                || !(buffer.remaining() < length)){
            return this;
        }
        byte[] tmpBuf = new byte[length];
        buffer.get(tmpBuf);
        dst.put(tmpBuf);
        return this;
    }

    @Override
    public BufferReader readBytes(byte[] dst) {
        if(dst == null
                || !buffer.hasRemaining()
                || dst.length == 0) {
            return this;
        }
        buffer.get(dst);
        return this;
    }

    @Override
    public BufferReader readBytes(byte[] dst, int length) {
        if(dst == null
                || !buffer.hasRemaining()
                || buffer.remaining() < length
                || dst.length < length
                || dst.length == 0) {
            return this;
        }
        buffer.get(dst, 0, length);
        return this;
    }

    @Override
    public BufferReader readBytes(byte[] dst, int dstIndex, int length) {
        if(dst == null
                || !buffer.hasRemaining()
                || buffer.remaining() < length
                || dst.length < length
                || dstIndex <0
                || dstIndex > dst.length
                || dst.length == 0) {
            return this;
        }
        buffer.get(dst,dstIndex,length);
        return this;
    }

    @Override
    public BufferReader readBytes(OutputStream dst) throws IOException {
        if(dst == null
                || !buffer.hasRemaining()){
            return this;
        }
        byte[] tmpBuf = new byte[buffer.remaining()];
        buffer.get(tmpBuf);
        dst.write(tmpBuf);
        return this;
    }

    @Override
    public BufferReader readBytes(OutputStream dst, int length) throws IOException {
        if(dst == null
                || length <= 0
                || !buffer.hasRemaining()
                || buffer.remaining() < length) {
            return this;
        }
        byte[] tmpBuf = new byte[length];
        buffer.get(tmpBuf);
        dst.write(tmpBuf);
        return this;
    }

    public void checkAvailable(int needed){
        if (buffer.remaining() < needed){
            throw new IndexOutOfBoundsException(String.format(
                    "needed(%d) exceeds remaining(%d): %s", needed,buffer.remaining(),this));
        }
    }
}
