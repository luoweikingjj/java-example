package com.example.basic;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo {
    public static void main(String[] args) {
        // randomInt();
        randomGame();
    }

    private static void randomInt(){
        Random random = new Random();
        //生成3个10以内的随机整数
        for (int i = 0; i < 3; i++) {
            int number = random.nextInt(10);
            System.out.println(number);
        }
    }

    private static void randomGame(){
        Random random = new Random();
        int number = random.nextInt(100)+1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你要猜的数字(1‐100)：");
            int guessNumber = scanner.nextInt();
            if (guessNumber > number) {
                System.out.println("你猜的数据" + guessNumber + "大了");
            } else if (guessNumber < number) {
                System.out.println("你猜的数据" + guessNumber + "小了");
            } else {
                System.out.println("恭喜你,猜中了");
                break;
            }
        }
    }
}
