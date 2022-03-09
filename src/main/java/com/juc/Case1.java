package com.juc;

/**
 * @author kexinhan
 * @date 2022/3/9 18:03
 */
public class Case1 {
    static int counter = 0;
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 5000; i ++) {
                synchronized (lock) {
                    counter++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 5000; i ++) {
                synchronized (lock) {
                    counter--;
                }
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter);
    }
}
