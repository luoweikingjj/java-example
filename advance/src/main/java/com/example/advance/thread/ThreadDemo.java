package com.example.advance.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        runDemo();
        runnableDemo();
        anonymousFunctionRunnable();
    }

    private static void runDemo() {
        Thread thread = new MyThread("新的线程！");
        thread.start();

        //在主方法执行for循环
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程！" + i);
        }
    }

    private static void runnableDemo() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "新的线程！");
        thread.start();

        //在主方法执行for循环
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程！" + i);
        }
    }

    private static void anonymousFunctionRunnable() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "：正在执行！" + i);
                }
            }
        }, "新的线程！");
        thread.start();

        //在主方法执行for循环
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程！" + i);
        }
    }
}
