package com.example.advance.methodreference;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 初始
        String printStr = "test";
        printString(printStr, new PrintInterface() {
            @Override
            public void print(String string) {
                System.out.println(string);
            }
        });
        System.out.println("-----------------");

        // Lambda
        printString(printStr, string -> System.out.println(string)); // test
        System.out.println("-----------------");

        // 1. 方法引用  使用 `::` 来调用。上面 Lambda 只用到了 System.out.println ，所以直接用 System.out::println 来替换掉
        printString(printStr, System.out::println); // test
        System.out.println("-----------------");

        // 2. 对象名引用成员方法
        // 2.1 常规打印
        printUpperCaseString1(printStr); // TEST
        // 2.2 使用Lambda
        printUpperCaseString2(printStr, string -> System.out.println(string)); // TEST
        // 使用这个 printUpperCase 成员方法来替代 Printable 接口的
        ObjectReference objectReference = new ObjectReference();
        printUpperCaseString2(printStr, objectReference::printUpperCase); // TEST
        System.out.println("-----------------");

        // 3. 类名称引用静态方法
        int printInt = -10;
        printInteger(printInt, new Calcable() {
            @Override
            public int calc(Integer integer) {
                return Math.abs(integer);
            }
        }); //10
        printInteger(printInt, integer -> Math.abs(integer)); //10
        printInteger(printInt, Math::abs);// 10

        // 4. 通过super引用成员方法
        // 5. 通过this引用成员方法
        // 查看superdemo.Man

        // 6. 类的构造器引用 查看constructordemo.ConstructorDemo

        // 7. 数组的构造器引用 查看arraydemo.ArrayDemo
    }

    private static void printInteger(Integer integer, Calcable printIntegerInterface) {
        System.out.println(printIntegerInterface.calc(integer));;
    }

    private static void printUpperCaseString2(String string, PrintInterface printInterface) {
        printInterface.print(string.toUpperCase());
    }

    private static void printUpperCaseString1(String string) {
        System.out.println(string.toUpperCase());
    }

    private static void printString(String string, PrintInterface printInterface) {
        printInterface.print(string);
    }
}
