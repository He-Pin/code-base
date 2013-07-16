package com.pekall.codebase.codec;

/**
 * author: hepin1989@gmail.com
 */
public abstract class AbstractOne2OneDecoder implements One2OneDecoder{
    @Override
    public Object decode(final Object object) {
        return doDecode(object);
    }

    protected abstract Object doDecode(final Object object);
}
