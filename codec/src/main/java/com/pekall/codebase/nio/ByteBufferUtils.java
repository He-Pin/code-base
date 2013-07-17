package com.pekall.codebase.nio;

import java.nio.ByteBuffer;

/**
 * author: hepin1989@gmail.com
 */
public class ByteBufferUtils {
    public static ByteBuffer copy(ByteBuffer source){
        if (source == null) {
            return null;
        }
        source.mark();
        ByteBuffer copy = ByteBuffer.allocate(source.remaining());
        copy.put(source);
        source.reset();
        copy.flip();
        return copy;
    }
    public static ByteBuffer scaleTo(ByteBuffer source,long length){

        return null;
    }
}
