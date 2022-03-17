package com.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.Case2")
public class Case2AB {
    static final ReentrantLock lock = new ReentrantLock();
    static boolean t2Runned = false;
    static Condition c = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (!t2Runned) {
                    try {
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            } finally {
                lock.unlock();
            }

        }, "t1");
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("2");
                t2Runned = true;
                c.signal();
            } finally {
                lock.unlock();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
