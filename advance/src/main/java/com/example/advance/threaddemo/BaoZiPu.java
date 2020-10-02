package com.example.advance.threaddemo;

public class BaoZiPu extends Thread {
    private BaoZi baoZi;

    public BaoZiPu(BaoZi baoZi, String name) {
        super(name);
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        int count = 0;

        synchronized (baoZi) {
            if (baoZi.flag == true) {
                try {
                    baoZi.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 没有包子 做包子
            System.out.println("包子铺开始做包子");
            if (count % 2 == 0) {
                // 冰皮  五仁
                baoZi.pier = "冰皮";
                baoZi.xianer = "五仁";
            } else {
                // 薄皮  牛肉大葱
                baoZi.pier = "薄皮";
                baoZi.xianer = "牛肉大葱";
            }
            count++;

            baoZi.flag = true;
            System.out.println("包子造好了：" + baoZi.pier + baoZi.xianer);
            System.out.println("吃货来吃吧");

            //唤醒等待线程 （唤醒吃货吃包子）
            baoZi.notify();
        }
    }
}
