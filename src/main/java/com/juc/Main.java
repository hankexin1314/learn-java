package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author kexinhan
 * @date 2022/3/4 17:57
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
        System.out.println("############################");
        FutureTask<Integer> task3 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName());
            return 100;
        });
        new Thread(task3, "t3").start();
        Integer res = task3.get();
        System.out.println(res);

        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                TimeUnit.SECONDS.sleep(1);
                return 100;
            }
        });
        new Thread(futureTask, "futureTask").start();
        System.out.println(futureTask.get());
    }
}
