package com.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.Case2")
public class Case2A {
    static final ReentrantLock lock = new ReentrantLock();
    // 表示t2是否运行过
    static boolean t2Runned = false;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if(t2Runned) {
                        log.debug("1");
                        break;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("2");
                t2Runned = true;
            } finally {
                lock.unlock();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
