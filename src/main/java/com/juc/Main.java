package com.juc;

/**
 * @author kexinhan
 * @date 2022/3/4 17:57
 */
public class Main {
    public static void main(String[] args) {
        Thread tt = new Thread("tt") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        tt.start();
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "aa");
        t.start();
        System.out.println(Thread.currentThread().getName() + " over");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread t3 = new Thread(runnable, "t3");
        t3.start();

        Runnable runnable2 = () -> System.out.println(Thread.currentThread().getName());
        Thread t4 = new Thread(runnable2, "t4");
        t4.start();
    }
}
