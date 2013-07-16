package com.pekall.codebase.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * author: hepin1989@gmail.com
 */
public class NamedThreadFactory implements ThreadFactory{
    private String name = "Default Thread";

    public NamedThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(name);
        return thread;
    }
}
