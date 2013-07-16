package com.pekall.codebase.codec.frame;

import com.pekall.codebase.codec.AbstractBytesEncoder;

import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public class FrameEncoder extends AbstractBytesEncoder {
    private final int headerLength;

    public FrameEncoder(int headerLength) {
        this.headerLength = headerLength;
    }

    @Override
    protected ByteBuffer doEncode(ByteBuffer byteBuffer) {
        return null;
    }
}
