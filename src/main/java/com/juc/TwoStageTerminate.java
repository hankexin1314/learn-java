package com.juc;

/**
 * @author kexinhan
 * @date 2022/3/8 18:31
 */
public class TwoStageTerminate {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        Thread.sleep(5000);
        twoPhaseTermination.stop();
    }
}

class TwoPhaseTermination {
    private Thread monitor;
    // 启动监控线程
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    System.out.println("料理后事");
                    break;
                }
                try {
                    Thread.sleep(2000); // 第一种被打断，睡眠中
                    System.out.println("执行监控"); // 第二种被打断，执行任务时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 抛出异常后会重置标记位
                    currentThread.interrupt(); // 重新设置打断标记
                }
            }
        });
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
