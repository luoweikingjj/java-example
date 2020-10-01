package com.example.basic;

public class ArrayDemo {
    public static void main(String[] args) {
        declareArray();
        operatorArray();
        iterator();

        int[] getArray = getArray();
        changeArray(getArray);
        printArray(getArray);
    }

    /**
     * 声明数组
     */
    private static void declareArray() {
        int[] ints = new int[3];
        int[] ints1 = new int[]{1, 2, 3};
        int[] ints2 = {1, 2, 3};

        float[] floats = new float[3];
        float[] floats1 = new float[]{1.1F, 1.2F, 1.3F};
        float[] floats2 = {1.1F, 1.2F, 1.3F};
    }

    /**
     * 操作数组
     */
    private static void operatorArray() {
        int[] ints = new int[3];

        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        // ints[3] = 4;//越界

        System.out.println(ints.length);
    }

    /**
     * 迭代数组
     */
    private static void iterator() {
        int[] ints = {1, 2, 3};
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 获取数组
     *
     * @return int
     */
    private static int[] getArray() {
        int[] ints = {1, 2, 3};
        return ints;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 改变数组
     *
     * @param arr
     */
    private static void changeArray(int[] arr) {
        arr[0] = 1000;
    }
}
