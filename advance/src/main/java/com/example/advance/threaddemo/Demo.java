package com.example.advance.threaddemo;

public class Demo {
    public static void main(String[] args) {
        // 准备包子的原材料
        BaoZi baoZi = new BaoZi();

        // 启动吃货线程，吃包子
        new ChiHuo(baoZi, "吃货1").start();

        // 启动包子铺线程，做包子
        new BaoZiPu(baoZi, "包子铺").start();
    }
}
