package com.pekall.codebase.codec;

import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public interface BytesDecoder extends Decoder {
    ByteBuffer decode(final ByteBuffer byteBuffer);
}
