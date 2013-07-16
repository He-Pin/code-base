package com.pekall.codebase.nio;

import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public interface BufferWriter {

    BufferWriter setBoolean(int index, int value);

    BufferWriter setByte(int index, int value);

    BufferWriter setChar(int index, int value);

    BufferWriter setShort(int index, int value);

    BufferWriter setMedium(int index, int value);

    BufferWriter setInt(int index, int value);

    BufferWriter setLong(int index, long value);

    BufferWriter setFloat(int index, float value);

    BufferWriter setDouble(int index, double value);

    BufferWriter setBytes(int index, byte[] bytes);

    BufferWriter writeBoolean(boolean value);

    BufferWriter writeByte(int value);

    BufferWriter writeChar(int value);

    BufferWriter writeShort(int value);

    BufferWriter writeMedium(int value);

    BufferWriter writeInt(int value);

    BufferWriter writeLong(long value);

    BufferWriter writeFloat(float value);

    BufferWriter writeDouble(float value);

    BufferWriter writeBytes(ByteBuffer src);

    BufferWriter writeBytes(ByteBuffer src, int length);

    BufferWriter writeBytes(ByteBuffer src, int index, int length);

    BufferWriter writeBytes(byte[] src);

    BufferWriter writeBytes(byte[] src, int length);

    BufferWriter writeBytes(byte[] src, int index, int length);

    BufferWriter writeBytes(InputStream src, int length);
}
