package com.juc;

import lombok.extern.slf4j.Slf4j;

public class Case3A {

    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(1, 5);
        waitNotify.printSth("a", 1, 2);
        waitNotify.printSth("b", 2, 3);
        waitNotify.printSth("c", 3, 1);
    }
}

class WaitNotify {
    private int flag;
    private int loopNumber;

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void printSth(String sth, int waitFlag, int nextFlag) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < loopNumber; i++) {
                synchronized (this) {
                    while (flag != waitFlag) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(sth);
                    flag = nextFlag;
                    this.notifyAll();
                }
            }
        }, sth);
        t.start();
    }
}
