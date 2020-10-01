package com.example.basic;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // test();
        Scanner scanner = getScanner();
        System.out.println("请输入一个整数：");
        input(scanner);
    }

    private static void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int i = scanner.nextInt();
        System.out.println("你输入的是" + i);
    }

    private static Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    private static void input(Scanner sc) {
        int i = sc.nextInt();
        System.out.println("你输入的是" + i);
    }
}
