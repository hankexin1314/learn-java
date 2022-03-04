package com.juc;

/**
 * @author kexinhan
 * @date 2022/3/4 17:57
 */
public class Main {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        aa.setDaemon(true);
        aa.start();
        System.out.println(Thread.currentThread().getName() + " over");
    }
}
