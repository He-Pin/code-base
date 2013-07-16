package com.pekall.codebase.codec;

import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public abstract class AbstractBytesDecoder implements BytesDecoder {
    @Override
    public ByteBuffer decode(final ByteBuffer byteBuffer) {
        return doDecode(byteBuffer);
    }

    protected abstract ByteBuffer doDecode(final ByteBuffer byteBuffer);
}
