package com.example.advance.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int ticket = 100;

    private Object lock1 = new Object();

    private Lock lock2 = new ReentrantLock();

    @Override
    public void run() {
        sellTicket1();
        // sellTicket2();
        // sellTicket3();
    }

    /**
     * 第一种实现方式: 同步代码块
     */
    private void sellTicket1() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while (true) {
            synchronized (lock1) {
                if (ticket > 0) {//有票 可以卖
                    //出票操作
                    //使用sleep模拟一下出票时间
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto‐generated catch block
                        e.printStackTrace();
                    }
                    //获取当前线程对象的名字
                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖:" + ticket--);
                } else {
                    System.out.println("票都卖完了");
                    break;
                }
            }
        }
    }

    /**
     * 第二种实现方式: 同步方法
     */
    private synchronized void sellTicket2() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while (true) {
            if (ticket > 0) {//有票 可以卖
                //出票操作
                //使用sleep模拟一下出票时间
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto‐generated catch block
                    e.printStackTrace();
                }
                //获取当前线程对象的名字
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖:" + ticket--);
            } else {
                System.out.println("票都卖完了");
                break;
            }
        }
    }

    /**
     * 第二种实现方式: Lock 锁
     */
    private void sellTicket3() {
        //每个窗口卖票的操作
        //窗口 永远开启
        while (true) {
            lock2.lock();
            if (ticket > 0) {//有票 可以卖
                //出票操作
                //使用sleep模拟一下出票时间
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto‐generated catch block
                    e.printStackTrace();
                } finally {
                    lock2.unlock();
                }
                //获取当前线程对象的名字
                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖:" + ticket--);
            } else {
                System.out.println("票都卖完了");
                lock2.unlock();
                break;
            }
        }
    }
}
