package com.pekall.codebase.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * User: hepin1989@pekall.com
 * Date: 7/16/13
 * Time: 10:41 AM
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
