package com.example.advance.threaddemo;

public class ChiHuo extends Thread {
    private BaoZi baoZi;
    private String name;

    public ChiHuo(BaoZi baoZi, String name) {
        super(name);
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        synchronized (baoZi) {
            if (baoZi.flag == false) {
                //没有包子
                try {
                    baoZi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("吃货正在吃" + baoZi.pier + baoZi.xianer + "包子");
                //标记包子被吃完
                baoZi.flag = false;
                baoZi.notify();
            }
        }
    }
}
