package com.example.advance.functioninterface;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaParameterReturn {
    public static void main(String[] args) {
        parameterDemo(() -> System.out.println("线程任务执行！"));
        returnDemo();
    }

    private static void returnDemo() {
        String[] array = {"abc", "ab", "abcd"};
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, newComparator());
        System.out.println(Arrays.toString(array));
    }

    private static Comparator<String> newComparator() {
        // return new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return o2.length() - o1.length();
        //     }
        // };
        return (o1, o2) -> o2.length() - o1.length();
    }

    private static void parameterDemo(Runnable runnable) {
        new Thread(runnable).start();
    }
}
