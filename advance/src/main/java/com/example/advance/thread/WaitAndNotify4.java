package com.example.advance.thread;

/**
 *
 等待唤醒案例:线程之间的通信
     创建一个顾客线程(消费者):告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，进入到WAITING状态(无限等待)
     创建一个老板线程(生产者):花了5秒做包子，做好包子之后，调用notify方法，唤醒顾客吃包子

 注意:
     顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
     同步使用的锁对象必须保证唯一
     只有锁对象才能调用wait和notify方法

 Object类中的方法
     void wait()
         在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
     void notify()
         唤醒在此对象监视器上等待的单个线程。会继续执行wait方法之后的代码
 */
public class WaitAndNotify4 {
    public static void main(String[] args) {
        // 创建锁对象
        Object object = new Object();
        // 创建一个顾客1线程（消费者）
        new Thread(){
            @Override
            public void run() {
                //一直吃包子
                while (true) {
                    // 保证等待和唤醒的进程只有一个在执行，需要使用同步技术
                    synchronized (object) {
                        System.out.println("顾客1告知老板要的包子的种类和数量");
                        try {
                            //调用wait方法，放弃cpu的执行，进入到WAITING状态(无限等待)
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //唤醒之后执行的代码
                        System.out.println("顾客1包子已经做好了，开吃!");
                        System.out.println("---------------------------------------");
                    }
                }
            }
        }.start();

        // 创建一个顾客2线程（消费者）
        new Thread(){
            @Override
            public void run() {
                //一直吃包子
                while (true) {
                    // 保证等待和唤醒的进程只有一个在执行，需要使用同步技术
                    synchronized (object) {
                        System.out.println("顾客2告知老板要的包子的种类和数量");
                        try {
                            //调用wait方法，放弃cpu的执行，进入到WAITING状态(无限等待)
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        //唤醒之后执行的代码
                        System.out.println("顾客2包子已经做好了，开吃!");
                        System.out.println("---------------------------------------");
                    }
                }
            }
        }.start();

        //创建一个老板线程(生产者)
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    //花了5秒做包子
                    try {
                        Thread.sleep(5000);//花5秒钟做包子
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (object){
                        System.out.println("老板5秒钟之后做好包子，告知顾客，可以吃包子了");
                        //做好包子之后，调用notifyAll方法，唤醒所有顾客吃包子
                        object.notifyAll();//唤醒所有等待线程
                    }
                }
            }
        }.start();
    }
}
