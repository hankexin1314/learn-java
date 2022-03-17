package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Case3B {

    public static void main(String[] args) throws InterruptedException {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        new Thread(() -> {
            awaitSignal.printSth("a", a, b);
        }, "t1").start();
        new Thread(() -> {
            awaitSignal.printSth("b", b, c);
        }, "t2").start();
        new Thread(() -> {
            awaitSignal.printSth("c", c, a);
        }, "t3").start();
        Thread.sleep(1000);
        awaitSignal.lock();
        try {
            System.out.println("开始");
            a.signal();
        }
        finally {
            awaitSignal.unlock();
        }
    }


}

class AwaitSignal extends ReentrantLock {
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public void printSth(String sth, Condition cur, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            lock();
            try {
                cur.await();
                System.out.print(sth);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}
