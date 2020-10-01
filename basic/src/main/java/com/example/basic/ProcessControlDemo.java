package com.example.basic;

public class ProcessControlDemo {
    public static void main(String[] args) {
//        ifStatement();
//        ifElseStatement();
//        ifElseIfStatement();
//        switchStatement();
//        forStatement();
//        whileStatement();
//        doWhileStatement();
        loopNesting();
    }

    private static void ifStatement() {
        System.out.println("开始");
        // 定义两个变量
        int a = 10;
        int b = 20;
        //变量使用if判断
        if (a == b) {
            System.out.println("a等于b");
        }
        int c = 10;
        if (a == c) {
            System.out.println("a等于c");
        }
        System.out.println("结束");
    }

    private static void ifElseStatement() {
        // 判断给定的数据是奇数还是偶数
        // 定义变量
        int a = 1;
        if (a % 2 == 0) {
            System.out.println("a是偶数");
        } else {
            System.out.println("a是奇数");
        }
        System.out.println("结束");
    }

    private static void ifElseIfStatement() {
        int score = 100;
        if (score < 0 || score > 100) {
            System.out.println("你的成绩是错误的");
        } else if (score >= 90 && score <= 100) {
            System.out.println("你的成绩属于优秀");
        } else if (score >= 80 && score < 90) {
            System.out.println("你的成绩属于好");
        } else if (score >= 70 && score < 80) {
            System.out.println("你的成绩属于良");
        } else if (score >= 60 && score < 70) {
            System.out.println("你的成绩属于及格");
        } else {
            System.out.println("你的成绩属于不及格");
        }
    }

    private static void switchStatement() {
        //定义变量，判断是星期几
        int weekday = 6;
        //switch语句实现选择
        switch (weekday) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("你输入的数字有误");
                break;
        }
    }

    private static void forStatement() {
        //1.定义一个初始化变量,记录累加求和,初始值为0
        int sum = 0;
        //2.利用for循环获取1‐100之间的数字
        for (int i = 1; i <= 100; i++) {
            //3.判断获取的数组是奇数还是偶数
            if (i % 2 == 0) {
                //4.如果是偶数就累加求和
                sum += i;
            }
        }
        //5.循环结束之后,打印累加结果
        System.out.println("sum:" + sum);
    }

    private static void whileStatement() {
        //while循环实现打印10次HelloWorld
        //定义初始化变量
        int i = 1;
        //循环条件<=10
        while (i <= 10) {
            System.out.println("HelloWorld");
            //步进
            i++;
        }
    }

    private static void doWhileStatement() {
        int x = 1;
        do {
            System.out.println("HelloWorld" + x);
            x++;
        } while (x <= 10);
    }

    private static void loopNesting() {
        //5*8的矩形，打印5行*号，每行8个
        //外循环5次，内循环8次
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                //不换行打印星号
                System.out.print("*");
            }
            //内循环打印8个星号后，需要一次换行
            System.out.println();
        }
    }
}
