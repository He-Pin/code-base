package com.pekall.codebase.codec.frame;

import com.pekall.codebase.codec.AbstractBytesDecoder;
import com.pekall.codebase.nio.ByteBufferReader;
import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * author: hepin1989@gmail.com
 */
public class FrameDecoder extends AbstractBytesDecoder {
    private final int headerLength;
    private final ByteOrder byteOrder;
    public FrameDecoder(int headerLength, ByteOrder byteOrder) {
        this.headerLength = headerLength;
        if (byteOrder == null){
            this.byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            this.byteOrder = byteOrder;
        }
    }


    @Override
    protected ByteBuffer doDecode(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("encode frame cannot be null");
        }

        return null;
    }

    private long getFrameLength(final ByteBuffer byteBuffer){
        final long frameLength;
        ByteBufferReader reader = new ByteBufferReader(byteBuffer);
        switch (headerLength) {
            case 1:
                frameLength = reader.readUnsignedByte();
                return frameLength;
            case 2:
                frameLength = reader.readUnsignedShort();
                return frameLength;
            case 3:
                frameLength = reader.getUnsignedMedium();
                return frameLength;
            case 4:
                frameLength = reader.getUnsignedInt();
                return frameLength;
            case 8:
                frameLength = reader.getLong();
                return frameLength;
            default:
                throw new RuntimeException("length must  1 2 3 4 8");
        }
    }
}
