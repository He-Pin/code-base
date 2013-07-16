package com.pekall.codebase.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public class ByteBufferReader implements BufferReader{
    private final ByteBuffer byteBuffer;

    public ByteBufferReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public ByteBuffer getByteBuffer() {
        return byteBuffer;
    }

    @Override
    public boolean getBoolean() {
        return false;
    }

    @Override
    public byte getByte() {
        return 0;
    }

    @Override
    public char getChar() {
        return 0;
    }

    @Override
    public short getUnsignedByte() {
        return 0;
    }

    @Override
    public short getShort() {
        return 0;
    }

    @Override
    public int getUnsignedShort() {
        return 0;
    }

    @Override
    public int getMedium() {
        return 0;
    }

    @Override
    public int getUnsignedMedium() {
        return 0;
    }

    @Override
    public int getInt() {
        return 0;
    }

    @Override
    public long getUnsignedInt() {
        return 0;
    }

    @Override
    public long getLong() {
        return 0;
    }

    @Override
    public float getFloat() {
        return 0;
    }

    @Override
    public double getDouble() {
        return 0;
    }

    @Override
    public BufferReader getBytes(int index, ByteBuffer dst) {
        return null;
    }

    @Override
    public BufferReader getBytes(int index, ByteBuffer dst, int length) {
        return null;
    }

    @Override
    public BufferReader getBytes(int index, ByteBuffer dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public BufferReader getBytes(int index, byte[] dst) {
        return null;
    }

    @Override
    public BufferReader getBytes(int index, byte[] dst, int length) {
        return null;
    }

    @Override
    public BufferReader getBytes(int index, byte[] dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public BufferReader getBytes(int index, OutputStream dst) throws IOException {
        return null;
    }

    @Override
    public BufferReader getBytes(int index, OutputStream dst, int length) throws IOException {
        return null;
    }

    @Override
    public boolean readBoolean() {
        return false;
    }

    @Override
    public byte readByte() {
        return 0;
    }

    @Override
    public char readChar() {
        return 0;
    }

    @Override
    public short readUnsignedByte() {
        return 0;
    }

    @Override
    public short readShort() {
        return 0;
    }

    @Override
    public int readUnsignedShort() {
        return 0;
    }

    @Override
    public int readMedium() {
        return 0;
    }

    @Override
    public int readUnsignedMedium() {
        return 0;
    }

    @Override
    public int readInt() {
        return 0;
    }

    @Override
    public long readUnsignedInt() {
        return 0;
    }

    @Override
    public long readLong() {
        return 0;
    }

    @Override
    public float readFloat() {
        return 0;
    }

    @Override
    public double readDouble() {
        return 0;
    }

    @Override
    public ByteBuffer readBytes(int length) {
        return null;
    }

    @Override
    public BufferReader readBytes(ByteBuffer dst) {
        return null;
    }

    @Override
    public BufferReader readBytes(ByteBuffer dst, int length) {
        return null;
    }

    @Override
    public BufferReader readBytes(ByteBuffer dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public BufferReader readBytes(byte[] dst) {
        return null;
    }

    @Override
    public BufferReader readBytes(byte[] dst, int length) {
        return null;
    }

    @Override
    public BufferReader readBytes(byte[] dst, int dstIndex, int length) {
        return null;
    }

    @Override
    public BufferReader readBytes(int index, OutputStream dst) throws IOException {
        return null;
    }

    @Override
    public BufferReader readBytes(int index, OutputStream dst, int length) throws IOException {
        return null;
    }
}
