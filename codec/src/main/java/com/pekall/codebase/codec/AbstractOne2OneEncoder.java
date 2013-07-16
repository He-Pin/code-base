package com.pekall.codebase.codec;

/**
 * author: hepin1989@gmail.com
 */
public abstract class AbstractOne2OneEncoder implements One2OneEncoder{
    @Override
    public Object encode(final Object object) {
        return doEncode(object);
    }

    protected abstract Object doEncode(final Object object);
}
