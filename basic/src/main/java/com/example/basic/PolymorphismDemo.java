package com.example.basic;

public class PolymorphismDemo {
    public static void main(String[] args) {
        polymorphism();
        referenceTypeConversion();
    }

    /**
     * 多态
     */
    public static void polymorphism() {
        // 多态形式，创建对象
        Cat c = new Cat();
        Dog d = new Dog();
        // 调用showCatEat
        showCatEat(c);
        // 调用showDogEat
        showDogEat(d);
        // 以上两个方法, 均可以被showAnimalEat(Animal a)方法所替代,而执行效果一致
        showAnimalEat(c);
        showAnimalEat(d);
    }

    public static void showCatEat(Cat c) {
        c.eat();
    }

    public static void showDogEat(Dog d) {
        d.eat();
    }

    public static void showAnimalEat(Animal a) {
        a.eat();
    }

    /**
     * 引用类型转换
     */
    private static void referenceTypeConversion(){
        // 向上转型
        Animal a = new Cat();
        a.eat();  // 调用的是 Cat 的 eat
        // 向下转型
        // 向下转型
        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.catchMouse();       // 调用的是 Cat 的 catchMouse
        } else if (a instanceof Dog) {
            Dog d = (Dog) a;
            d.watchHouse();       // 调用的是 Dog 的 watchHouse
        }
    }
}