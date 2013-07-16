package com.pekall.codebase.codec;

import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public abstract class AbstractBytesEncoder implements BytesEncoder {
    @Override
    public ByteBuffer encode(final ByteBuffer byteBuffer) {
        return doEncode(byteBuffer);
    }

    protected abstract ByteBuffer doEncode(final ByteBuffer byteBuffer);
}
