package com.pekall.codebase.codec;

import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public interface BytesEncoder extends Encoder {
    ByteBuffer encode(final ByteBuffer byteBuffer);
}
