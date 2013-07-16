package com.pekall.codebase.codec.frame;

import com.pekall.codebase.codec.AbstractBytesDecoder;

import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public class FrameDecoder extends AbstractBytesDecoder {
    private final int headerLength;

    public FrameDecoder(int headerLength) {
        this.headerLength = headerLength;
    }

    @Override
    protected ByteBuffer doDecode(ByteBuffer byteBuffer) {
        return null;
    }
}
