package com.pekall.codebase.nio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public interface BufferWriter {

    BufferWriter setBoolean(int index, boolean value);

    BufferWriter setByte(int index, byte value);

    BufferWriter setChar(int index, char value);

    BufferWriter setShort(int index, short value);

    BufferWriter setMedium(int index, int value);

    BufferWriter setInt(int index, int value);

    BufferWriter setLong(int index, long value);

    BufferWriter setFloat(int index, float value);

    BufferWriter setDouble(int index, double value);

    BufferWriter setBytes(int index, byte[] bytes);

    BufferWriter writeBoolean(boolean value);

    BufferWriter writeByte(byte value);

    BufferWriter writeChar(char value);

    BufferWriter writeShort(short value);

    BufferWriter writeMedium(int value);

    BufferWriter writeInt(int value);

    BufferWriter writeLong(long value);

    BufferWriter writeFloat(float value);

    BufferWriter writeDouble(float value);

    BufferWriter writeBytes(ByteBuffer src);

    BufferWriter writeBytes(ByteBuffer src, int length);

    BufferWriter writeBytes(byte[] src);

    BufferWriter writeBytes(byte[] src, int length);

    BufferWriter writeBytes(InputStream src, int length) throws IOException;
}
