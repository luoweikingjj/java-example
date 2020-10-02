package com.example.advance.thread;

public class ThreadStatus {
    private static Object obj = new Object();

    public static void main(String[] args) {
        // 等待线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "=== 获取到锁对象，调用wait方法，进入waiting状态，释放锁对象");
                            obj.wait();  //无限等待
                            //obj.wait(5000); //计时等待, 5秒 时间到，自动醒来
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "=== 从waiting状态醒来，获取到锁对象，继续执行了");
                    }
                }
            }
        }, "等待线程").start();

        // 唤醒线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // while (true){   //每隔3秒 唤醒一次
                    try {
                        System.out.println(Thread.currentThread().getName() + "‐‐‐‐‐ 等待3秒钟");
                        Thread.sleep(3000);//睡眠3秒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName() + "‐‐‐‐‐ 获取到锁对象, 调用notify方法，释放锁对象");
                        obj.notify();// 唤醒 等待线程
                    }
                // }
            }
        }, "唤醒线程").start();
    }
}
