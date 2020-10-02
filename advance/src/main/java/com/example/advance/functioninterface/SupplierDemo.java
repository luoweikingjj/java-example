package com.example.advance.functioninterface;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        // Supplier 接口使用
        SupplierInterfaceDemo();

        // 获取最大值
        getMaxDemo();
    }

    private static void getMaxDemo() {
        int[] arr = {1, 2, 3, 4, 5};
        int maxNum;
        maxNum = getMax(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int max = arr[0];
                for (int i : arr) {
                    if (i > max) {
                        max = i;
                    }
                }

                return max;
            }
        });
        System.out.println(maxNum);

        // 使用Lambda替换
        getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (i > max) {
                    max = i;
                }
            }

            return max;
        });
        System.out.println(maxNum);
    }

    private static void SupplierInterfaceDemo() {
        String string1 = "a";
        String string2 = "b";
        System.out.println(getString(string1 + string2));

        // 使用Supplier接口
        String s1 = getString1(new Supplier<String>() {
            @Override
            public String get() {
                return string1 + string2;
            }
        });
        System.out.println(s1);

        // 使用Lambda替换
        String s2 = getString1(() -> string1 + string2);
        System.out.println(s2);
    }

    private static String getString(String string) {
        return string;
    }

    private static String getString1(Supplier<String> stringSupplier) {
        return stringSupplier.get();
    }

    private static int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
