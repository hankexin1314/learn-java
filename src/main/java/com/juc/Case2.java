package com.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Case2")
public class Case2 {
    static final Object lock = new Object();
    // 表示t2是否运行过
    static boolean t2Runned = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!t2Runned) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2Runned = true;
                lock.notify();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
